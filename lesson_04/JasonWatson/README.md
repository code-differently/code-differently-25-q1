## C

```c
#include <stdio.h>
#include <stdbool.h>

bool isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}

nt main() {
    int number = 29;
    if (isPrime(number))
        printf("%d is a prime number . \n", )
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



### Differences

1. **

2. **
   
3. **
