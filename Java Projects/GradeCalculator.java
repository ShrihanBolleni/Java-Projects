/**
 * This program calculates the final grade based on the scores obtained in three parts of an exam.
 * It prompts the user to input the number of correct answers and total points available for each part.
 */

import java.util.*;
public class GradeCalculator 
{
    public static void main(String args[]) 
    {
      double a=0; // Number of correct answers in part a
      double b=0; // Total points available in part a
      double c=0; // Number of correct answers in part b
      double d=0; // Total points available in part b
      double e=0; // Number of correct answers in part c
      double f=0; // Total points available in part c
      Scanner numbers=new Scanner(System.in);
      // Input for part a
      System.out.print("How many were right in part a?\t\t\t\t");
      a=numbers.nextInt();
      System.out.print("How many points were available in part a?\t");
      b=numbers.nextInt();
      // Input for part b
      System.out.print("How many were right in part b?\t\t\t\t");
      c=numbers.nextInt();
      System.out.print("How many points were available in part b?\t");
      d=numbers.nextInt();
      // Input for part c
      System.out.print("How many were right in part c?\t\t\t\t");
      e=numbers.nextInt();
      System.out.print("How many points were available in part c?\t");
      f=numbers.nextInt();
      System.out.println("\n---------");
      // Calculate the percentage scores for each part
      double a1=(a/b)*100;
      double a2=(c/d)*100;
      double a3=(e/f)*100;
      // Round the percentage scores to the nearest whole number
      double g=(int)(a1+.5);
      double h=(int)(a2+.5);
      double i=(int)(a3+.5);
      // Calculate the final grade
      double a4=(g+h+i)/3.0;
      int fg=(int)(a4+.5);
      int g1=(int)g;
      int h1=(int)h;
      int i1=(int)i;
      // Display the scores and final grade
      System.out.println("\nPart A\t\t:"+g1);
      System.out.println("Part B\t\t:"+h1);
      System.out.println("Part C\t\t:"+i1);
      System.out.println("\nFinal Grade\t:"+fg);
    }
}