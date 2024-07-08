// This program calculates the minimum number of bills and coins needed for a given amount of money.
// It continuously prompts the user to input an amount and displays the breakdown in bills and coins until a negative value is entered.

import java.util.*;
public class BillMinimizer 
{
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        double c = 0;

        // Continue prompting the user until a negative value is entered
        while (c >= 0) 
        {
            System.out.print("\nHow much money?\t$");
            c = input.nextDouble();

            // Print the breakdown of bills
            System.out.println("Bills");
            System.out.println("-----------");
            bills(c);

            // Print the breakdown of coins
            System.out.println("\nCoins");
            System.out.println("-----------");
            coins(c);
        }
    }

    // Method to calculate and print the number of each bill required
    static void bills(double e) 
    {
        int a = (int)e;
        System.out.println("Hundreds:\t\t" + (a / 100));
        a = a % 100;
        System.out.println("Fifties:\t\t" + (a / 50));
        a = a % 50;
        System.out.println("Twenties:\t\t" + (a / 20));
        a = a % 20;
        System.out.println("Tens:\t\t\t" + (a / 10));
        a = a % 10;
        System.out.println("Fives:\t\t\t" + (a / 5));
        a = a % 5;
        System.out.println("Ones:\t\t\t" + (a / 1));
    }

    // Method to calculate and print the number of each coin required
    static void coins(double f) 
    {
        double b = 0;
        int d = 0;
        int x = 0;

        // Handle cases where the amount is less than 1 dollar or more
        if (f < 1.0) 
        {
            b = f * 100;
            x = (int)b;
        } 
        else 
        {
            b = f;
            d = (int)b;
            b = b % d;
            b *= 100;
            x = (int)b;
        }

        // Print the breakdown of coins
        System.out.println("Quarters:\t\t" + (x / 25));
        x = x % 25;
        System.out.println("Dimes:\t\t\t" + (x / 10));
        x = x % 10;
        System.out.println("Nickels:\t\t" + (x / 5));
        x = x % 5;
        System.out.println("Pennies:\t\t" + (x / 1));
    }
}
