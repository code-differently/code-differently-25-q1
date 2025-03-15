
# Python Implementation

---

```python
def is_prime(n):
    """Check if a number is prime."""
    if n < 2:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True

# Example usage
if is_prime(num):
    print(f"{3} is a prime number.")
else:
    print(f"{4} is not a prime number.")

```

# JavaScript Implementation

---

```JavaScript

function isPrime(n) {
    if (n < 2) return false;
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) return false;
    }
    return true;
}

// Example usage
    if (isPrime(num)) {
        console.log(`${3} is a prime number.`);
    } else {
        console.log(`${4} is not a prime number.`);
    }


```

# Explanation

---

As seen above, I have created a code that helps the user determine whether a number is a prime number or not. I utilized both Python and Javascript to do so and this was my first time writing out my own code with those languages. The sample numbers **(3)** and **(4)** were used to show the reader, **you**, what an example of a prime number looks like. **Is_prime** stands for the command that determines whether a number **(num or n)** is prime or not. 

## Similarities 

- Both implementations display the number **(3)** as the prime number and **(4)** as the non-prime number. 
- Both  use **"if"** and **"is_prime"** to point out if a number is prime or not.
- Both implementations return **"true"** or **"false"** depending on whether the number is a prime number or not. 

## Differences

- The codeword used to determine the answer for the Java Code implementation is **console.log**.
- The codeword used to determine the answer for the Python implementation is **print**. 
- Python uses **def** before is_prime and JavaScript uses **function** before is_prime.
  
  ---

### Bonus message from the creator: 
Hello World! Again, this was my first time creating my own code. I had lots of fun working in JavaScript and Python, but would love to hear some good feedback or even complaints that you, the reader, may have. I spent a good **2 hours** trying to figure out how to get both Python and Javascript to work in a Markdown file. If any part of my code was confusing or uneasy to read, let a sista know! Happy coding! - A'nanatawa 