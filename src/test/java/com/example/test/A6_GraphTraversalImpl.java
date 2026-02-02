package com.example.test;

import java.util.*;

public class A6_GraphTraversalImpl {

    /*
     * ===========================
     * 6. Graph / Grid Traversal
     * ===========================
     */

    // 0 = 이동 가능, 1 = 벽(이동 불가) 가정
    static int bfsGridShortestPath(int[][] grid, int sr, int sc, int tr, int tc) {
        int n = grid.length;
        int m = (n == 0 ? 0 : grid[0].length);
        if (n == 0 || m == 0) return -1;
        if (!in(n, m, sr, sc) || !in(n, m, tr, tc)) return -1;
        if (grid[sr][sc] == 1 || grid[tr][tc] == 1) return -1;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, -1);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int r = cur[0], c = cur[1];
            if (r == tr && c == tc) return dist[r][c];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (!in(n, m, nr, nc)) continue;
                if (grid[nr][nc] == 1) continue;
                if (dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }
        return -1;
    }

    static int countIslandsDFS(int[][] grid) {
        int n = grid.length;
        int m = (n == 0 ? 0 : grid[0].length);
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1 && !vis[r][c]) {
                    cnt++;
                    dfsIsland(grid, vis, r, c);
                }
            }
        }
        return cnt;
    }

    private static void dfsIsland(int[][] grid, boolean[][] vis, int r, int c) {
        int n = grid.length, m = grid[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[]{r, c});
        vis[r][c] = true;

        while (!st.isEmpty()) {
            int[] cur = st.pop();
            int cr = cur[0], cc = cur[1];
            for (int k = 0; k < 4; k++) {
                int nr = cr + dr[k], nc = cc + dc[k];
                if (!in(n, m, nr, nc)) continue;
                if (grid[nr][nc] != 1) continue;
                if (vis[nr][nc]) continue;
                vis[nr][nc] = true;
                st.push(new int[]{nr, nc});
            }
        }
    }

    static int[] bfsGraphDistances(int n, List<List<Integer>> graph, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Deque<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            for (int v : graph.get(u)) {
                if (dist[v] != -1) continue;
                dist[v] = dist[u] + 1;
                q.add(v);
            }
        }
        return dist;
    }

    static List<Integer> dfsGraphOrder(int n, List<List<Integer>> graph, int start) {
        boolean[] vis = new boolean[n];
        List<Integer> order = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
        st.push(start);

        while (!st.isEmpty()) {
            int u = st.pop();
            if (vis[u]) continue;
            vis[u] = true;
            order.add(u);

            // 재귀 DFS 순서 흉내내려면 역순으로 push
            List<Integer> adj = graph.get(u);
            for (int i = adj.size() - 1; i >= 0; i--) {
                int v = adj.get(i);
                if (!vis[v]) st.push(v);
            }
        }
        return order;
    }

    static long[] dijkstra(int n, List<List<int[]>> graph, int start) {
        final long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, start});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d != dist[u]) continue;

            for (int[] e : graph.get(u)) {
                int v = e[0];
                int w = e[1];
                long nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new long[]{nd, v});
                }
            }
        }
        return dist;
    }

    static int[] dsuBuild(int n, int[][] unions) {
        DSU dsu = new DSU(n);
        for (int[] u : unions) dsu.union(u[0], u[1]);
        return dsu.parent;
    }

    static int[] topologicalSortKahn(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        int[] indeg = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.get(u).add(v);
            indeg[v]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.add(i);

        int[] topo = new int[n];
        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.removeFirst();
            topo[idx++] = u;
            for (int v : g.get(u)) {
                if (--indeg[v] == 0) q.add(v);
            }
        }
        if (idx != n) return new int[0]; // cycle
        return topo;
    }

    private static boolean in(int n, int m, int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] == x) return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (rank[ra] < rank[rb]) {
                parent[ra] = rb;
            } else if (rank[ra] > rank[rb]) {
                parent[rb] = ra;
            } else {
                parent[rb] = ra;
                rank[ra]++;
            }
            return true;
        }
    }
}
