/**
 * This program calculates the prime factors of a given number.
 * It prompts the user to enter a number and continuously calculates its prime factors until a non-positive number is entered.
 */

import java.util.*;
public class PrimeFactors 
{
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int c=1;
        while(c>=1)
        {
            System.out.print("\nEnter a number\t");
            c=input.nextInt();
            primeFactors(c);
        }
    }
    /**
     * Calculates and displays the prime factors of a given number.
     * @param a The number for which prime factors need to be calculated
     */
    static void primeFactors(int a)
    {
        for(int i=2;i<a-1;i++)
        {
            if(a%i==0)
            {
                System.out.print(i+" ");
                primeFactors(a/i);
                return;
            }
        }
        System.out.print(a);
    }
}
