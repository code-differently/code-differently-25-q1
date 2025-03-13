## C# Implementation

```c#
using System;

class Program
{
    static bool IsPrime(int number)
    {
        if (number < 2)
            return false;
        
        for (int i = 2; i <= Math.Sqrt(number); i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    static void Main()
    {
        Console.Write("Enter a number: ");
        int num = int.Parse(Console.ReadLine());
        
        if (IsPrime(num))
            Console.WriteLine($"{num} is a prime number.");
        else
            Console.WriteLine($"{num} is not a prime number.");
    }
}
```

## C++ Implementation

```c++
#include <iostream>
#include <cmath>

bool isPrime(int number) {
    if (number < 2)
        return false;
    
    for (int i = 2; i <= std::sqrt(number); i++) {
        if (number % i == 0)
            return false;
    }
    return true;
}

int main() {
    int num;
    std::cout << "Enter a number: ";
    std::cin >> num;
    
    if (isPrime(num))
        std::cout << num << " is a prime number." << std::endl;
    else
        std::cout << num << " is not a prime number." << std::endl;
    
    return 0;
}
```

## Explanation

The C# "C Sharp" implementation uses a function named `Is_Prime`. This function takes a `number` as input and reads `true` if the number is Prime or `false` if the number is not Prime.

The C++ "C Plus Plus" implementation uses a function named `is_Prime`. This function also takes a `number` as input and reads `true` if the number is Prime or `false` if the number is not Prime.

# Similarities and Differences Index Chart

| Feature               | Similarities                                  | Differences                                   |
|-----------------------|-----------------------------------------------|-----------------------------------------------|
| **Syntax**            | The names of the functions are similar.          | C# uses "IsPrime". C++ uses "isPrime".  |
| **Input**             | Both take user input.                            | One coded in C# language. One coded C++ language.|
| **Main Function**     | Both have main functions.                        | C# uses "static void Main()" C++ uses "int main()"|
| **First Line of Code** | Both have a line of code to start. | C# starts with "using System;". C++ starts with "#include <iostream>"|
| **Printing Output**    | Both use printing outputs.          | C# uses "Console.WriteLine()". C++ uses "std::cout <<". |

