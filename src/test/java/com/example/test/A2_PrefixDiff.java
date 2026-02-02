package com.example.test;

import java.util.*;

public class A2_PrefixDiff {

    /*
     * ===========================
     * 2. 누적 합 / 차이 배열
     * ===========================
     */

    // Problem: 1D Prefix Sum
    // Description: arr에 대해 ps[0]=0, ps[i]=arr[0..i-1] 합을 갖는 길이 n+1 누적합 반환
    // Input: int[] arr
    // Output: int[] ps
    static int[] prefixSum1D(int[] arr) {
        // TODO
        return new int[arr.length + 1];
    }

    // Problem: Range Sum Query (1D)
    // Description: prefixSum 배열 ps를 이용해 [l, r] 구간합을 O(1)에 반환 (0-indexed, inclusive)
    // Input: int[] ps, int l, int r
    // Output: int sum
    static int rangeSum1D(int[] ps, int l, int r) {
        // TODO: ps[r+1] - ps[l]
        return 0;
    }

    // Problem: 2D Prefix Sum
    // Description: grid에 대해 2D prefix sum ps를 만든다. ps는 (n+1)x(m+1).
    // Input: int[][] grid
    // Output: int[][] ps
    static int[][] prefixSum2D(int[][] grid) {
        // TODO
        int n = grid.length;
        int m = (n == 0 ? 0 : grid[0].length);
        return new int[n + 1][m + 1];
    }

    // Problem: Range Sum Query (2D)
    // Description: 2D prefix sum ps로 (r1,c1)~(r2,c2) 직사각형 합을 O(1)에 반환 (0-indexed, inclusive)
    // Input: int[][] ps, int r1, int c1, int r2, int c2
    // Output: int sum
    static int rangeSum2D(int[][] ps, int r1, int c1, int r2, int c2) {
        // TODO: inclusion-exclusion
        return 0;
    }

    // Problem: Difference Array 1D (range add)
    // Description: 길이 n 배열에 대해, range updates (l,r,delta)를 diff에 누적한 뒤 최종 배열을 만든다.
    // Input: int n, int[][] updates (each {l,r,delta})
    // Output: int[] arr
    static int[] applyRangeAdd1D(int n, int[][] updates) {
        // TODO: diff[l]+=d, diff[r+1]-=d; prefix로 복원
        return new int[n];
    }

    // Problem: Difference Array 2D (range add)
    // Description: n*m grid에 대해, 직사각형 업데이트 (r1,c1,r2,c2,delta)를 적용한 최종 grid 반환
    // Input: int n, int m, int[][] updates (each {r1,c1,r2,c2,delta})
    // Output: int[][] grid
    static int[][] applyRangeAdd2D(int n, int m, int[][] updates) {
        // TODO: 2D diff (imos)
        return new int[n][m];
    }
}
