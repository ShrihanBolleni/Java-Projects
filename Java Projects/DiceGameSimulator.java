/**
 * This program simulates a dice game where the player bets on the outcome of rolling two dice.
 * The player starts with a certain amount of money and bets $1 on each roll.
 * If the sum of the dice is 7, the player wins $4; otherwise, the player loses $1.
 * The program displays the number of rolls it took for the player to go broke
 * and the number of rolls when the player should have quit with the highest amount of money.
 */

import java.util.*;
public class DiceGameSimulator 
{
    public static void main(String args[]) {
        Scanner num=new Scanner(System.in);
        System.out.print("How many dollars do you have?\t");
        int b=num.nextInt();
        dice(b);
    }
    
    // Method to simulate the dice game
    public static void dice(int a)
    {
        int e=0; // Counter for the number of rolls
        int mm=0; // Maximum money held by the player
        int f=0; // Roll number when the player should have quit
        // Continue playing until the player is broke
        while(a>0)
        {
            int c=(int)(Math.random()*6+1); // Roll of the first die
            int d=(int)(Math.random()*6+1); // Roll of the second die
            e++; // Increment the roll counter
            // If the sum of the dice is 7, the player wins $4; otherwise, the player loses $1
            if(c+d==7)
                a+=4;
            else
                a-=1;
            // Update the maximum money held by the player and the corresponding roll number
            if(a>mm)
            {
                mm=a;
                f=e;
            }
        }
        System.out.println("You are broke after "+e+" rolls.");
        System.out.println("You should have quit after "+f+" rolls when you had "+mm+" dollars.");
    }
}