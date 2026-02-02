package com.example.test;

import java.util.*;

public class A1_WarmupBasicsImpl {

    /*
     * ===========================
     * 1. 기본(워밍업) / 자료형 감각
     * ===========================
     */

    static Map<Integer, Integer> countFrequencies(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr)
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        return freq;
    }

    static int[] twoSumIndices(int[] arr, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];
            if (idx.containsKey(need))
                return new int[] { idx.get(need), i };
            idx.put(arr[i], i);
        }
        return new int[] { -1, -1 };
    }

    static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);

            // 알파/숫자만 보려면 아래 주석 해제
            // while (l < r && !Character.isLetterOrDigit(cl)) { l++; cl = s.charAt(l); }
            // while (l < r && !Character.isLetterOrDigit(cr)) { r--; cr = s.charAt(r); }

            if (Character.toLowerCase(cl) != Character.toLowerCase(cr))
                return false;
            l++;
            r--;
        }
        return true;
    }

    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] cnt = new int[256]; // ASCII 기준 (필요시 확장)
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
            cnt[t.charAt(i)]--;
        }
        for (int x : cnt)
            if (x != 0)
                return false;
        return true;
    }

    static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static int lcm(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        int g = gcd(a, b);
        long res = (long) a / g * (long) b;
        if (res > Integer.MAX_VALUE)
            return (int) (res % Integer.MAX_VALUE); // overflow 방지용(원하면 long으로 바꾸자)
        return (int) Math.abs(res);
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; (long) i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    static boolean[] sieve(int n) {
        boolean[] prime = new boolean[Math.max(0, n + 1)];
        if (n < 2)
            return prime;
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; (long) i * i <= n; i++) {
            if (!prime[i])
                continue;
            for (int j = i * i; j <= n; j += i)
                prime[j] = false;
        }
        return prime;
    }

    static String toBinaryString(int n) {
        return Integer.toBinaryString(n);
    }

    static int parseBaseN(String s, int base) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = Character.digit(s.charAt(i), base);
            if (d < 0)
                throw new IllegalArgumentException("invalid digit for base " + base);
            res = res * base + d;
        }
        return res;
    }

    static int setBit(int x, int k) {
        return x | (1 << k);
    }

    static int unsetBit(int x, int k) {
        return x & ~(1 << k);
    }

    static int toggleBit(int x, int k) {
        return x ^ (1 << k);
    }

    static boolean isBitSet(int x, int k) {
        return (x & (1 << k)) != 0;
    }
}
