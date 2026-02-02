package com.example.test;

import java.util.*;

public class A5_StackQueueHeap {

    /*
     * ===========================
     * 5. Stack / Queue / Deque / Heap
     * ===========================
     */

    // Problem: Valid Parentheses
    // Description: 괄호 문자열 s가 올바른 괄호인지 판별
    // Input: String s
    // Output: boolean
    static boolean validParentheses(String s) {
        // TODO: Stack<Character>
        return false;
    }

    // Problem: Next Greater Element (for each element)
    // Description: 각 원소에 대해 오른쪽에서 처음 만나는 더 큰 값을 배열로 반환. 없으면 -1.
    // Input: int[] arr
    // Output: int[] nge
    static int[] nextGreaterElement(int[] arr) {
        // TODO: monotonic stack
        return new int[arr.length];
    }

    // Problem: Monotonic Stack - Largest Rectangle in Histogram
    // Description: 히스토그램 최대 직사각형 넓이 반환
    // Input: int[] heights
    // Output: int maxArea
    static int largestRectangleHistogram(int[] heights) {
        // TODO
        return 0;
    }

    // Problem: Queue Simulation
    // Description: 주어진 명령 리스트를 시뮬레이션(예: push/pop/front/size/empty)
    // Input: List<String> commands
    // Output: List<String> outputs
    static List<String> queueSimulation(List<String> commands) {
        // TODO
        return new ArrayList<>();
    }

    // Problem: Deque Sliding Window Maximum
    // Description: 윈도우 최대값을 O(n)에 구한다.
    // Input: int[] arr, int k
    // Output: int[] maxValues
    static int[] slidingWindowMax(int[] arr, int k) {
        // TODO: deque of indices
        return new int[Math.max(0, arr.length - k + 1)];
    }

    // Problem: Top K Elements
    // Description: arr에서 가장 큰 k개를 반환 (순서 자유/정렬 여부는 필요 시 확장)
    // Input: int[] arr, int k
    // Output: int[] topK
    static int[] topK(int[] arr, int k) {
        // TODO: min-heap size k
        return new int[Math.max(0, k)];
    }
}
