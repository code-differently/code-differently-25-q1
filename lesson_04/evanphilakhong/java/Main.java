public class Main {

    /**
     * @param args the command line arguments
     */

     public static boolean isPrime(int num) {
        int count = 0;
        for (int i = num; i > 0; i--) {
            if (num%i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("This is a Prime Number");
            return true;
        }
        System.out.println("This is not a Prime Number");
        return false;
     }
    public static void main(String[] args) {
        System.out.println("Testing Prime Nums");
        isPrime(2);
        isPrime(3);
        isPrime(5);
        isPrime(7);
        isPrime(11);
        System.out.println("Testing Non-Prime Nums");
        isPrime(1);
        isPrime(4);
        isPrime(6);
        isPrime(8);
        isPrime(9);
    }

}
