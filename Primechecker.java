import java.math.BigInteger;
import java.util.Scanner;

public class PrimeChecker {
    private static final String EXIT_COMMAND = "exit";
    public static boolean isPrime(BigInteger number) {
        
        if (number.compareTo(BigInteger.valueOf(2)) < 0)
            return false;
        for (BigInteger i = BigInteger.valueOf(2); i.multiply(i).compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
            if (number.mod(i).equals(BigInteger.ZERO))
                return false;
        }
        return true; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            System.out.print("Enter a number to check if it's a prime number(type '" + EXIT_COMMAND + "' to exit): ");
            String input = scanner.nextLine();

            
            if (input.equalsIgnoreCase(EXIT_COMMAND)) {
                System.out.println("Exiting the program.");
                break;
            }

            BigInteger number;
            try {
                number = new BigInteger(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or '" + EXIT_COMMAND + "' to quit.");
                continue; 
            }

            if (isPrime(number)) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        }

        scanner.close();
    }
}
