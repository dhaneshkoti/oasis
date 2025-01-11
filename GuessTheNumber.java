import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 3; // Number of rounds
        int maxAttempts = 5; // Maximum attempts per round
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round + ":");
            int randomNumber = (int) (Math.random() * 100) + 1; // Random number between 1 and 100
            int attempts = 0;
            boolean guessed = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1 to 100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessed = true;
                    totalScore += (maxAttempts - attempts + 1) * 10; // Points based on remaining attempts
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is higher. Try again!");
                } else {
                    System.out.println("The number is lower. Try again!");
                }
            }

            if (!guessed) {
                System.out.println("You've used all attempts. The correct number was: " + randomNumber);
            }
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        scanner.close();
    }
}
