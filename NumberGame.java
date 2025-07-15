import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("=== Welcome to the Number Guessing Game! ===");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("\nRound " + (roundsPlayed + 1) + ": Guess a number between 1 and 100.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;

                // Input validation
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    scanner.next(); // discard invalid input
                    continue;
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempt(s).");
                    hasWon = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            roundsPlayed++;
            if (hasWon) {
                roundsWon++;
            } else {
                System.out.println("❌ You've used all attempts! The number was: " + targetNumber);
            }

            // Ask to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        // Final Score
        System.out.println("\n=== Game Over ===");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thanks for playing!");
        
        scanner.close();
    }
}
