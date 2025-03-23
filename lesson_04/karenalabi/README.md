Lesson 04

## Python Implementation 

```python
    # Defines a function named (primenumcheck) that calls a parameter (numbers)
    def primenumcheck (number): 
        # Conditional statements that determine if the number being returned is prime
        if number <= 1:
            return False
        if number == 2:
            return True
        if number % 2 == 0:
            return False
        # For loop to check if numbers greater than 2 are prime
        for i in range(3, int(number ** 0.5) + 1, 2):
        if number % i == 0:
            return False
    return True
```

## Java Implementation

```java
   // Declaring the class in program (PrimeNumberChecker)
    public class PrimeNumberChecker
         // boolean method to check if integer is Prime
         // access modifier to start the program
        public static boolean checkIfPrime (int number) {
            // Conditional statements to determine if number is prime
            if (number <= 1) {
                return false;
            }
            if (number == 2) {
                return true;
            } 
            if (number % 2 == 0) {
                return false;
            }
            // For loop to check if mumbers greater than 2 are prime
            for (int i = 3; i <= Math.sqrt(number); i += 2) {
                if (number % i == 0) {
                        return false;
                }
            }
        return true;
        }
```


## Explanation
The Python implementation defines a function named with the `def` keyword. The function is called `primenumcheck` and it calls a parameter `number` and determines whether it is prime. The python implementation then uses condiitonal if - statements to return false if the number is less than or equal to 1, or if the number is divisible by 2 becuase prime numbers can only be divisible by themselves and are greater than 1. The function will return true if the number returned is equal to 2. The python implementation also uses a `for` loop to iterate through the odd numbers up to the squareoot of that given number. If any of these numbers evenly divides `number`, it is not prime, and will return false. The loop increments by 2 (`i += 2`) to rule out even numbers.

The Java implementation follows a similar logic to the python implementation. It defines a public class named `PrimeNumberChecker`. Within this class, a `boolean` method called `checkIfPrime` is implemented to determine if an integer is prime or not. The method takes an `int` (integer) parameter called `number` and uses conditional statements (if-statements) to check if the input number is prime. Similar to the python inplementation, the java implementation also used a for-loop to iterate through numbers not evenly divisible by the given number. 

### Differences 

1. **Syntax**:
    - In Python, the function is defined using the `def` keyword. The fucntion can be defined by directly calling the name `primenumcheck`. Whereas, in Java, the proper term is a method and methods are defined within a class using a return type `boolean`, in this case. The Java implementation will return true or fase based on the int parameter called `number`.

    - Python uses indentation to define the beginning and end of that portion of code, while Java uses curly braces `{}`.

    - Python capitalizes its boolean values. It uses `True` and `False`. Java does not capitalize the boolean values.

    - Python uses hashes to comment out the code while java uses back slashes 

2. **Type System**:
     - Java requires the type of method (`boolean` or `int`) to be declared within an access modifier: `public static boolean checkIfPrime` , whereas the Python function can be called by its name: `def primenumcheck`
        
     - Java uses `boolean` to return `checkIfPrime` method, whereas the Python implementation returns True or False based on the if-statement conditions
3. **Function Calls**:
    - the python implementation uses a range within the for loop

    - the java implementation uses the math sqroot 

