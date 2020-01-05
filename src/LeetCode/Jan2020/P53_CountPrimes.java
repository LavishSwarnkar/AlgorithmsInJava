package LeetCode.Jan2020;

public class P53_CountPrimes {

    public static void main(String args[]){
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        boolean[] isNonPrime = new boolean[n];

        for (int i=2 ; i*i<n ; i++) {
            if (isNonPrime[i]) continue;
            for (int j=i*i ; j<n ; j += i)
                isNonPrime[j] = true;
        }

        int count = 0;
        for (int i=2 ; i<n ; i++)
            if (!isNonPrime[i]) count++;

        return count;
    }

}
