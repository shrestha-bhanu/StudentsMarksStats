
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
    private static int num_students = 30;

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
        
        // Print all marks
        System.out.println("Marks: ");
        
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("Student %d : %.2f", i+1, marks[i]);
            if (i < marks.length - 1) {
                System.out.print("\n");
            }
        }
        
        // Find and show the highest mark
        double highestMark = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highestMark) {
                highestMark = marks[i];
            }
        }
        System.out.printf("\nHighest mark: %.2f%n", highestMark);
        
        // Find and show the lowest mark
        double lowestMark = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < lowestMark) {
                lowestMark = marks[i];
            }
        }
        System.out.printf("\nLowest mark: %.2f%n", lowestMark);
        
         // Calculate and display average mark
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        double mean = sum / marks.length;
        
        // Calculate standard deviation
        double squaredDiffSum = 0;
        for (double mark : marks) {
            double diff = mark - mean;
            squaredDiffSum += diff * diff;
        }
        double variance = squaredDiffSum / marks.length;
        double stdDev = Math.sqrt(variance);
        
        // Display mean and standard deviation
        System.out.printf("Mean: %.2f%n", mean);
        System.out.printf("Standard Deviation: %.2f%n", stdDev);
     
    }


}
