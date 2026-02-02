package com.example.test;

import java.util.*;
import java.util.function.IntPredicate;

public class A4_SortSearchImpl {

    /*
     * ===========================
     * 4. Sorting / Searching
     * ===========================
     */

    static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length; // [lo, hi)
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int binarySearchExact(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    // 원래 시그니처 유지(예시): "true가 되는 최초 mid" 찾기 (feasibleExample 사용)
    static int parametricSearchExample(int lo, int hi) {
        // 예시 결정문제: mid >= 0 ? (그냥 템플릿 동작 확인용)
        return parametricSearchFirstTrue(lo, hi, mid -> mid >= 0);
    }

    // 실전용 오버로드(추천): 결정문제(feasible)를 외부에서 주입
    static int parametricSearchFirstTrue(int lo, int hi, IntPredicate feasible) {
        int ans = hi + 1; // 못 찾으면 hi+1
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (feasible.test(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    static List<int[]> sortPairs(List<int[]> pairs) {
        List<int[]> res = new ArrayList<>(pairs);
        res.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        return res;
    }

    static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int s = intervals[0][0], e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int ns = intervals[i][0], ne = intervals[i][1];
            if (ns <= e) e = Math.max(e, ne);
            else {
                merged.add(new int[]{s, e});
                s = ns; e = ne;
            }
        }
        merged.add(new int[]{s, e});
        return merged.toArray(new int[0][]);
    }
}
