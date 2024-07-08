// This program simulates a card deck where players can draw cards, display the deck, and reset the deck.
// The program interacts with the user to perform these actions until the user chooses to exit.

import java.util.*;
public class CardDeckArray 
{
    public static void main(String args[]) {
        Deck d = new Deck();
        Scanner input = new Scanner(System.in);
        int choice = 1;

        // Continue prompting the user for actions until they choose to exit
        while (choice > 0 && choice < 5) 
        {
            System.out.println("\n1) Display the player's hand and points");
            System.out.println("2) Display the deck");
            System.out.println("3) Pull a card from the deck");
            System.out.println("4) Reset");
            System.out.println("5) Exit");
            System.out.print("Pick an option (1-4)\t");
            choice = input.nextInt();

            // Execute the chosen action
            if (choice == 1) 
            {
                d.playerHand();
                System.out.println("Total Points : " + d.dp());
            }
            if (choice == 2) 
            {
                d.displayDeck();
            }
            if (choice == 3) 
            {
                d.remove();
            }
            if (choice == 4) 
            {
                d.reset();
            }
        }
    }
}

class Card 
{
    int p;
    String n;
    String s;

    // Constructor to initialize a card with points, name, and suit
    Card(int p1, String n1, String s1) 
    {
        p = p1;
        n = n1;
        s = s1;
    }

    // Method to return the card as a string
    String getcard() 
    {
        return n + s;
    }

    // Method to return the points of the card
    int getpoints() 
    {
        return p;
    }
}

class Deck 
{
    int b = 0;
    int a = 0;
    int y = 0;
    Card[] Deck = new Card[52];
    Card[] D1 = new Card[52];
    Card[] D2;
    Card[] ph = new Card[52];
    int[] points = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    String[] names = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] suits = {"H", "D", "C", "S"};

    // Constructor to initialize the deck with cards
    Deck() 
    {
        while (b < 51) 
        {
            for (int k = 0; k < suits.length; k++) 
            {
                for (int j = 0; j < names.length; j++) 
                {
                    Deck[b] = new Card(points[j], names[j], suits[k]);
                    D1[b] = Deck[b];
                    b += 1;
                }
            }
        }
    }

    // Method to reset the deck to its original state
    void reset() 
    {
        Deck = D1;
    }

    // Method to return the total points of the player's hand
    int dp() 
    {
        return a;
    }

    // Method to remove a card from the deck and add it to the player's hand
    void remove() 
    {
        int z = (int)(Math.random() * Deck.length - 0);
        Card f = Deck[z];
        ph[y] = f;
        System.out.println("Card Pulled: " + Deck[z].getcard());
        a += f.getpoints();
        D2 = new Card[Deck.length - 1];
        for (int i = 0; i < z; i++) 
        {
            D2[i] = Deck[i];
        }
        for (int i = z + 1; i < Deck.length; i++) 
        {
            D2[i - 1] = Deck[i];
        }
        Deck = D2;
        y += 1;
    }

    // Method to display the remaining cards in the deck
    void displayDeck() 
    {
        for (int i = 0; i < Deck.length; i++) 
        {
            System.out.print(Deck[i].getcard() + " ");
        }
    }

    // Method to display the player's hand
    void playerHand() 
    {
        for (int i = 0; i <= y - 1; i++) 
        {
            System.out.print(ph[i].getcard() + "\t");
        }
    }
}
