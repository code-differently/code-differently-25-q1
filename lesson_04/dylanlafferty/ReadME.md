## Java Implementation

```class PrimeChecker {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        // Check if number is divisible by any number from 2 to sqrt(number)
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int num1 = 11; //This number may be changed to change the input 
        int num2 = 15; //This one too
        System.out.println(num1 + " is prime: " + isPrime(num1));
        System.out.println(num2 + " is prime: " + isPrime(num2));
    }
}
```

## JavaScript implementation

```
// let number = prompt("Enter a number to check if it is a Prime number");

function checkPrime(number) {
    if (number === null || number === undefined) {
        console.log("You have not entered a number");
        return;
    }

    if (number <= 1) {
        console.log("This is not a prime number");
        return false; // Numbers less than or equal to 1 are not prime
    }

    for (let i = 2; i < Math.sqrt(number); i++) {
        if (number % i === 0) {
            console.log("This is not a prime number");
            return false; // If divisible by any number other than 1 and itself
        }
    }

    console.log("This is a prime number");
    return true; // If no divisors were found, the number is prime
}

console.log(checkPrime(45)); // 
console.log(checkPrime(23)); // 
console.log(checkPrime(13)); // 
```

## Explaination

The Java
The Java implementation uses a class named `PrimeChecker`. `PrimeChecker` will get an integer named `number` and run it through 2 tests. The first test will be to see if `number` is less than or greater than 1 which then will return `false`.  It will then see if the number is able to be divided by anything other than itself and if not then it will return `True`.

The JavaScript implementation uses a function named `checkPrime`. `CheckPrime` first checks if a `number` has been entered. If a `number` has been entered and if it is less than or equal to 1 it will return `True`. If this passes the for loop will run and see if that `number` can be divided into itself and if it can then return `False`.  

## Similarites
1. **Syntax**
    - Both languages write If statements in the same way using `if(instance) { code } `.
    - The For Loop are both written using `for` and adding the statements inside of `(statement1)`.
    - Math works the same in both languages using the `%` for division.
2. **Input Fields**
    - Both Languages can have a predefined input inside of the code.
    - Both Languages can return either `true` or `false` to the console.

## Differences
1. **Syntax**
    - In `Java` there are two Static functions but one it required to be defined as main. However in `JavaScript` you do not need to define a main function.
    - In `Java` in order to print something you have to write a `system.out.print` compared to `JavaScript` It uses the `console.log`.
2. ## Declarations
    - With `Java` You have to let the computer know what type of input you are giving it. So if you would want to give a variable a number you need to declare that as an integer or `int`. While you can just write a number out in `javaScript`.
    