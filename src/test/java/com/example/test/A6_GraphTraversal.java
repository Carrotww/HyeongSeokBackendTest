package com.example.test;

import java.util.*;

public class A6_GraphTraversal {

    /*
     * ===========================
     * 6. Graph / Grid Traversal
     * ===========================
     */

    // Problem: BFS on Grid - Shortest Path
    // Description: 0/1 grid에서 (sr,sc) -> (tr,tc) 최단거리(4방향) 반환, 불가능하면 -1
    // Input: int[][] grid, int sr, int sc, int tr, int tc
    // Output: int dist
    static int bfsGridShortestPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // TODO
        return -1;
    }

    // Problem: DFS on Grid - Count Components (islands)
    // Description: 1로 이루어진 컴포넌트 개수(4방향)를 반환
    // Input: int[][] grid
    // Output: int count
    static int countIslandsDFS(int[][] grid) {
        // TODO
        return 0;
    }

    // Problem: Graph BFS (adj list)
    // Description: 그래프에서 start로부터의 최단거리(간선 가중치 1)를 dist 배열로 반환. 도달 불가 = -1
    // Input: int n, List<List<Integer>> graph, int start
    // Output: int[] dist
    static int[] bfsGraphDistances(int n, List<List<Integer>> graph, int start) {
        // TODO
        return new int[n];
    }

    // Problem: Graph DFS (adj list)
    // Description: start에서 도달 가능한 노드를 방문 순서 리스트로 반환
    // Input: int n, List<List<Integer>> graph, int start
    // Output: List<Integer> order
    static List<Integer> dfsGraphOrder(int n, List<List<Integer>> graph, int start) {
        // TODO
        return new ArrayList<>();
    }

    // Problem: Dijkstra
    // Description: 가중치 양수 그래프에서 start로부터 최단거리 배열 반환. 도달 불가 = INF(큰 값)
    // Input: int n, List<List<int[]>> graph (each edge {to, w}), int start
    // Output: long[] dist
    static long[] dijkstra(int n, List<List<int[]>> graph, int start) {
        // TODO: PriorityQueue<long[]{dist,node}>
        return new long[n];
    }

    // Problem: Union-Find (DSU) - Build + Queries
    // Description: DSU를 이용해 union/find를 처리하는 기본 골격. (여기선 parent 배열 반환)
    // Input: int n, int[][] unions (each {a,b})
    // Output: int[] parent
    static int[] dsuBuild(int n, int[][] unions) {
        // TODO
        return new int[n];
    }

    // Problem: Topological Sort (Kahn)
    // Description: DAG의 위상정렬 결과를 반환. 사이클이면 빈 배열 반환.
    // Input: int n, int[][] edges (each {u,v} meaning u->v)
    // Output: int[] topo
    static int[] topologicalSortKahn(int n, int[][] edges) {
        // TODO
        return new int[0];
    }
}
