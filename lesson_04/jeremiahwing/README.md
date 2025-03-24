## JAVA Implementation

```java

public class EvenCheck {
    // Method to check if a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Main method for running the program
    public static void main(String[] args) {
        System.out.println(isEven(4)); // Output: true
        System.out.println(isEven(7)); // Output: false
    }
}
```


## C++ Implementation
#include <iostream>
using namespace std;

```

// Function to check if a number is even
bool isEven(int number) {
    return number % 2 == 0;
}

int main() {

    cout << isEven(4) << endl;  // Output: 1 (true)
    cout << isEven(7) << endl;  // Output: 0 (false)
    return 0;
}

```

## Explanation  

First I want to talk about a prime number. A prime number is a natural number only divisible by 1 and its self.

Implementing it into code;


The "Java" implementation uses a function named called IsPrime. This Method needs a number as an imput and checks if its prime. The first being if the number is less than or equal to 1. If the results arent a prime number the method is false. However it runs a loop starting from 2 to the sqrt of the number. Being that if the number is divisible by anything in that range the meothod will be false. if no divide then method is true.


The "C++" Implementation also uses the function IsPrime. This function also works in a simimlar way then java. In thid method you need to first check if the number is 1 or less than, which returns false in that sense. After, the function literally loops from 2 up to the sqrt of the number simlar to java, looking for nay divisors. If i does find a divide then this method will return false. Concluding that if no divisor was found then menthod remains true.

# Similarities and Differences Index Chart

| Feature               | Similarities                                  | Differences                                   |
|-----------------------|-----------------------------------------------|-----------------------------------------------|
| **Syntax**            | Both programs usse a function with a simlilar purpose       | Java uses "IsPrime" as C++ uses "isPrime" but written out differently.|
| **Input**             | Both take number input to check if output is prime.                           | Java has a personal writting style while C++ follows an ordered structure.|
| **Main Function**     | Both have main start section to run code.                        | Java uses "public static void Main()" C++ uses "int main()" to start.|
| **First Line of Code** | Both need a special line including designated tools for code to start and run. | Java starts with "public class;". C++ starts with "#include <iostream>"|
| **Printing Output**    | Both Java and C++ use printing outputs to show if number is prime.          | Java uses "System.out.print()". C++ uses "cout" but, for larger programs uses std::cout to avoid potential name conflicts.|
