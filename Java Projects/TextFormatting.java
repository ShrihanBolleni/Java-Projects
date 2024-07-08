/**
 * This program displays quotes stored in an ArrayList and provides options to display all quotes or a random quote.
 */

import java.util.*;
public class TextFormatting
{
	static ArrayList<Quote> quoteList = new ArrayList<Quote>();
    // Populates the quote list with example quotes.
	public static void populateList()
	{
        //Example Quotes
		quoteList.add(new Quote("Grace Hopper","To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge."));
		quoteList.add(new Quote("Edsger Dysktra","The question of whether a computer can think is no more interesting than the question of whether a submarine can swim."));
		quoteList.add(new Quote("Ada Lovelace","I never am really satisfied that I understand anything; because, understand it well as I may, my comprehension can only be an infinitesimal fraction of all I want to understand about the many connections and relations which occur to me, how the matter in question was first thought of or arrived atů"));
		quoteList.add(new Quote("Alan Turing","One day [people] will take their computers for walks in the park and tell each other, \"My little computer said such a funny thing this morning\"."));
	}
	public static void main(String args[])
	{
		populateList();
		menu();
	}
    // Displays the menu and handles user choices.
	public static void menu()
	{
		int choice=0;
		while(choice!=3)
		{
			System.out.println("1) Display all quotes");
			System.out.println("2) Display a random quote");
			System.out.println("3) Exit");
			System.out.print("Select an option\t");
			Scanner input = new Scanner(System.in);
			choice=input.nextInt();
			if(choice==1)
			{
                for(int i=0;i<quoteList.size();i++)
                quoteList.get(i).displayQuote();
			}
			if(choice==2)
			{
                int r=(int)(Math.random()*quoteList.size());
                quoteList.get(r).displayQuote();
			}
		}
	}
}

// Represents a quote with a name and the quote text.
class Quote
{
    String q;
    String n;

    /**
     * Initializes the quote with a name and the quote text.
     * @param name The name of the person who said the quote
     * @param quote The quote text
     */
    Quote(String name,String quote)
    {
        q=quote;
        n=name;
    }
    // Displays the quote in a formatted manner.
    void displayQuote()
    {
        int d=0;
        int a=56; // Maximum length of a line
        int b=0; 
        for(int i=0;i<60;i++)
        System.out.print("=");
        while(d==0)
        {
            System.out.print("\n| ");
            if(q.length()>a&&q.substring(a,a+1).equals(" "))
            {
                System.out.print(q.substring(b,a));
                System.out.print(" |");
            }
            else if(q.length()<=a)
            {
                int e=0;
                while(q.length()<a)
                {
                    a--;
                    e++;
                }
                System.out.print(q.substring(b,a));
                for(int i=0;i<e;i++)
                System.out.print(" ");
                System.out.print(" |");
                d+=1;
            }
            else
            {
                int c=0;
                while(!q.substring(a,a+1).equals(" "))
                {
                    a--;
                    c++;
                }
                System.out.print(q.substring(b,a));
                for(int i=0;i<c;i++)
                System.out.print(" ");
                System.out.print(" |");
            }
            b=a;
            a+=56;
        }
        System.out.print("\n| ");
        for(int i=0;i<56-(n.length()+2);i++)
            System.out.print(" ");
        System.out.print("- "+n);
        System.out.print(" |\n");
        for(int i=0;i<60;i++)
            System.out.print("=");
        System.out.println("\n");
    }
}