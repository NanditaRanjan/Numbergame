import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("=== New Game ===");

            int attempts = 0;
            int guess;

            while (true) {
                System.out.print("Guess the number (between 1 and 100): ");
                guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (attempts >= maxAttempts) {
                    System.out.println("Game over! The number was " + secretNumber + ".");
                    break;
                }
            }

            totalAttempts += attempts;

            System.out.println("\nRounds played: " + rounds);
            System.out.println("Total attempts: " + totalAttempts);
            System.out.println("Average attempts per round: " + (double) totalAttempts / rounds);

            System.out.print("Do you want to play again? (yes/no): ");
            String choice = scanner.next().toLowerCase();

            while (!choice.equals("yes") && !choice.equals("no")) {
                System.out.print("Invalid input. Please enter 'yes' or 'no': ");
                choice = scanner.next().toLowerCase();
            }

            playAgain = choice.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
