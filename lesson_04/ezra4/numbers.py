
# Function to check if a number is prime

def prime_num(num):  # This is function to check if a number is prime
    if num <= 1:  # This will help check if number is less than or equal to 1
        return False
    for i in range(2, num):  # This will help check if number is divisible by any number between 2 and the number itself
        if num % i == 0:
            return False
    return True


# Ask user for a number and check if it is prime
number = int(input("Enter a number: "))
if prime_num(number):
    print(f"{number} is a prime number.")
else:
    print(f"{number} is not a prime number.")
