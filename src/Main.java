import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to Craps!");

        while (playAgain) {
            int result = rollDice(random);
            System.out.println("You rolled a " + result);

            if (result == 7 || result == 11) {
                // Natural win
                System.out.println("You rolled a natural! You win!");
            } else if (result == 2 || result == 3 || result == 12) {
                // Craps (loss)
                System.out.println("Craps! You lose.");
            } else {
                // Establish the point
                int point = result;
                System.out.println("Your point is " + point + ". Keep rolling!");

                boolean keepRolling = true;
                while (keepRolling) {
                    result = rollDice(random);
                    System.out.println("You rolled a " + result);

                    if (result == 7) {
                        // Lose
                        System.out.println("You rolled a 7. You lose.");
                        keepRolling = false;
                    } else if (result == point) {
                        // Win by hitting the point
                        System.out.println("You made your point! You win!");
                        keepRolling = false;
                    }
                }
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (y/n): ");
            String input = scanner.next();
            playAgain = input.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing Craps!");
    }

    // Method to simulate rolling two dice and return their sum
    public static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1; // Die 1: 1-6
        int die2 = random.nextInt(6) + 1; // Die 2: 1-6
        return die1 + die2;
    }
}