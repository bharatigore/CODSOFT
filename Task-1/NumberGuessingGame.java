import java.util.Scanner;
import java.util.Random;

//////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                              //
//     class name : NumberGuessingGame                                                          //
//     Description : This class implements a simple number guessing game.                       //
//                    The player tries to guess a randomly generated number                     //
//                     within a specified range. The game provides hints and                    //
//                     tracks the number of attempts and total score.                           //
//  Author :             Gore Bharati                                                           //
//  Date :               01/10/2023                                                             //
//  Update Date :        08/10/2023                                                             //
//////////////////////////////////////////////////////////////////////////////////////////////////

public class NumberGuessingGame
// entry point function
 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int totalRounds = 3; // Number of rounds to play
        int round = 1;
        int totalScore = 0;
        // ANSI escape codes are used to change text colors in the console output.
        // Here's a brief explanation of the ANSI escape codes used in this program:
        // - "\u001B[32m": Sets the text color to green. The text after this code will be displayed in green.
        // - "\u001B[33m": Sets the text color to yellow. The text after this code will be displayed in yellow.
        // - "\u001B[31m": Sets the text color to red. The text after this code will be displayed in red.
        // - "\u001B[0m": Resets the text color to the default color. This is used to end the color change sequence.


        System.out.println("\u001B[32m********************************************\u001B[0m");
        System.out.println("\u001B[32m*   Welcome to the Guess the Number Game   *\u001B[0m");
        System.out.println("\u001B[32m*       Can you guess the secret number?   *\u001B[0m");
        System.out.println("\u001B[32m********************************************\u001B[0m");

        while (round <= totalRounds) {
            System.out.println("\u001B[33m* \nRound " + round + " of " + totalRounds +"*\u001B[0m");
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int maxAttempts = 5;

            while (true) {
                System.out.print("\u001B[33m* Enter your guess (between " + minRange + " and " + maxRange + "): \u001B[0m");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    int roundScore = calculateScore(maxAttempts, attempts);
                    totalScore += roundScore;
                    System.out.println("\u001B[38m* Congratulations! You guessed the number in " + attempts + " attempts. *\u001B[0m");
                    break;
                } else if (guess < secretNumber) {
                                      System.out.println("\u001B[31m* Higher! Try again.                         *\u001B[0m");
                } else {
                    // Display hint message in red color
                    System.out.println("\u001B[31m* Lower! Try again.                          *\u001B[0m");
                }

                if (attempts == maxAttempts)
                {
                    System.out.println("\u001B[36m*Out of attempts! The secret number was: \u001B[0m*" + secretNumber);
                    break;
                }
            }

            round++;
        }

         System.out.println("\u001B[32m********************************************\u001B[0m");
        System.out.println("\u001B[32m*              Game Over!                   *\u001B[0m");
        System.out.println("\u001B[32m*            Total Score: " + totalScore + "*\u001B[0m");
        System.out.println("\u001B[32m********************************************\u001B[0m");

        scanner.close();
    }

    // Calculate the score based on the number of attempts made
    private static int calculateScore(int maxAttempts, int attempts)
     {
        int baseScore = 100;
        int penalty = 10; // Points to deduct for each additional attempt beyond maxAttempts
        int extraAttempts = Math.max(attempts - maxAttempts, 0);
        return Math.max(baseScore - extraAttempts * penalty, 0);
    }
}
