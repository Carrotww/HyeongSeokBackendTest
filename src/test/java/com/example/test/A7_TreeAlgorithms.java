package com.example.test;

import java.util.*;

public class A7_TreeAlgorithms {

    /*
     * ===========================
     * 7. Tree Algorithms
     * ===========================
     */

    // 기본 트리 노드
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { this.val = v; }
    }

    // Problem: BFS on Tree (Level Order)
    // Description: 이진트리를 레벨 순서대로 순회한 결과를 반환 (레벨별 리스트)
    // Input: TreeNode root
    // Output: List<List<Integer>> levels
    static List<List<Integer>> levelOrder(TreeNode root) {
        // TODO: Queue
        return new ArrayList<>();
    }

    // Problem: DFS on Tree - Preorder
    // Description: 전위순회 결과를 리스트로 반환
    // Input: TreeNode root
    // Output: List<Integer> order
    static List<Integer> preorder(TreeNode root) {
        // TODO
        return new ArrayList<>();
    }

    // Problem: DFS on Tree - Inorder
    // Description: 중위순회 결과를 리스트로 반환
    // Input: TreeNode root
    // Output: List<Integer> order
    static List<Integer> inorder(TreeNode root) {
        // TODO
        return new ArrayList<>();
    }

    // Problem: DFS on Tree - Postorder
    // Description: 후위순회 결과를 리스트로 반환
    // Input: TreeNode root
    // Output: List<Integer> order
    static List<Integer> postorder(TreeNode root) {
        // TODO
        return new ArrayList<>();
    }

    // Problem: Tree Height / Max Depth
    // Description: 트리의 최대 깊이를 반환
    // Input: TreeNode root
    // Output: int depth
    static int maxDepth(TreeNode root) {
        // TODO
        return 0;
    }

    // Problem: Validate BST
    // Description: 이진트리가 BST인지 판별
    // Input: TreeNode root
    // Output: boolean
    static boolean isValidBST(TreeNode root) {
        // TODO: 범위(min,max) DFS
        return false;
    }

    // Problem: Lowest Common Ancestor (Binary Tree)
    // Description: 일반 이진트리에서 p,q의 LCA를 반환
    // Input: TreeNode root, TreeNode p, TreeNode q
    // Output: TreeNode lca
    static TreeNode lcaBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        // TODO
        return null;
    }

    // Problem: Diameter of Binary Tree
    // Description: 트리의 지름(가장 긴 경로의 간선 수 혹은 노드 수)을 반환 (정의는 구현에서 통일)
    // Input: TreeNode root
    // Output: int diameter
    static int diameter(TreeNode root) {
        // TODO
        return 0;
    }

    // Problem: Serialize & Deserialize (Optional)
    // Description: 트리를 문자열로 직렬화/역직렬화하는 골격 (라이브코테 단골)
    // Input: TreeNode root / String data
    // Output: String / TreeNode
    static String serialize(TreeNode root) {
        // TODO: level order with null markers
        return "";
    }

    static TreeNode deserialize(String data) {
        // TODO
        return null;
    }
}
