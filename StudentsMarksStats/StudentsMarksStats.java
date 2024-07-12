
/**
 * Write a description of class StudentsMarksStats here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class StudentsMarksStats
{
    // defining total number of students
    private static int num_students = 2;

      /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args) {
    
        // Get assignment name from user and store it.
        System.out.println("Enter the assignment name");
        String assignmentName = new Scanner(System.in).nextLine();
        
        // Initialize an array to store marks of all students
        double[] marks = new double[num_students];
        
        // Input marks for each student
        System.out.println("Enter mark(0-30)");
        for (int i = 0; i < num_students; i++) {
            System.out.println("Student " + (i + 1) + ":");
            
            // Loop until a valid mark is provided
            while (true) {
                try {
                    // Parse user input as a decimal
                    double mark = Double.parseDouble(new Scanner(System.in).nextLine());
                    
                    // Validate if the mark is within the range (0-30)
                    if (mark >= 0 && mark <= 30) {
                        marks[i] = mark;
                        break;  // Exit the whileloop if valid mark is entered
                    } else {
                        System.out.println("Error: Mark must be between 0 and 30. Please try again."); // Display error if entered mark is not within the range.
                    }
                } catch (NumberFormatException e) {
                    // catch error when input is not a valid number
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            }
        }
        
        // Display assignment name
        System.out.println("\nAssignment: " + assignmentName);
    }


}
