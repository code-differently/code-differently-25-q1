## Java implementation

```java
   public class PrimeCheck {
    public static boolean isPrime(int num) {
      if (num <= 1) return false;
      for (int i = 2; i<= Math.sqrt(num); i++) {
        if (num % i == 0) return false;
      }
      return true;  
    }
    # Example usage:
    public static void main(String[] args) {
      int num = 29;
      System.out.println(isPrime(num)); // Output: true
      System.out.println(isPrime(4)); // Output: false
    }
}
```

## C++ implementation


```C++

   #include<iostream>
   #include <cmath>
   using namespace std;

    bool isPrime(int num) {
    if (num <= 1) return false;
    for (int i = 2; i <= sqrt(num); i++) {
        if (num % i == 0) return false;
    }
    return true;
}
    int main() {
    int num = 29;
# Example usage:
    std::cout << isPrime(num) << std::endl;
    std::cout << isPrime(4) << std::endl;
    return 0;
}

```

## Explanation
    The Java implementation uses a function named `isPrime`. Similiar to C++, the formula checks to see if a `num` varaible is less than or equal to 1, if so it will render a `false` result. If you have no variable that divides into your number (same logic as C++), it will render a `true` result.
   
    The C++ implementation uses a function named `isPrime` that could give a `False` result if the `num` variable is less than or equal to 1 or if it divides equally or exactly (i.e., num % i == 0). If you have no variable that divides into your number it will render a `true` result.


    

### Differences

    In Java the text `public` means the method will be accessible and `PrimeCheck` is a method to check for prime or non prime numbers. `Boolean` in Java, is the code is an indicator method that will give an true or false value. 

    C++ includes "<iostream>" is an input-output stream that allows the function `std:: cout and cin` to be used for input-output operations. The `#include<cmath>` provides C++ math library that will include functions like square root; `std` is a prefix function that gives access to the C++ library. The `std` is a standard point for either input or output.
      