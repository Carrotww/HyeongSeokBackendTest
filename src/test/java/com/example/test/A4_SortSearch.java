package com.example.test;

import java.util.*;

public class A4_SortSearch {

    /*
     * ===========================
     * 4. Sorting / Searching
     * ===========================
     */

    // Problem: Lower Bound
    // Description: 정렬된 arr에서 target 이상이 처음 등장하는 인덱스 반환 (없으면 n)
    // Input: int[] arr, int target
    // Output: int idx
    static int lowerBound(int[] arr, int target) {
        // TODO
        return 0;
    }

    // Problem: Upper Bound
    // Description: 정렬된 arr에서 target 초과가 처음 등장하는 인덱스 반환 (없으면 n)
    // Input: int[] arr, int target
    // Output: int idx
    static int upperBound(int[] arr, int target) {
        // TODO
        return 0;
    }

    // Problem: Binary Search - exact
    // Description: 정렬된 arr에서 target의 인덱스 반환 (없으면 -1)
    // Input: int[] arr, int target
    // Output: int idx
    static int binarySearchExact(int[] arr, int target) {
        // TODO
        return -1;
    }

    // Problem: Parametric Search (Binary Search on Answer)
    // Description: 결정 문제 feasible(mid)를 이용해 최소/최대 답을 찾는 골격
    // Input: int lo, int hi
    // Output: int best
    static int parametricSearchExample(int lo, int hi) {
        // TODO: while (lo<=hi) { mid; if (feasible) ... }
        return 0;
    }

    // Problem: Sort with Custom Comparator
    // Description: (value, index) 같은 Pair 객체 리스트를 정렬하는 예시 골격
    // Input: List<int[]> pairs (each {a,b})
    // Output: List<int[]> sorted
    static List<int[]> sortPairs(List<int[]> pairs) {
        // TODO: Collections.sort with comparator
        return pairs;
    }

    // Problem: Merge Intervals
    // Description: intervals를 병합하여 겹치는 구간을 합친 결과 반환
    // Input: int[][] intervals (each {start,end})
    // Output: int[][] merged
    static int[][] mergeIntervals(int[][] intervals) {
        // TODO: sort by start, then merge
        return new int[0][0];
    }
}
