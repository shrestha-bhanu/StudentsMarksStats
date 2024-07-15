
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
    private static int num_students = 3;

    /**
     * The main method of the class, this method gets input from the user for 30 students' marks and calucates -
     * highest mark, lowest mark, mean, and standard deviation of the marks.
     *
     * @param  args
    */
    public static void main(String[] args) {
    
        
        // Get assignment name from user and store it.
        System.out.println("Enter the assignment name");
        String assignmentName = new Scanner(System.in).nextLine();
        
        // Initialize an array to store marks of all students
        double[] marks = new double[num_students];
        
        
        // Input marks for each student
        System.out.println("Enter mark. A valid mark is between 0 - 30.");
        // iterate over 30 students and assign valid mark to each student.
        for (int i = 0; i < num_students; i++) {
            System.out.println("Student " + (i + 1) + ":");
            marks[i] = getStudentMark();
        }

        System.out.println("\nAssignment: " + assignmentName + "\n");
        System.out.print("Marks of all 30 students : \n");
        printAllMarks(marks); // pass the marks array to a method to show the marks to the user.
        
        // Pass the marks array to respective methods to get highest & lowest mark.
        System.out.printf("\n\nHighest mark: %.2f%n", findHighestMark(marks));
        System.out.printf("Lowest mark: %.2f%n", findLowestMark(marks));

        // Pass the marks array to the method to calculate mean, & standard deviation and store them in an array.
        double[] meanStdDev = calculateMeanStdDev(marks);
        System.out.printf("Mean: %.2f%n", meanStdDev[0]);
        System.out.printf("Standard Deviation: %.2f%n", meanStdDev[1]);
    }
    
    /**
     * This method prompts the user for input, validates the input, and returns the input.
     *
     * @return    the mark entered by the user.
    */
    private static double getStudentMark() {
        while (true) {
            try {
                double mark = Double.parseDouble(new Scanner(System.in).nextLine());
                
                // only accept mark between 0 and 30
                if (mark >= 0 && mark <= 30) {
                    return mark;
                } else {
                    System.out.println("Error: You entered an invalid mark. Mark must be between 0 - 30. Please try again.");
                }
            // when invalid input is given, show error.
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number between 0 - 30.");
            }
        }
    }
    
    /**
     * This method iterates through an array and prints them in readable manner.
     *
     * @param  marks the marks array.
    */
    private static void printAllMarks(double[] marks) {
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("Student %d : %.2f", i+1, marks[i]);
            if (i < marks.length - 1) {
                System.out.print("\n");
            }
        }
    }
    
    /**
     * This method iterates through an array of marks and finds the highest mark.
     *
     * @param  marks the marks array.
     * @return the highest mark from the array.
    */
    private static double findHighestMark(double[] marks) {
        double highestMark = marks[0]; // assign a default value to highestMark
        for (int i = 1; i < marks.length; i++) {
            // check if the value in the marks array is higher than the default value in the highestMark variable.
            if (marks[i] > highestMark) {
                highestMark = marks[i]; // if true, replace the value in the highestMark var with the marks array value.
            }
       
        }
        return highestMark;
    }
    
    /**
     * This method iterates through an array of marks and finds the lowest mark.
     *
     * @param  marks the marks array.
     * @return the lowest mark from the array.
    */
    private static double findLowestMark(double[] marks) {
        double lowestMark = marks[0]; // assign a default value to lowestMark
        // iterate through the marks array
        for (int i = 1; i < marks.length; i++) {
            // check if the value in the marks array is lower than the default value in the lowestMark var.
            if (marks[i] < lowestMark) {
                lowestMark = marks[i]; // if true, replace the value in the lowestMark var with the marks array value.
            }
        }
        return lowestMark;
    }
    
    
    /**
     * This method iterates through an array of marks and finds the lowest mark.
     *
     * @param  marks the marks array.
     * @return [mean,stdDev] the calucalted mean and standard deviation.
    */
    private static double[] calculateMeanStdDev(double[] marks) {
        double sum = 0; // asign default value of 0 to the sum variable.
        for (double mark : marks) {
            sum += mark; // add the value of each mark to the sum variable.
        }
        
        // calculate the mean
        double mean = sum / marks.length; 

        double squaredDiffSum = 0; // assign the default value of 0.
        
        for (double mark : marks) {
            double diff = mark - mean; // calculate the difference from each mark
            squaredDiffSum += diff * diff; // calculate squared sum of the each difference.
        }
        double variance = squaredDiffSum / marks.length; // calculate variance
        double stdDev = Math.sqrt(variance); // use the java library function to calculate standard deviation.

        return new double[]{mean, stdDev}; // return mean, stdDev as array
    }
    

}
