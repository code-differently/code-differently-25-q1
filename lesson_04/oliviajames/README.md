def is_prime(n):
    if n < 2:
        return False
    if n in (2, 3):
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True

# Example usage
num = int(input("Enter a number: "))
print(f"{num} is prime: {is_prime(num)}")


import java.util.Scanner;

public class PrimeChecker {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        System.out.println(num + " is prime: " + isPrime(num));
    }
}


# Explanation
After examining both languages I noticed that Python uses an is_prime (num) function that is used to dictate whether the number being input is prime or not. It uses specific clauses including numbers less than 1, even numbers greater than 2 , and numbers from 3 to the square root of said number for all statements to print false, otherwise it will print true if the number is equal to 2 as it is the smallest prime number and all others outside of said classes.  

In Java it uses a class function primechecker and an isPrime(int num) to determine if a number is prime. Using if statements that will return false when numbers are less than 1, numbers that are even or greater than 2, and then uses a loop to divide from 2 to the square root of the number. If no divisor is found it will otherwise print true and if the number is equal to 2.




# Differences
In python, functions are defined using the def keyword, whereas in Java,  public class  is used as a keyword.
Java uses “System.out.print” and python uses “print”
Java uses a public static boolean while python uses def is_prime(num).



