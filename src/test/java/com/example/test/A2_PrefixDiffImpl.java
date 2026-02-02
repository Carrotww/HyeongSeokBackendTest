package com.example.test;

import java.util.*;

public class A2_PrefixDiffImpl {

    /*
     * ===========================
     * 2. 누적 합 / 차이 배열
     * ===========================
     */

    static int[] prefixSum1D(int[] arr) {
        int n = arr.length;
        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++)
            ps[i] = ps[i - 1] + arr[i - 1];
        return ps;
    }

    static int rangeSum1D(int[] ps, int l, int r) {
        // 0-indexed inclusive
        return ps[r + 1] - ps[l];
    }

    static int[][] prefixSum2D(int[][] grid) {
        int n = grid.length;
        int m = (n == 0 ? 0 : grid[0].length);
        int[][] ps = new int[n + 1][m + 1];
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                ps[r][c] = ps[r - 1][c] + ps[r][c - 1] - ps[r - 1][c - 1] + grid[r - 1][c - 1];
            }
        }
        return ps;
    }

    static int rangeSum2D(int[][] ps, int r1, int c1, int r2, int c2) {
        // 0-indexed inclusive
        int R1 = r1 + 1, C1 = c1 + 1, R2 = r2 + 1, C2 = c2 + 1;
        return ps[R2][C2] - ps[R1 - 1][C2] - ps[R2][C1 - 1] + ps[R1 - 1][C1 - 1];
    }

    static int[] applyRangeAdd1D(int n, int[][] updates) {
        long[] diff = new long[n + 1]; // r+1 처리 위해 n까지
        for (int[] u : updates) {
            int l = u[0], r = u[1], d = u[2];
            diff[l] += d;
            if (r + 1 < diff.length)
                diff[r + 1] -= d;
        }
        int[] arr = new int[n];
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            arr[i] = (int) cur;
        }
        return arr;
    }

    static int[][] applyRangeAdd2D(int n, int m, int[][] updates) {
        long[][] diff = new long[n + 1][m + 1];
        for (int[] u : updates) {
            int r1 = u[0], c1 = u[1], r2 = u[2], c2 = u[3], d = u[4];
            diff[r1][c1] += d;
            if (c2 + 1 < m)
                diff[r1][c2 + 1] -= d;
            if (r2 + 1 < n)
                diff[r2 + 1][c1] -= d;
            if (r2 + 1 < n && c2 + 1 < m)
                diff[r2 + 1][c2 + 1] += d;
        }

        // 누적 복원: 2D prefix on diff
        int[][] grid = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                long a = diff[r][c];
                long up = (r > 0 ? diff[r - 1][c] : 0);
                long left = (c > 0 ? diff[r][c - 1] : 0);
                long diag = (r > 0 && c > 0 ? diff[r - 1][c - 1] : 0);
                diff[r][c] = a + up + left - diag;
                grid[r][c] = (int) diff[r][c];
            }
        }
        return grid;
    }
}
