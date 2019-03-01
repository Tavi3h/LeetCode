package pers.tavish.solution.easy;

/*

Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

*/

public class CountPrimes {
    
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
    
//    public int countPrimes(int n) {
//        int count = 0;
//        for (int i = 2; i <= n - 1; i++) {
//            if (isPrime(i)) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private boolean isPrime(int n) {
//        int sqrt = (int) Math.sqrt(n);
//        for (int i = 2; i <= sqrt; i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
