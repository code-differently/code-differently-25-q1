#include "header.hpp"

bool isPrime(int num) {
    int count = 0;
        for (int i = num; i > 0; i--) {
            if (num%i == 0) {
                count++;
            }
        }
        if (count==2) {
            cout << "This is a Prime Number" << endl;
            return true;
        }
    cout << "This is not a Prime Number" << endl;
    return false;
}
// main 
int main() {
    // test
    // prime nums
    cout << "Testing Prime Nums" << endl;
    isPrime(2);
    isPrime(3);
    isPrime(5);
    isPrime(7);
    isPrime(11);
    // non-prime nums
    cout << "Testing Non-Prime Nums" << endl;
    isPrime(1);
    isPrime(4);
    isPrime(6);
    isPrime(8);
    isPrime(9);
    return 0;
}