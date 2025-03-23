# Prime Time

## Composite # Check Python
 ### Requirements
- Python 3.x

```python
# Function to check if a number is composite
def is_composite(number):
    if number < 2:
        return f"{number} is neither prime nor composite."

    # Check for factors from 2 to sqrt(number)
    for i in range(2, int(number**0.5) + 1):
        if number % i == 0:
            return f"{number} is a composite number."

    return f"{number} is a prime number."
```

## Prime # Check Bash

```bash
# Function to check if a number is prime
is_prime() {
    local num=$1
    if ((num <= 1)); then
        echo "$num is not prime."
        return 1
    fi
    # Function to check factors from 2 to square root(number)
    for ((i = 2; i <= num / 2; i++)); do
        if ((num % i == 0)); then
            echo "$num is not prime."
            return 1
        fi
    done
    echo "$num is prime."
}
```

## Explanation

The Python Script isn't your conventional prime number detector. Instead I took the approach of using a composite number detector that uses the function `is_composite` to show weather the `number` you input is composite. If inputted number is less than 2 then `it's neither prime nor composite`. If previous rule is false(greater than 2) then we run factors of 2 to the square root to determine `results`. Any factor larger than the square root would already have a corresponding smaller factor so will know if our `number is composite` or not.

 Next, the Bash Script is a classic prime numbers check that uses the function `is_prime` to... you've guessed it check if users number is a prime. Said function will first check if the inputted `number` is greater than or equal to 1; If said previous rule was true then the we stop. If false, then it will run sequence to determine if said number is has factors from 2 to square root of number. When done if 2 factors are found it `isn't a prime number` and `is a prime number` if 2 aren't found. System will `echo`(notify user) of final verdict.

## Differences


1. **Syntax**: 
   - In Python, we use `def` as our keyword and `int` as a way to describe the inputted number.
   - In Bash we use `local` as our keyword and `num`/`$num` as a way to describe inputted number from users.
   
2. **Function Calls**:
   - `Print` is used to call functions and output information for Python while `Echo` is  used for Bash, in which both give info to the the user.

3. **Composite vs Prime**:
   - The Python script is used to determine weather the inputted number `is a Composite number`; In doing so we also get the reciprocal on if it's a prime number as well.
   - The Bash Script is the opposite in which where looking for if the inputted number `is prime` and in doing so we get the reciprocal if it isn't.