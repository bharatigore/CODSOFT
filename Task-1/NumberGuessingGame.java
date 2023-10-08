import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int totalRounds = 3; // Number of rounds to play
        int round = 1;
        int totalScore = 0;

        System.out.println("Welcome to Guess the Number Game!");

        while (round <= totalRounds) {
            System.out.println("\nRound " + round + " of " + totalRounds);
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int maxAttempts = 5;

            while (true) {
                System.out.print("Enter your guess (between " + minRange + " and " + maxRange + "): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    int roundScore = calculateScore(maxAttempts, attempts);
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number. Your score for this round: " + roundScore);
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Higher! Try again.");
                } else {
                    System.out.println("Lower! Try again.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts! The secret number was: " + secretNumber);
                    break;
                }
            }

            round++;
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalScore);

        scanner.close();
    }

    // Calculate the score based on the number of attempts made
    private static int calculateScore(int maxAttempts, int attempts) {
        int baseScore = 100;
        int penalty = 10; // Points to deduct for each additional attempt beyond maxAttempts
        int extraAttempts = Math.max(attempts - maxAttempts, 0);
        return Math.max(baseScore - extraAttempts * penalty, 0);
    }
}
