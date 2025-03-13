## Python Implementation

```python
def prime_num(num):
    if num <= 1:
        return False
    for i in range(2, num): 
        if num % i == 0:
            return False
    return True
```

## Java Implementation


```java
public static void main(String[] args) { 
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number:");
    int num = scanner.nextInt();

    if (isPrime(num)) {
        System.out.println(num + " is prime.");
    }
    else {
        System.out.println(num + " is not prime.");
    }
}
```


### Python Explanations
 When we look at the python implementation, we define a function and give it and attribute `(num)`. We introduce the `if` statement and `for` loop to iterate over the funtion and check if it matches the requirements. We later propmt user to input a number and the code will verify if all the requirements are met to qualify it as a prime number. 



### Java Explanation

In java we have a different approach. Unlike python we define our class using `(public class)` named `PrimeNumber`.Both Python and java use conditional statement loops to iterate over the functions. The function is later iterated on the main class



### Difference

1. Python uses `def` keyword to define a funtion while Java uses, `public static boolean` to define a function.

2. Java uses `System.out.print()` to print out the statement and python uses `print()` to print statement.


3. I notice i have to import `java.util.Scanner` to prompt user to input a number while python you only need to use, `input()`