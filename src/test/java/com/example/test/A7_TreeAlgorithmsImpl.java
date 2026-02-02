package com.example.test;

import java.util.*;

public class A7_TreeAlgorithmsImpl {

    /*
     * ===========================
     * 7. Tree Algorithms
     * ===========================
     */

    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int v) { this.val = v; }
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> level = new ArrayList<>(sz);
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.removeFirst();
                level.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(level);
        }
        return res;
    }

    static List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            res.add(cur.val);
            if (cur.right != null) st.push(cur.right);
            if (cur.left != null) st.push(cur.left);
        }
        return res;
    }

    static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    static List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> st1 = new ArrayDeque<>();
        Deque<TreeNode> st2 = new ArrayDeque<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode cur = st1.pop();
            st2.push(cur);
            if (cur.left != null) st1.push(cur.left);
            if (cur.right != null) st1.push(cur.right);
        }
        while (!st2.isEmpty()) res.add(st2.pop().val);
        return res;
    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    static boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean valid(TreeNode node, long lo, long hi) {
        if (node == null) return true;
        if (!(lo < node.val && node.val < hi)) return false;
        return valid(node.left, lo, node.val) && valid(node.right, node.val, hi);
    }

    static TreeNode lcaBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode L = lcaBinaryTree(root.left, p, q);
        TreeNode R = lcaBinaryTree(root.right, p, q);
        if (L != null && R != null) return root;
        return (L != null) ? L : R;
    }

    static int diameter(TreeNode root) {
        // 간선 수 기준 지름
        int[] best = new int[1];
        heightForDiameter(root, best);
        return best[0];
    }

    private static int heightForDiameter(TreeNode node, int[] best) {
        if (node == null) return -1; // 간선 기준: null = -1, leaf height=0
        int lh = heightForDiameter(node.left, best);
        int rh = heightForDiameter(node.right, best);
        best[0] = Math.max(best[0], lh + rh + 2);
        return Math.max(lh, rh) + 1;
    }

    static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.removeFirst();
            if (cur == null) {
                sb.append("null,");
            } else {
                sb.append(cur.val).append(",");
                q.add(cur.left);
                q.add(cur.right);
            }
        }

        // 뒤쪽 null 정리(선택)
        String[] parts = sb.toString().split(",");
        int end = parts.length - 1;
        while (end >= 0 && (parts[end].isEmpty() || parts[end].equals("null"))) end--;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i <= end; i++) {
            if (i > 0) out.append(",");
            out.append(parts[i]);
        }
        return out.toString();
    }

    static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] parts = data.split(",");
        TreeNode root = parseNode(parts[0]);
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < parts.length) {
            TreeNode cur = q.removeFirst();
            if (cur == null) continue;

            if (i < parts.length) {
                cur.left = parseNode(parts[i++]);
                q.add(cur.left);
            }
            if (i < parts.length) {
                cur.right = parseNode(parts[i++]);
                q.add(cur.right);
            }
        }
        return root;
    }

    private static TreeNode parseNode(String s) {
        if (s == null || s.isEmpty() || s.equals("null")) return null;
        return new TreeNode(Integer.parseInt(s));
    }
}
