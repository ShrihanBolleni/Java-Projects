/**
 * This program simulates a card deck using an array. 
 * It provides a menu-driven interface for various operations 
 * such as displaying the cards, putting the cards in order, 
 * checking if the cards are in order, and adding a new card.
 */

import java.util.*;
public class CardDeckArrayVariation 
{
    public static void main(String args[]) {
      Deck d=new Deck();
      boolean a;
      Scanner input=new Scanner(System.in);
      int choice=1;
      // Display menu and handle user choices
      while(choice>0&&choice<5)
      {
          System.out.println("\n1) Display the cards");
          System.out.println("2) Put the cards in order");
          System.out.println("3) Are they in order?");
          System.out.println("4) Add a new card");
          System.out.println("5) Exit");
          System.out.print("Pick an option (1-5)\t");
          choice=input.nextInt();
          if(choice==1)
          {
          d.displayDeck3();
          }
          if(choice==2)
          {
          d.orderDeck();
          a=d.checkOrder();
          }
          if(choice==3)
          {
          a=d.checkOrder();
          if(a==true)
          {
          System.out.print("The cards are in order: ");
          d.displayDeck3();
          }
          else
          {
          System.out.print("The cards are out of order: ");
          d.displayDeck3();
          }
          }
          if(choice==4)
          {
          a=d.checkOrder();
          d.addCard();
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
    int getpoints()
    {
        return p;
    }
}

// Class to represent a deck of cards
class Deck
{
    int b=0; // Counter for the total number of cards in the deck
    int a=0; // Points in the player's hand
    int y=0; // Counter for the player's hand
    boolean v; // Boolean flag for order check
    Card[] Deck=new Card[52]; // Original deck of cards
    Card[] D1=new Card[52]; // Copy of the original deck
    Card[] D2; // Temporary deck for removing cards
    Card[] ph=new Card[52]; // Player's hand
    Card[] D3=new Card[5]; // Subset of the deck
    int[] points={11,2,3,4,5,6,7,8,9,10,10,10,10};
    String[] names={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    String[] suits={"H","D","C","S"};
    Deck()
    {
        // Initialize the deck with 52 cards
        while(b<51)
        {
            for(int k=0;k<suits.length;k++)
            {
                for(int j=0;j<names.length;j++)
                {
                    Deck[b]=new Card(points[j],names[j],suits[k]);
                    D1[b]=Deck[b];
                    b+=1;
                }
            }
        }
        // Randomly select 5 cards for D3
        for(int i=0;i<D3.length;i++)
        {
            int s=(int)(Math.random()*Deck.length);
            D3[i]=Deck[s];
        }
    }
    
    void reset()
    {
        Deck=D1;
    }
    
    int dp()
    {
        return a;
    }
    
    // Remove a random card from the deck and add it to the player's hand
    void remove()
    {
        int z=(int)(Math.random()*Deck.length-0);
        Card f=Deck[z];
        ph[y]=f;
        System.out.println("Card Pulled: "+Deck[z].getcard());
        a+=f.getpoints();
        D2=new Card[Deck.length-1];
        for(int i=0;i<z;i++)
        {
            D2[i]=Deck[i];
        } 
        for(int i=z+1;i<Deck.length;i++)
        {
            D2[i-1]=Deck[i];
        }
        Deck=D2;
        y+=1;
    }
    void displayDeck()
    {
        for(int i=0;i<Deck.length;i++)
        System.out.print(Deck[i].getcard()+" ");
    }
    void playerHand()
    {
        for(int i=0;i<=y-1;i++)
        System.out.print(ph[i].getcard()+"\t");
    }
    // Check if the subset of the deck (D3) is in order
    boolean checkOrder()
    {
        v=true;
        for(int i=0;i<D3.length-1;i++)
        {
            for(int j=i+1;j<D3.length;j++)
            {
                if(D3[i].getpoints()>D3[j].getpoints())
                {
                v=false;
                return false;
                }
            }
        }
        return true;
    }
    void displayDeck3()
    {
        for(int i=0;i<D3.length;i++)
        System.out.print(D3[i].getcard()+" ");
    }
    // Order the subset of the deck (D3) by points
    void orderDeck()
    {
        for(int i=0;i<D3.length-1;i++)
        {
            for(int j=i+1;j<D3.length;j++)
            {
                if(D3[i].getpoints()>D3[j].getpoints())
                {
                Card x=D3[i];    
                D3[i]=D3[j];
                D3[j]=x;
                }
            }
            System.out.println("\n"+D3[i].getcard()+" is the smallest");
            for(int k=0;k<D3.length;k++)
            System.out.print(D3[k].getcard()+" ");
        }
    }
    // Add a new card to the subset of the deck (D3)
    void addCard()
    {
        int g=(int)(Math.random()*Deck.length);
        Card h=Deck[g];
        if(v==false)
        {
            Card[] temp=new Card[D3.length+1];
            for(int i=1;i<temp.length;i++)
            temp[i]=D3[i-1];
            temp[0]=h;
            D3=temp;
            System.out.println(h.getcard()+" was added to index 0");
        }
        else
        {
        Card[] temps=new Card[D3.length+1];
        int i=0;
        while(i<D3.length&&D3[i].getpoints()<=h.getpoints())
        {
            temps[i]=D3[i];
            i+=1;
        }
        temps[i]=h;
        System.out.println(h.getcard()+" was added to index "+i);
        i+=1;
        for(int j=i;j<temps.length;j++)
        temps[j]=D3[j-1];
        D3=temps;
        }
    }
}