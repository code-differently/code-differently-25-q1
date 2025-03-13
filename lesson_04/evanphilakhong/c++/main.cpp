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
    isPrime(10);
    return 0;
}