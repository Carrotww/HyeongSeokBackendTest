package com.example.test;

import java.util.*;

public class A8_DPAlgorithmsImpl {

    /*
     * ===========================
     * 8. Dynamic Programming
     * ===========================
     */

    static long fib(int n) {
        if (n < 0)
            return 0;
        if (n <= 1)
            return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    static int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n <= 2)
            return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    static int knapsack01(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < n; i++) {
            int w = weights[i], v = values[i];
            for (int cap = capacity; cap >= w; cap--) {
                dp[cap] = Math.max(dp[cap], dp[cap - w] + v);
            }
        }
        return dp[capacity];
    }

    static int lisLength(int[] arr) {
        if (arr.length == 0)
            return 0;
        int[] tails = new int[arr.length];
        int len = 0;
        for (int x : arr) {
            int i = lowerBound(tails, 0, len, x);
            tails[i] = x;
            if (i == len)
                len++;
        }
        return len;
    }

    private static int lowerBound(int[] a, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] >= target)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    static int lcsLength(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char ca = a.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char cb = b.charAt(j - 1);
                if (ca == cb)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    static int editDistance(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int j = 0; j <= m; j++)
            dp[0][j] = j;
        for (int i = 1; i <= n; i++) {
            char ca = a.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char cb = b.charAt(j - 1);
                int cost = (ca == cb) ? 0 : 1;
                dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost);
            }
        }
        return dp[n][m];
    }
}
