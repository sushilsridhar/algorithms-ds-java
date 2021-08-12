package algo.dynamicprogramming;

import java.util.HashMap;

public class PowerOfDynamicProgramming {

    static int c =0;

    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static int d =0;

    public static void main(String[] args) {

        System.out.println(findFibanacci(10));
        System.out.println("calculations needed: "+ c);

        System.out.println(findFibanacciDP(10));
        System.out.println("calculations needed: "+ d);
    }

    // Time: O(n), since we do only necessary calculations
    private static int findFibanacciDP(int n) {
        d++;
        if(n < 2)
            return n;

        if(hashMap.containsKey(n)) {
            return hashMap.get(n);
        } else {
            hashMap.put(n, findFibanacciDP(n-1) + findFibanacciDP(n-2));
            return hashMap.get(n);
        }
    }

    // Time: O(2^n)
    private static int findFibanacci(int n) {
        c++;
        if(n < 2)
            return n;

        return findFibanacci(n-1) + findFibanacci(n-2);
    }
}
