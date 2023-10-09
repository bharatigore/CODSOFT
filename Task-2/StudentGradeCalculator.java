import java.util.Scanner;


//////////////////////////////////////////////////////////////////////////
//
//  Class name :         StudentGradeCalculator
//  Description :        This program calculates the total marks, average percentage, and assigns a grade
//                       based on the marks obtained in each subject (out of 100). It takes input for the
//                       number of subjects and the marks obtained in each subject from the user. The program
//                       validates the input and provides results including the total marks, average
//                       percentage, and grade. ANSI escape codes are used for text formatting to enhance
//                       the user interface.
//  Author :           Gore Bharati 
//  Date :               02/10/2023
//  Update Date :        09/10/2023
//
//////////////////////////////////////////////////////////////////////////

public class StudentGradeCalculator
 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_SKY_BLUE = "\u001B[36m"; // Sky blue color escape code
    public static final String ANSI_GREEN = "\u001B[32m";    // Green color escape code
    public static final String ANSI_VIOLET = "\u001B[35m";   // Violet color escape code
        public static final String ANSI_YELLOW = "\u001B[33m";   // Violet color escape code


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print(ANSI_SKY_BLUE + "Enter the number of subjects: " + ANSI_RESET);
            int numSubjects = scanner.nextInt();
            scanner.nextLine();

            System.out.println(ANSI_YELLOW + "Enter marks obtained in each subject (out of 100):" + ANSI_RESET);

            int totalMarks = 0;

            for (int i = 1; i <= numSubjects; i++) {
                System.out.print(ANSI_GREEN + "Enter marks obtained in subject " + i + ": " + ANSI_RESET);
                int marks = scanner.nextInt();
                totalMarks += marks;
            }

            double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println(ANSI_VIOLET + "-----------Result------------------" + ANSI_RESET);
            System.out.println(ANSI_VIOLET + "Total Marks: "  + ANSI_RESET + totalMarks);
            System.out.println(ANSI_VIOLET + "Average Percentage: "+ ANSI_RESET+ averagePercentage + "%" );
            System.out.println(ANSI_VIOLET + "Grade: "+ ANSI_RESET + grade );
        System.out.println(ANSI_VIOLET + "-------------------------------------" + ANSI_RESET);

        } catch (Exception e) {
            System.out.println(ANSI_VIOLET + "Invalid Input " + ANSI_RESET + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}