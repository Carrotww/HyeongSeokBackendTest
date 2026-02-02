package com.example.test;

import java.util.*;

public class A3_TwoPointersSlidingImpl {

    /*
     * ===========================
     * 3. Two Pointers / Sliding Window
     * ===========================
     */

    static int maxSumFixedWindow(int[] arr, int k) {
        if (k <= 0 || arr.length < k) return 0;
        long sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        long best = sum;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            best = Math.max(best, sum);
        }
        return (int) best;
    }

    static int minLenSubarrayAtLeastTarget(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        long sum = 0;
        int best = Integer.MAX_VALUE;
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum >= target) {
                best = Math.min(best, r - l + 1);
                sum -= arr[l++];
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }

    static int removeDuplicatesSorted(int[] arr) {
        if (arr.length == 0) return 0;
        int w = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[w - 1]) arr[w++] = arr[i];
        }
        return w;
    }

    static int countSubarraySumEqualsK(int[] arr, int k) {
        Map<Long, Integer> freq = new HashMap<>();
        freq.put(0L, 1);
        long ps = 0;
        int count = 0;
        for (int x : arr) {
            ps += x;
            long need = ps - k;
            count += freq.getOrDefault(need, 0);
            freq.put(ps, freq.getOrDefault(ps, 0) + 1);
        }
        return count;
    }

    static int longestSubstringNoRepeat(String s) {
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int best = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int ch = s.charAt(r);
            if (last[ch] >= l) l = last[ch] + 1;
            last[ch] = r;
            best = Math.max(best, r - l + 1);
        }
        return best;
    }
}
