import java.util.Scanner;               // This package for reading input

public class PrimeNumber {              // This is the class name

    public static boolean isPrime(int num) {            // Function to check if number is prime or not.
        if (num <= 1) return false;                     // If number is less than or equal to 1, it is not prime.
        for (int i = 2; i <= Math.sqrt(num); i++) {     // Loop to check if number is prime or not.
            if (num % i == 0) return false;             
        }
        return true;
    }

    public static void main(String[] args) {            // This is the main function
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = scanner.nextInt();

        if (isPrime(num)) {
            System.out.println(num + " is prime.");
        } else {
            System.out.println(num + " is not prime.");
        }
    }
}