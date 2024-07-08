/**
 * This program simulates a card deck using an ArrayList. 
 * It provides a menu-driven interface for various operations 
 * such as displaying the cards, resetting the deck, sorting the deck, 
 * deleting a suit, shuffling the deck, and pulling a card.
 */

import java.util.*;
public class CardDeckArrayList 
{
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int b=0; // Counter for the total number of cards in the deck
        int a=0; // Number of cards the user wants in the deck
        int[] points={11,2,3,4,5,6,7,8,9,10,10,10,10};
        String[] names={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suits={"H","D","C","S"};
        ArrayList<Card> Deck=new ArrayList<Card>(); // Original deck of cards
        ArrayList<Card> Deck1=new ArrayList<Card>(); // Deck to be used in operations
        ArrayList<Card> ph=new ArrayList<Card>(); // Player's hand
        // Initialize the deck with 52 cards
        while(b<52)
        {
            for(int k=0;k<suits.length;k++)
            {
                for(int j=0;j<names.length;j++)
                {
                    Deck.add(new Card(points[j],names[j],suits[k]));
                    b+=1;
                }
            }
        }
        int choice=1;
        // Display menu and handle user choices
        while(choice>0&&choice<7)
        {
            System.out.println("\n1) Display the cards");
            System.out.println("2) Reset the deck");
            System.out.println("3) Sort the deck");
            System.out.println("4) Delete a suit");
            System.out.println("5) Shuffle the deck");
            System.out.println("6) Pull a card");
            System.out.println("7) Exit");
            System.out.print("Pick an option\t");
            choice=input.nextInt();
            if(choice==1)
            {
                int d=0;
                System.out.print("The deck has "+Deck1.size()+" cards in it : \n");
                for(int i=0;i<Deck1.size();i++)
                System.out.print((Deck1.get(i)).getcard()+" ");
                System.out.print("\nThe player has "+ph.size()+" cards: \n");
                for(int i=0;i<ph.size();i++)
                System.out.print((ph.get(i)).getcard()+" ");
                for(int i=0;i<ph.size();i++)
                d+=ph.get(i).getpoints();
                System.out.print("Total value = "+d);
            }
            if(choice==2)
            {
                Deck1=new ArrayList<Card>();
                ph=new ArrayList<Card>();
                System.out.print("How many cards do you want in the deck?\t");
                a=input.nextInt();
                while(a<0||a>Deck.size())
                {
                    System.out.print("How many cards do you want in the deck?\t");
                    a=input.nextInt();
                }
                for(int i=0;i<a;i++)
                {
                    int c=(int)(Math.random()*(Deck.size()-1));
                    Deck1.add(Deck.get(c));
                    Deck.remove(c);
                }
            }
            if(choice==3)
            {
                for(int i=0;i<Deck1.size()-1;i++)
                {
                    for(int j=i+1;j<Deck1.size();j++)
                    {
                        if(Deck1.get(i).getpoints()>Deck1.get(j).getpoints())
                        {
                        Card x=Deck1.set(i,Deck1.get(j));
                        Deck1.set(j,x);
                        }
                    }
                }
            }
            if(choice==4)
            {
                System.out.println("\n\n1) Hearts");
                System.out.println("2) Diamonds");
                System.out.println("3) Clubs");
                System.out.println("4) Spades");
                System.out.print("Which suit do you want to delete?\t\t");
                int c=input.nextInt();
                ArrayList<Card> dt=new ArrayList<Card>();
                if(c==1)
                {
                    for(int i=Deck1.size()-1;i>=0;i--)
                    {
                        if(Deck1.get(i).getSuit().equals("H"))
                        Deck1.remove(i);
                    }
                }
                else if(c==2)
                {
                    for(int i=Deck1.size()-1;i>=0;i--)
                    {
                        if(Deck1.get(i).getSuit().equals("D"))
                        Deck1.remove(i);
                    }
                }
                else if(c==3)
                {
                    for(int i=Deck1.size()-1;i>=0;i--)
                    {
                        if(Deck1.get(i).getSuit().equals("C"))
                        Deck1.remove(i);
                    }
                }
                else if(c==4)
                {
                    for(int i=Deck1.size()-1;i>=0;i--)
                    {
                        if(Deck1.get(i).getSuit().equals("S"))
                        Deck1.remove(i);
                    }
                }
            }
            if(choice==5)
            {
                for(int i=0;i<Deck1.size();i++)
                {
                    int e=(int)(Math.random()*Deck1.size());
                    Card f=Deck1.set(i,Deck1.get(e));
                    Deck1.set(e,f);
                }
            }
            if(choice==6)
            {
                int p=ph.size();
                int g=(int)(Math.random()*Deck1.size());
                if(Deck1.size()==0)
                System.out.println("There are no cards left in the deck.");
                else if(ph.size()==0)
                {
                    ph.add(Deck1.get(g));
                    System.out.println("Pulled : "+Deck1.get(g).getcard());
                    Deck1.remove(g);
                }
                else if(ph.size()>0)
                {
                    int n=0;
                    while(n<ph.size()&&ph.size()==p)
                    {
                        if(Deck1.get(g).getpoints()<ph.get(n).getpoints())
                        ph.add(n,Deck1.get(g));
                        n++;
                    }
                    if(n==ph.size()&&p==ph.size())
                    ph.add(Deck1.get(g));
                    System.out.println("Pulled : "+Deck1.get(g).getcard());
                    Deck1.remove(g);
                }
            }
        }
    }
}

// Class to represent a single card
class Card
{
    int p; // Points of the card
    String n; // Name of the card (e.g., A, 2, J)
    String s; // Suit of the card (e.g., H, D, C, S)
    Card(int p1,String n1,String s1)
    {
        p=p1;
        n=n1;
        s=s1;
    }
    String getcard()
    {
        return n+s;
    }
    String getSuit()
    {
        return s;
    }
    int getpoints()
    {
        return p;
    }
}