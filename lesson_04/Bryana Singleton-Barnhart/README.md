## Swift implementation

```Swift
func isPrime(_ num: Int) -> Bool {
    if num < 2 { return false }
    if num == 2 { return true }
    if num % 2 == 0 { return false } // Eliminate even numbers

    for i in 3...Int(Double(num).squareRoot()) where i % 2 != 0 {
        if num % i == 0 {
            return false
        }
    }
    return true
}
```

## C++ implementation

```C++
#include <iostream>
#include <cmath>

bool isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false; // Eliminate even numbers

    for (int i = 3; i <= sqrt(num); i += 2) { // Check only odd numbers
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}
```

## Explanation
Some of the observations I've made are that both code implementations had an `isPrime` function.

For both, if the number is less than 2 it returns false (`if num < 2 { return false }`). If the number is even to 2 it returns true (`if num == 2 { return true }`). If the number is divided by 2 and equals 0 it returns false ( `if num % 2 == 0 { return false }`).

I noticed both languages have `bool` in code but in different spaces.

Swift and C++ have the same loop variable (i)

Both codes include If (`num % i == 0`). Taking the number divided by `i = 0`.

### Differences

In C++ the code starts off with `#include <iostream> #include <cmath>`. 

Before the function `isPrime` Swift starts with `func` but C++ starts with `bool`.

Even though both codes have square root it is formatted differently (`.squareRoot()` and `sqrt()`) in the code.

Swift has `Double(num)` in the code where C++ does not include this.

In Swift the code does not declare the `i` but C++ declares the `i`.
















