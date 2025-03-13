
// let number = prompt("Enter a number to check if it is a Prime number");

function checkPrime(number) {
    if (number === null || number === undefined) {
        console.log("You have not entered a number");
        return false;
    }

    if (number <= 1) {
        console.log("This is not a prime number");
        return false; // Numbers less than or equal to 1 are not prime
    }

    for (let i = 2; i < Math.sqrt(number); i++) {
        if (number % i === 0) {
            console.log("This is not a prime number");
            return false; // If divisible by any number other than 1 and itself
        }
    }

    console.log("This is a prime number");
    return true; // If no divisors were found, the number is prime
}

//you can change the number inside of the checkPrime function to test different numbers
console.log(checkPrime(45)); // 
console.log(checkPrime(23)); // 
console.log(checkPrime(13)); // 