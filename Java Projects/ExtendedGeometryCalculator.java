/**
 * This program extends the functionality of the Geometry Calculator by adding methods to calculate 
 * the surface area and volume of a cylinder and a cone based on user input for radius and height.
 */

import java.util.*;
public class ExtendedGeometryCalculator 
{
    public static void main(String args[]) 
    {
        Scanner numbers=new Scanner(System.in);
        double a=0; // Radius of the cylinder/cone
        double b=0; // Height of the cylinder/cone
        // Input for the radius and height
        System.out.print("Enter the radius\t\t");
        a=numbers.nextDouble();
        System.out.print("Enter the height\t\t");
        b=numbers.nextDouble();
        // Calculate the surface area of a cylinder
        double c=CylinderSA(a,b);
        System.out.print("\nThe surface area of a cylinder is ");
        System.out.printf("%.2f",c);
        // Calculate the surface area of a cone
        double e=ConeSA(a,b);
        System.out.print("\nThe surface area of a cone is ");
        System.out.printf("%.2f",e);
        // Calculate the volume of the cylinder
        double f=CylinderV(a,b);
        System.out.print("\n\nThe volume of the cylinder is ");
        System.out.printf("%.2f",f);
        // Calculate the volume of the cone
        double g=ConeV(a,b);
        System.out.print("\nThe volume of cone is ");
        System.out.printf("%.2f",g);
    }
    // Method to calculate the area of a circle
    public static double area(double a1)
    {
        return Math.PI*Math.pow(a1,2);
    }
    // Method to calculate the surface area of a cylinder
    public static double CylinderSA(double a2,double b1)
    {
        return 2.0*Math.PI*a2*(b1+a2);
    }
    // Method to calculate the surface area of a cone
    public static double ConeSA(double a3,double b2)
    {
        return Math.PI*a3*(a3+Math.sqrt(Math.pow(a3,2)+Math.pow(b2,2)));
    }
    // Method to calculate the volume of a cylinder
    public static double CylinderV(double a4,double b3)
    {
        return area(a4)*b3;
    }
    // Method to calculate the volume of a cone
    public static double ConeV(double a5,double b4)
    {
        return (1.0/3.0)*area(a5)*b4;
    }
}
