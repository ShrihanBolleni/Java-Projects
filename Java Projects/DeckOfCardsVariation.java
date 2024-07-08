/**
 * This program simulates a deck of cards and provides functionality 
 * to create, display, shuffle, and sort the deck.
 */

import java.util.*;
public class DeckOfCardsVariation 
{
    public static void main(String args[]) {
      ArrayList<Card> D1=new ArrayList<Card>();
      D1=create();
      System.out.println("Original Deck");
      display(D1);
      System.out.println("\nShuffled Deck");
      shuffle(D1);
      display(D1);
      System.out.println("\nSorted Deck");
      D1=sort(D1);
      display(D1);
    }
    
    // Method to create a new deck of cards
    public static ArrayList<Card> create()
    {
        int b=0;
        int a=0;
        int[] points={11,2,3,4,5,6,7,8,9,10,10,10,10};
        String[] names={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suits={"H","D","C","S"};
        ArrayList<Card> Deck=new ArrayList<Card>();
        // Create all 52 cards
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
        return Deck;
    }
    
    // Method to display the deck of cards
    public static void display(ArrayList<Card> Deck1)
    {
        for(int i=0;i<Deck1.size();i++)
        System.out.print((Deck1.get(i)).getcard()+" ");
    }
    
    // Method to shuffle the deck of cards
    public static void shuffle(ArrayList<Card> Deck1)
    {
        for(int i=0;i<Deck1.size();i++)
        {
            int e=(int)(Math.random()*Deck1.size());
            Card f=Deck1.set(i,Deck1.get(e));
            Deck1.set(e,f);
        }
    }
    
    // Method to sort the deck of cards by suit
    public static ArrayList<Card> sort(ArrayList<Card> Deck1)
    {
        ArrayList<Card> Deck=new ArrayList<Card>();
        for(int i=0;i<Deck1.size();i++)
        {
            if(Deck1.get(i).getSuit().compareTo("H")==0)
            Deck.add(Deck1.get(i));
        }
        for(int i=0;i<Deck1.size();i++)
        {
            if(Deck1.get(i).getSuit().compareTo("D")==0)
            Deck.add(Deck1.get(i));
        }
        for(int i=0;i<Deck1.size();i++)
        {
            if(Deck1.get(i).getSuit().compareTo("C")==0)
            Deck.add(Deck1.get(i));
        }
        for(int i=0;i<Deck1.size();i++)
        {
            if(Deck1.get(i).getSuit().compareTo("S")==0)
            Deck.add(Deck1.get(i));
        }
        return Deck;
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