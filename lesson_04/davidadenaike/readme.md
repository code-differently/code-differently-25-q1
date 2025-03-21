
## Python implementation

```python
def is_even(number):
    return number % 2 == 0

# Example usage:
print(is_even(4))  # Output: True
print(is_even(7))  # Output: False
```

## JavaScript implementation

```javascript
function isEven(number) {
    return number % 2 === 0;
}

// Example usage:
console.log(isEven(4)); // Output: true
console.log(isEven(7)); // Output: false
```

note need to write 100 words explanation of the two
-->

## JavaScript
```java script

function isPrime(number) {
  if (number <= 1) {
    return false; // Numbers less than or equal to 1 are not prime
  }

  for (let i = 2; i <= Math.sqrt(number); i++) {
    if (number % i === 0) {
      return false; // If divisible by any number other than 1 and itself, it's not prime
    }
  }

  return true; // If no divisors found, the number is prime
}
```


## Java
```java
import java.util.Scanner; 

public class PrimeNumberChecker {
    
    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        // Handle cases for numbers less than 2
        if (num <= 1) {
            return false;
        }
        
        // Check divisibility from 2 to the square root of num
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; // num is divisible by i, so it's not prime
            }
        }
        
        return true; // num is prime if no divisors were found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number from user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check if the number is prime
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
        
        scanner.close();
    }
}
```

## Explanation

Java uses a method called `PrimeNumberChecker` to check if a number is prime. The method is made up of two components. An `if` statement and a `for` loop. The `if` statement handles numbers that are less than 2. As the for loop then checks for divisibility from 2 to the square root of the number represented as int “i”. Both the if statement and for loop is nested within a public class `PrimeNumberChecker`

JavaScript however is more straight forward. It uses a function called `‘isPrime’` that checks numbers that are less than or equal to 1. Once it does that, it returns false since the result would not be a prime number. Afterward an `if` statement is used, similarly to java. Then a `for` loop checks if the number is divisible by any number other than 1 and itself.  

### Differences
Biggest difference is that java because it is an object-oriented language has the method `‘PrimeNumberChecker’` in a class to use.

### Similarities:
Both languages use an if statement and a for loop to determine whether a number is prime or not.
