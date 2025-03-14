# Evan Philakhong

## C++ implementation

#### main.hpp
```c++
#include <iostream>
#include <string>
using namespace std;

// function definition
bool isPrime(int num);
```
#### main.cpp
```c++
bool isPrime(int num) {
    int count = 0;
        for (int i = num; i > 0; i--) {
            if (num%i == 0) {
                count++;
            }
        }
        if (count == 2) {
            cout << "This is a Prime Number" << endl;
            return true;
        }
    cout << "This is not a Prime Number" << endl;
    return false;
}
```

## Java implementation

```java
public static boolean isPrime(int num) {
        int count = 0;
        for (int i = num; i > 0; i--) {
            if (num%i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("This is a Prime Number");
            return true;
        }
        System.out.println("This is not a Prime Number");
        return false;
     }
```

## Explanation

The **C++** implementation is using a function named `isPrime` that takes a single parameter `num` representing the number the function is checking if it's a prime number or not. The function returns `True` if the number is **Prime**, otherwise it returns `False`.

The **Java** implementation is using a function named `isPrime` that takes a single parameter `num` representing the numer the function is checking if it's a prime number or not. The function returns `True` if the number is **Prime**, otherwise it returns `False`.

### Differences

1. **File Stucture**:
    - In **C++**, you have the ability to create a header file to store libraries and function declorations. While Java has no such thing.
    - **Java** forces you to work in a `Class` while, **C++** lets you work outside of `Classes`

2. **Syntax**:
    - The syntax for printing to the console/output is a little different. **C++** uses `cout` while, **Java** uses `System.out.print();`