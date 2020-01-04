package Miscellaneous;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class P6_RepeatedProductNumbers {

    public static void main(String args[]){
        //System.out.println(getPairs(126));

        System.out.println(getPairs2(136948).toString().replace("=", "*"));
        System.out.println(getNearestRPN(127));
        System.out.println(getAllRPNsUptoN(1000));
    }

    private static List<Integer> getAllRPNsUptoN(int n){
        List<Integer> list = new ArrayList<>();
        for(int i=126 ; i<=n ; i++)
            if(!getPairs2(i).isEmpty())
                list.add(i);
        return list;
    }

    private static int getNearestRPN(int n){
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        while (pairs.isEmpty())
            pairs = getPairs2(n++);
        return n-1;
    }

    /**
     * Method 2: Using Substrings of permutations
     * Eradicated all failures of previous method
     */
    private static List<Pair<Integer, Integer>> getPairs2(int x){
        List<String> strings = new ArrayList<>();
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        getStringPermuations(strings, x + "", "");
        for(String s : strings){
            for(int i=1 ; i<s.length() ; i++){
                if(s.charAt(i) == '0')
                    continue;
                int m = Integer.parseInt(s.substring(0, i))
                        , n = Integer.parseInt(s.substring(i, s.length()));

                if(m*n == x){
                    Pair<Integer, Integer> pair = new Pair<>(m, n);
                    if(!pairs.contains(pair) && !pairs.contains(new Pair<>(n, m)))
                        pairs.add(pair);
                }
            }
        }
        return pairs;
    }

    /**
     * Method 1: Using Repeated division
     * Failures :
     * i.   Not able to prevent pairs with numbers having leading zeroes
     * ii.  Missing out pairs with numbers having zero in between
     * iii. Duplicate pairs
     */
    private static List<Pair<Integer, Integer>> getPairs(int x){
        List<Integer> nums = getNumberPermutations(x);
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();

        for(int n : nums){
            int m=0, nCopy = n, count = 0;
            while (n >= 10){
                m += m == 0 ? n%10 : (n%10) * 10;
                n /= 10;
                if(n >= 10)
                    count++;
            }

            if(n*m == x)
                pairs.add(new Pair<>(n, m));

            for(int i=0 ; i<count ; i++){
                int n2 = nCopy;
                m = 0;
                for(int j=0 ; j<i ; j++){
                    m += m == 0 ? n2%10 : (n2%10) * 10;
                    n2 /= 10;
                }

                if(n2*m == x)
                    pairs.add(new Pair<>(n2, m));
            }
        }

        return pairs;
    }

    private static List<Integer> getNumberPermutations(int n){
        List<String> strings = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        getStringPermuations(strings, n + "", "");
        for(String s : strings)
            nums.add(Integer.parseInt(s));
        return nums;
    }

    private static void getStringPermuations(List<String> list, String s, String prefix){
        if(s.equals("")){
            list.add(prefix);
            return;
        }

        for(int i=0 ; i<s.length() ; i++)
            getStringPermuations(list, s.substring(0, i) + s.substring(i+1, s.length()), prefix + s.charAt(i));
    }

}
