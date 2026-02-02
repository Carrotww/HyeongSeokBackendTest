package com.example.test;

import java.util.*;

public class A9_BacktrackingImpl {

    /*
     * ===========================
     * 9. Backtracking / Combinatorics
     * ===========================
     */

    static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        permDfs(nums, used, path, res);
        return res;
    }

    private static void permDfs(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.addLast(nums[i]);
            permDfs(nums, used, path, res);
            path.removeLast();
            used[i] = false;
        }
    }

    static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        combDfs(1, n, k, path, res);
        return res;
    }

    private static void combDfs(int start, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int x = start; x <= n; x++) {
            // 가지치기: 남은 수로 k 채울 수 없는 경우
            int remainNeed = k - path.size();
            int remainHave = n - x + 1;
            if (remainHave < remainNeed) break;

            path.addLast(x);
            combDfs(x + 1, n, k, path, res);
            path.removeLast();
        }
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        subsetDfs(0, nums, path, res);
        return res;
    }

    private static void subsetDfs(int idx, int[] nums, Deque<Integer> path, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // not take
        subsetDfs(idx + 1, nums, path, res);

        // take
        path.addLast(nums[idx]);
        subsetDfs(idx + 1, nums, path, res);
        path.removeLast();
    }

    static int nQueensCount(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // r+c
        boolean[] diag2 = new boolean[2 * n]; // r-c+n
        return nQueenDfs(0, n, col, diag1, diag2);
    }

    private static int nQueenDfs(int r, int n, boolean[] col, boolean[] d1, boolean[] d2) {
        if (r == n) return 1;
        int cnt = 0;
        for (int c = 0; c < n; c++) {
            int a = r + c;
            int b = r - c + n;
            if (col[c] || d1[a] || d2[b]) continue;
            col[c] = d1[a] = d2[b] = true;
            cnt += nQueenDfs(r + 1, n, col, d1, d2);
            col[c] = d1[a] = d2[b] = false;
        }
        return cnt;
    }
}
