package com.example.test;

import java.util.*;

public class A5_StackQueueHeapImpl {

    /*
     * ===========================
     * 5. Stack / Queue / Deque / Heap
     * ===========================
     */

    static boolean validParentheses(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }
        return st.isEmpty();
    }

    static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>(); // index stack (monotonic decreasing)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return ans;
    }

    static int largestRectangleHistogram(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>(); // increasing stack
        long best = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);
            while (!st.isEmpty() && heights[st.peek()] > h) {
                int height = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;
                best = Math.max(best, (long) height * width);
            }
            st.push(i);
        }
        return (int) best;
    }

    static List<String> queueSimulation(List<String> commands) {
        Deque<Integer> q = new ArrayDeque<>();
        List<String> out = new ArrayList<>();
        for (String cmd : commands) {
            String[] sp = cmd.split(" ");
            switch (sp[0]) {
                case "push":
                    q.addLast(Integer.parseInt(sp[1]));
                    break;
                case "pop":
                    out.add(q.isEmpty() ? "-1" : String.valueOf(q.removeFirst()));
                    break;
                case "front":
                    out.add(q.isEmpty() ? "-1" : String.valueOf(q.peekFirst()));
                    break;
                case "back":
                    out.add(q.isEmpty() ? "-1" : String.valueOf(q.peekLast()));
                    break;
                case "size":
                    out.add(String.valueOf(q.size()));
                    break;
                case "empty":
                    out.add(q.isEmpty() ? "1" : "0");
                    break;
                default:
                    out.add("ERR");
            }
        }
        return out;
    }

    static int[] slidingWindowMax(int[] arr, int k) {
        int n = arr.length;
        if (k <= 0 || n < k) return new int[0];
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // indices, values decreasing
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.removeFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.removeLast();
            dq.addLast(i);
            if (i >= k - 1) res[i - (k - 1)] = arr[dq.peekFirst()];
        }
        return res;
    }

    static int[] topK(int[] arr, int k) {
        if (k <= 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
        for (int x : arr) {
            if (pq.size() < k) pq.add(x);
            else if (x > pq.peek()) {
                pq.poll();
                pq.add(x);
            }
        }
        int[] res = new int[pq.size()];
        int i = 0;
        for (int x : pq) res[i++] = x; // 정렬 보장 X
        return res;
    }
}
