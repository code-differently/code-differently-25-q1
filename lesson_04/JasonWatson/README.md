## C

```C
#include <stdio.h>
#include <stdbool.h>

bool isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}

int main() {
    int number = 29;
    if (isPrime(number))
        printf("%d is a prime number . \n", number );
    else
        printf("%d is not a prime number . \n", number );
    return 0;
}
```

## C++

```Cpp
#include <iostream>
#include <cmath>

bool isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}

int main() {
    int number = 29;
    std::cout << std::boolalpha <<
isPrime(number) << std::end1;
    return 0;
}
```

## Explanation
This C program checks if a given nember is a prime number.It uses a function isPrime() to then determine whether a number is a prime number and the gives the output.

This C++ program checks when a given number is a prime number by using the simple function isPrime() and the gives an out. It does so by using the <iostream> which is a library for input/output and the <cmath> for calculation.


### DIFFERENCES

1. **Syntax**:
   - In C it uses a standard input-output library which gives us the ability to use functions such as print() to give output.
   - In C++ it uses a standard input-output stream library which makes us be able to use std::cout and std::endl to display the output.

2. **How they carry out calculation**:
   -  C uses the bool data type to which provides true and false values for logical operation whilst the C++ use a math library to do mathematical functions such as sqrt() that calculkates square root numbers.



### SIMILARITIES

1. **Codes**: 
   - Both C and C++ use the function if (n <= 1) return false to determine if the number is a prime number.
   - They both have the ability to do loop for Checking Divisibility.
   - the function return true; is use by both programs to return true if No Divisors found.

