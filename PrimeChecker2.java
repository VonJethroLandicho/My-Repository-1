import java.math.BigInteger;
import java.util.Scanner;


public class PrimeChecker2 {
    // Constant string to hold the command for exiting the program
    private static final String EXIT_COMMAND = "exit";


    public static boolean isPrime(BigInteger number) {
         // Check if the given BigInteger is a prime number
        if (number.compareTo(BigInteger.TWO) < 0) return false;
        for (BigInteger divisor = BigInteger.TWO; divisor.multiply(divisor).compareTo(number) <= 0; divisor = divisor.add(BigInteger.ONE)) {
            if (number.mod(divisor).equals(BigInteger.ZERO)) return false;
        }
        return true; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        //Main loop to interact with the user, check for prime numbers, and handle the exit command.
         
        while (true) {
            // Prompt the user to enter a number or the exit command
            System.out.print("Enter a number to check if it's a prime number (type '" + EXIT_COMMAND + "' to exit): ");
            String userInput = scanner.nextLine();
            // Check if the user input matches the exit command
            if (userInput.equalsIgnoreCase(EXIT_COMMAND)) {
                System.out.println("Exiting the program.");
                break;
            }

            try {
                // Attempt to convert the user input to a BigInteger and check if it is prime
                BigInteger inputNumber = new BigInteger(userInput);
                System.out.println(inputNumber + (isPrime(inputNumber) ? " is a prime number." : " is not a prime number."));
            } catch (NumberFormatException e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a valid number or '" + EXIT_COMMAND + "' to quit.");
            }
        }
        scanner.close();
    }
}
