// This program defines a basic student grading system where each student has three test scores.
// Each student's average score is calculated and printed. Extra credit is then added to the third test score,
// and the updated grades and averages are printed again.

public class BasicStudentProgram 
{
    public static void main(String args[]) 
    {
        // Create three Student objects
        Student a = new Student();
        Student b = new Student();
        Student c = new Student();

        // Print initial student grades
        a.printStudent();
        b.printStudent();
        c.printStudent();

        // Add extra credit to each student's third test score
        a.addEC();
        b.addEC();
        c.addEC();

        // Print student grades after adding extra credit
        System.out.println("\n\nGrades after extra credit:");
        a.printStudent();
        b.printStudent();
        c.printStudent();
    }
}

class Student
{
    // Instance variables for student ID and test scores
    private int id;
    private int t1;
    private int t2;
    private int t3;
    private double avg;

    // Constructor to initialize a student with random ID and test scores
    Student()
    {
        id = (int)(Math.random() * 9000 + 1000);
        t1 = (int)(Math.random() * 41 + 60);
        t2 = (int)(Math.random() * 41 + 60);
        t3 = (int)(Math.random() * 41 + 60);
        avg = (t1 + t2 + t3) / 3.0;
    }

    // Method to add extra credit to the third test score and recalculate the average
    void addEC()
    {
        t3 += (int)(Math.random() * 5 + 1);
        avg = (t1 + t2 + t3) / 3.0;
    }

    // Method to print the student's test scores, average, and grade
    void printStudent()
    {
        int avg1 = (int)(avg + 0.5); // Round the average to the nearest integer
        String s = "";

        // Determine the grade based on the rounded average
        if (avg1 < 70)
            s = "F";
        else if (avg1 > 69 && avg1 < 75)
            s = "D";
        else if (avg1 > 74 && avg1 < 80)
            s = "C";
        else if (avg1 > 79 && avg1 < 90)
            s = "B";
        else if (avg1 > 89)
            s = "A";

        // Print the student's ID, test scores, average, and grade
        System.out.println(id + " :  Test 1 : " + t1 + " \tTest 2 : " + t2 + " \tTest 3 : " + t3 + " \tAvg : " + avg1 + "\t\t" + s);
    }
}