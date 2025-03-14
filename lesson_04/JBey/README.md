## Python

```python
def primeNumber(num):
    if num <= 1:
        return False
    
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    
    return True

print(is_prime(11))
print(is_prime(4))
print(is_prime(1))
print(is_prime(13))
```

## JavaScript

```javascript
function primeNumber(num) {
    if (num <= 1) {
        return false;
    }
    
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) {
            return false;
        }
    }

    return true;
}

console.log(isPrime(11));
console.log(isPrime(4));
console.log(isPrime(1));
console.log(isPrime(13));
```

## Explanation

Both languages use a function that is called called "PrimeNumber" with an argument called "num" that a number in the code compares itself in order to see if it is an even number or not. They both use a .log system where you put in your arguments (or numbers) in order to see if they're a prime number or not.

JavaScript uses console.log() in order to output files to the console, while python uses print() instead of console.log(). JavaScript uses the word "function" to create a function, while python uses the word "def" to create a function. Python create another function called "range" when creating a for loop, whereas JavaScript does not create another function.