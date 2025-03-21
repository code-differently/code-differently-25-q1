# Lesson 04:

## Python code 

```python
def is_prime(n):
    """Check if a number is prime."""
    if n < 2:
        return False
    if n in (2, 3):
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    
    # Check divisibility using 6k ± 1 rule
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True

def main():
    try:
        num = int(input("Enter a number: "))
        if is_prime(num):
            print(f"{num} is a prime number.")
        else:
            print(f"{num} is not a prime number.")
    except ValueError:
        print("Invalid input! Please enter an integer.")

    Run the program
if __name__ == "__main__":
    main()
```

## Java Code  

```java
import java.util.Scanner;

public class PrimeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }

    public static boolean isPrime(int number) {
        // Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            return false;
        }

        // Check from 2 up to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            // If the number is divisible by any number in the range, it's not prime
            if (number % i == 0) {
                return false;
            }
        }

        // If no divisors were found, the number is prime
        return true;
    }
}
```

## Compare and Contrast Java and Python

    In this assignment I am comparing and contrasting python’s code to Java’s code. These codes are about selecting prime numbers and the differences I see between them. The first thing I notice with these codes is Java’s code is three times bigger than the code in Python. With that being said it seems like Java needs more written code in it to achieve the same goal Python has. Another thing I have noticed is that Java you have to import java.util.Scanner; this just means that the scanner class is available for our program. Java also has public static void main(String[] args) which is the entry point for the java program. One thing that I noticed was that Python did not have any else statements. In python it seems as though you don’t have to declare n as a number while in Java you have to. Some similarities that Java and Python have in common are that they both use return, int, if, and for statements to complete the code.