/**
 * This program calculates various geometric properties such as the hypotenuse of a right triangle,
 * circumference and area of a circle, and volume of a sphere. It also identifies the largest number entered.
 */

import java.util.*;
public class GeometryCalculator 
{
    public static void main(String args[]) 
    {
        Scanner numbers=new Scanner(System.in);
        double a=0; // First leg of the triangle
        double b=0; // Second leg of the triangle
        double d=0; // Radius of the circle
        // Input for the triangle legs
        System.out.print("Enter the first leg of the triangle\t\t");
        a=numbers.nextDouble();
        System.out.print("Enter the second leg of the triangle\t");
        b=numbers.nextDouble();
        // Calculate the hypotenuse of the triangle
        double c=Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
        System.out.print("The hypotenuse of the triangle is ");
        System.out.printf("%.2f",c);
        // Input for the circle radius
        System.out.print("\n\nEnter the the radius of a circle ");
        d=numbers.nextDouble();
        // Calculate the circumference of the circle
        double e=2.0*Math.PI*d;
        System.out.print("The circumference of the circle is ");
        System.out.printf("%.2f",e);
        // Calculate the area of the circle
        double f=Math.PI*Math.pow(d,2);
        System.out.print("\nThe area of the circle is ");
        System.out.printf("%.2f",f);
        // Calculate the volume of the sphere
        double g=(4.0/3.0)*Math.PI*Math.pow(d,3);
        System.out.print("\nThe volume of sphere is ");
        System.out.printf("%.2f",g);
        System.out.println("\n-----------");
        System.out.println("Extra");
        // Identify the largest number entered
        System.out.print("\nThe largest number entered was ");
        System.out.printf("%.2f",Math.max(Math.max(a,b),d));
    }
}