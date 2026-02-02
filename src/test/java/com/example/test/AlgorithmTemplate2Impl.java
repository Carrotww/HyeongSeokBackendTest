package com.example.test;

import java.util.*;

public class AlgorithmTemplate2Impl {

    /*
     * ===========================
     * 1. 누적 합 / 차이 배열 (Prefix Sum / Difference Array)
     * ===========================
     */

    // Problem: 1D Prefix Sum
    // Description: 주어진 정수 배열 arr에 대해, 길이 n+1의 1차원 누적합 배열 ps를 반환한다.
    //              ps[0] = 0이고, ps[i] = arr[0]부터 arr[i-1]까지의 합 (1 <= i <= n).
    // Input: int[] arr (원본 배열, 길이 n)
    // Output: int[] ps (누적합 배열, 길이 n+1)
    static int[] prefixSum1D(int[] arr) {
        // TODO: ps[0] = 0으로 초기화, i=1..n에 대해 ps[i] 계산 (ps[i] = ps[i-1] + arr[i-1])

        return null;
    }

    // Problem: 2D Prefix Sum
    // Description: 주어진 2차원 배열 board에 대해, 각 좌표까지의 누적합을 담는 2차원 prefix sum 배열을 반환한다.
    //              반환 배열 ps의 크기는 (r+1)x(c+1)이고, ps[i][j]는 원본 배열의 (0,0)부터 (i-1, j-1)까지 사각 영역 합을 의미한다.
    // Input: int[][] board (크기 r x c의 2차원 배열)
    // Output: int[][] ps (크기 (r+1) x (c+1) 누적합 배열)
    static int[][] prefixSum2D(int[][] board) {
        // TODO: ps[0][*] = 0, ps[*][0] = 0으로 초기화 후, 1..r 행과 1..c 열 돌면서 누적합 계산
        return null;
    }

    // Problem: 1D Difference Array (Range Update with Difference)
    // Description: 길이 n의 배열에 여러 번의 구간 업데이트(예: [l, r] 구간에 val을 더하기)를 효율적으로 처리하기 위한 차이 배열을 이용한 함수.
    //              updates 리스트의 각 원소는 {l, r, val} 형태로 업데이트 구간을 나타낸다. 모든 업데이트 적용 후의 최종 배열을 계산하여 반환한다.
    // Input: int n (배열 길이), int[][] updates (각 원소는 {l, r, val}인 2D 배열로 업데이트 목록)
    // Output: int[] result (업데이트 적용 후 최종 배열 값들, 길이 n)
    static int[] differenceArray(int n, int[][] updates) {
        // TODO: diff 배열을 활용하여 각 업데이트를 반영하고, 최종적으로 prefix sum을 적용해 결과 배열 계산

        return null;
    }


    /*
     * ===========================
     * 2. 그래프 탐색 (BFS / DFS 및 응용)
     * ===========================
     */

    // Problem: Depth-First Search (DFS) - Adjacency List (Recursive)
    // Description: 인접 리스트로 표현된 그래프에서 DFS를 수행하여 노드를 방문한다.
    //              재귀 호출을 통해 그래프를 깊이 우선 탐색한다.
    // Input: int n (노드 개수), List<Integer>[] graph (그래프의 인접 리스트 표현), 
    //        int start (시작 노드), boolean[] visited (방문 여부 표시 배열)
    // Output: (반환값 없음; visited 배열을 내부에서 수정하여 방문 표시하거나 필요한 작업 수행)
    static void dfsList(int n, List<Integer>[] graph, int start, boolean[] visited) {
        // TODO: 현재 노드를 방문 처리한 후, 연결된 미방문 이웃 노드들에 대해 재귀적으로 DFS 호출
    }

    // Problem: Breadth-First Search (BFS) - Adjacency List (Queue)
    // Description: 인접 리스트로 표현된 그래프에서 BFS를 수행하여 각 노드의 거리(distances)를 계산한다. 
    //              시작 노드로부터의 최단 거리(간선 수 기준)를 계산하며, 도달 불가능한 노드는 -1로 둔다.
    // Input: int n (노드 개수), List<Integer>[] graph (그래프의 인접 리스트), int start (시작 노드)
    // Output: int[] dist (길이 n 배열, dist[i]는 start로부터 i 노드까지의 거리, 도달 불가 시 -1)
    static int[] bfsList(int n, List<Integer>[] graph, int start) {
        // TODO: dist 배열을 모두 -1로 초기화하고, 시작 노드는 0으로 설정. Queue를 이용해 BFS 수행.
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        // 시작 노드 초기화
        dist[start] = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        // BFS 탐색
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            // 인접 노드들 확인
            for (int next : graph[cur]) {
                if (dist[next] == -1) {           // 처음 방문하는 경우
                    dist[next] = dist[cur] + 1;
                    dq.add(next);
                }
            }
        }
        return dist;
    }

    // Problem: BFS on Grid (오리지널 미로 탐색 등에서의 4방향 BFS)
    // Description: 2차원 격자 보드에서 시작 지점 (sr, sc)부터 BFS를 수행하여 각 위치까지의 이동 거리를 계산한다.
    //              격자에서 상하좌우 인접 이동을 가정하며, 이동 불가능한 위치는 방문되지 않는다.
    // Input: char[][] board (격자 보드, 예: 벽은 '#' 등으로 표시 가능), int sr, int sc (시작 행, 열 인덱스)
    // Output: int[][] dist (board와 같은 크기의 2차원 배열, dist[i][j]는 (sr,sc)부터 (i,j)까지의 최단거리, 도달 불가시 -1)
    static int[][] bfsGrid(char[][] board, int sr, int sc) {
        int r = board.length;
        int c = board[0].length;
        int[][] dist = new int[r][c];
        // 거리 배열을 -1로 초기화
        for (int i = 0; i < r; i++) {
            Arrays.fill(dist[i], -1);
        }
        // BFS 초기 설정
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{ sr, sc });
        dist[sr][sc] = 0;
        // BFS 탐색 시작
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curR = cur[0], curC = cur[1];
            // 4방향 이웃 확인
            for (int d = 0; d < 4; d++) {
                int nR = curR + dr[d];
                int nC = curC + dc[d];
                // 범위를 벗어나면 무시
                if (nR < 0 || nR >= r || nC < 0 || nC >= c) continue;
                // 벽이 있는 경우나 이미 방문한 경우 무시 (예: board[nR][nC] == '#'으로 벽 체크 가능)
                if (dist[nR][nC] != -1) continue;
                // 이동 가능하면 거리 기록 및 큐에 추가
                dist[nR][nC] = dist[curR][curC] + 1;
                dq.add(new int[]{ nR, nC });
            }
        }
        return dist;
    }

    // Problem: Tree DFS – Subtree Size Calculation
    // Description: 트리에서 DFS를 이용하여 각 노드의 서브트리 크기(자신을 루트로 하는 부분 트리에 속한 노드 개수)를 계산한다.
    // Input: int cur (현재 노드), int parent (부모 노드), List<Integer>[] tree (트리의 인접 리스트, 무방향 그래프), 
    //        int[] subtreeSize (서브트리 크기를 저장할 배열)
    // Output: int (cur 노드를 루트로 하는 서브트리의 노드 개수 반환; 결과는 subtreeSize[cur]에도 저장)
    static int dfsSubtreeSize(int cur, int parent, List<Integer>[] tree, int[] subtreeSize) {
        // 현재 노드의 크기를 1로 (자기 자신)
        int size = 1;
        // 자식 노드들 탐색
        for (int nxt : tree[cur]) {
            if (nxt == parent) continue;        // 부모 노드로 돌아가는 길은 제외
            size += dfsSubtreeSize(nxt, cur, tree, subtreeSize);
        }
        subtreeSize[cur] = size;
        return size;
    }


    /*
     * ===========================
     * 3. MST (최소 신장 트리) & Union-Find (Disjoint Set Union)
     * ===========================
     */

    // Problem: Prim's Algorithm for MST
    // Description: 주어진 가중치 무방향 그래프에서 Prim 알고리즘을 사용하여 최소 신장 트리(MST)의 총 가중치를 계산한다.
    //              그래프가 연결되지 않은 경우 MST를 만들 수 없으므로 특별한 값을 반환한다 (예: -1).
    // Input: int n (정점 개수, 노드 0 ~ n-1), List<int[]>[] graph (인접 리스트 그래프, graph[u]는 {v, w} 형태의 간선 리스트),
    //        int start (시작 정점 번호, MST에서 임의의 한 정점)
    // Output: long totalWeight (MST에 포함된 간선 가중치의 총합, 불가능하면 -1)
    static long primMST(int n, int start, List<int[]>[] graph) {
        // TODO: 방문 배열(visited) 초기화, 우선순위 큐(PQ)에 시작점 추가 후 알고리즘 수행.
        //       PQ에서는 (간선 가중치, 노드) 형태로 저장하여 최소 가중치 간선을 우선 선택.
        //       MST에 n개의 노드 모두 포함되면 종료, 아니면 -1 반환.
        return 0L;
    }

    // Problem: Kruskal's Algorithm for MST
    // Description: 모든 간선을 가중치 오름차순으로 정렬한 뒤, Union-Find 자료구조를 사용하여 사이클을 만들지 않는 간선들을 선택해 MST의 총 가중치를 계산한다.
    // Input: int n (정점 개수), int[][] edges (간선 리스트, 각 원소는 {u, v, w}로 u-v 간의 가중치 w 무방향 간선을 나타냄)
    // Output: long totalWeight (MST 간선들의 총 가중치, 연결 불가 시 -1)
    static long kruskalMST(int n, int[][] edges) {
        // TODO: 간선 리스트를 가중치 기준으로 정렬한 후, Union-Find로 사이클 확인하며 n-1개의 간선 선택
        //       사용한 간선 수가 n-1보다 적으면 MST 불가 (-1 리턴)
        return 0L;
    }

    // Problem: Union-Find - Find Operation
    // Description: Union-Find 자료구조에서 find 연산은 노드 x가 속한 집합의 대표(root)를 찾는다.
    //              경로 압축 기법을 적용하여 find 결과를 부모에 바로 저장해 이후 연산을 최적화한다.
    // Input: int x (찾고자 하는 노드), int[] parent (parent[i]는 노드 i의 부모 노드 배열)
    // Output: int root (x가 속한 집합의 대표 노드 번호)
    static int find(int x, int[] parent) {
        // 경로 압축 기법을 통한 find 구현
        if (parent[x] == x) return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    // Problem: Union-Find - Union Operation
    // Description: Union-Find 자료구조에서 union 연산은 두 노드 a, b를 같은 집합으로 합친다.
    //              (보통 rank나 크기를 고려한 union-by-rank 최적화는 필요시 적용)
    // Input: int a, int b (합치려는 두 노드), int[] parent (Union-Find의 부모 노드 배열)
    // Output: (반환값 없음; parent 배열을 직접 수정하여 집합을 합침)
    static void union(int a, int b, int[] parent) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);
        if (rootA == rootB) return;
        // 간단히 작은 번호를 부모로 삼는 방식 (또는 rank 기준으로 합칠 수 있음)
        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }


    /*
     * ===========================
     * 4. 최단 경로 알고리즘 (Shortest Path Algorithms)
     * ===========================
     */

    // Problem: Bellman-Ford Algorithm (Single Source Shortest Path with Possible Negative Weights)
    // Description: 시작 정점에서 출발하여 그래프의 모든 다른 정점까지의 최단거리를 계산한다. 음수 가중치 간선이 있어도 동작하며,
    //              총 n-1번 간선 완화를 수행한다. 추가로 한 번 더 반복하여 여전히 거리가 줄어들면 음수 사이클이 존재함을 감지할 수 있다.
    // Input: int n (정점 개수), int[][] edges (간선 리스트, 각 원소 {u, v, w} 는 u->v 가중치 w인 방향 간선), int start (출발 정점)
    // Output: long[] dist (길이 n 배열, dist[i]는 start부터 i까지의 최단 거리값; 음수 사이클 영향으로 값이 감소할 경우 별도 표시가 필요할 수 있음)
    static long[] bellmanFord(int n, int[][] edges, int start) {
        // TODO: dist 배열을 INF로 초기화, dist[start] = 0 설정.
        //       n-1번 모든 간선 완화 수행 후, 추가 1회 반복하여 음수 사이클 체크.
        return null;
    }

    // Problem: Floyd-Warshall Algorithm (All-Pairs Shortest Path)
    // Description: 모든 정점 쌍 간의 최단거리를 구하는 알고리즘. 동적계획법으로 각 중간 정점을 거쳐가는 경로를 고려한다.
    //              시간복잡도는 O(n^3)으로, 대략 n<=200 정도의 입력에서 사용 가능하다.
    // Input: int n (정점 개수), long[][] dist (초기 인접 행렬 형태의 거리 배열; 직간접 경로가 없으면 매우 큰 값 또는 INF 표기, 자기 자신은 0)
    // Output: (반환값 없음; 입력으로 받은 dist 2D 배열을 직접 최단 거리로 갱신한다)
    static void floydWarshall(int n, long[][] dist) {
        // TODO: 3중 루프를 통해 모든 쌍 (i, j)에 대해 모든 중간 노드 k를 거치는 경로 검사 및 최단거리 갱신
    }

    // Problem: Dijkstra's Algorithm (Single Source Shortest Path with Non-negative Weights)
    // Description: 가중치가 양수인 그래프에서 단일 시작점으로부터 다른 모든 정점까지의 최단거리를 계산한다.
    //              우선순위 큐(최소 힙)를 사용하여 구현하며 시간복잡도는 O(E log V)이다.
    // Input: int n (정점 개수), List<int[]>[] graph (인접 리스트 그래프, graph[u]는 {v, w} 형태의 간선 리스트, 가중치 w는 비음수),
    //        int start (시작 정점)
    // Output: int[] dist (길이 n 배열, dist[i]는 start부터 i까지의 최단거리 값; 도달 불가 시 INF 등의 큰 값으로 표현)
    static int[] dijkstra(int n, List<int[]>[] graph, int start) {
        // TODO: dist 배열을 충분히 큰 값으로 초기화하고, dist[start] = 0.
        //       최소 힙(PQ)에 (0, start) 넣고, 기존 거리보다 더 좋은 경로 발견 시 갱신 (relaxation).
        return null;
    }

    // Problem: Topological Sort (Kahn's Algorithm)
    // Description: 방향 그래프(DAG)에 대해 위상 정렬 순서를 구한다. 사이클이 없는 경우 모든 노드를 나열한 순서를 반환한다.
    //              진입차수(indegree)를 활용한 Kahn 알고리즘 또는 DFS를 이용한 방법 등이 있다. 
    // Input: int n (노드 개수), List<Integer>[] graph (방향 그래프의 인접 리스트), int[] indegree (각 노드의 초기 진입차수 배열)
    // Output: List<Integer> topoOrder (위상 정렬된 노드 순서 리스트, 그래프에 사이클이 있으면 노드 수보다 작은 리스트 반환 가능)
    static List<Integer> topoSort(int n, List<Integer>[] graph, int[] indegree) {
        // TODO: indegree가 0인 노드들을 큐에 넣고 BFS 진행하듯이 처리. 큐에서 꺼낸 노드는 결과 리스트에 추가하고, 해당 노드가 나가는 간선들 따라가며 indegree 감소.
        return null;
    }


    /*
     * ===========================
     * 5. 백트래킹 (조합, 순열, 부분집합 생성)
     * ===========================
     */

    // Problem: Combination (n choose k)
    // Description: 주어진 배열의 원소들 중에서 k개를 뽑는 모든 조합을 구한다.
    //              백트래킹을 사용하여 모든 조합을 생성하며, 결과는 중첩 리스트로 반환된다.
    // Input: int[] arr (원소를 담은 배열), int k (뽑을 개수), 
    //        int start (현재 탐색 시작 인덱스, 초기 호출 시 0), 
    //        List<Integer> current (현재 조합에 포함된 원소 리스트), List<List<Integer>> result (모든 조합 결과 리스트)
    // Output: (반환값 없음; 모든 가능한 조합 리스트를 result에 추가)
    static void combine(int[] arr, int k, int start, List<Integer> current, List<List<Integer>> result) {
        // 조합 완성 조건: current 리스트의 크기가 k이면 결과 리스트에 추가
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        // start부터 배열 끝까지 조합 생성
        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            // 다음 재귀 호출에서는 다음 인덱스부터 선택
            combine(arr, k, i + 1, current, result);
            current.remove(current.size() - 1);  // 백트래킹 (직전에 넣은 원소 제거)
        }
    }

    // Problem: Permutation (모든 순열 생성)
    // Description: 주어진 배열의 모든 원소를 나열하는 모든 순열을 구한다. (배열 내 중복 원소가 없다고 가정)
    //              백트래킹을 사용하여 순열을 생성하며, 각 순열은 새로운 리스트로 결과에 추가된다.
    // Input: int[] arr, boolean[] used (각 원소 사용 여부 추적 배열, 초기에는 전부 false), 
    //        List<Integer> current (현재 순열 경로), List<List<Integer>> result (모든 순열 결과 리스트)
    // Output: (반환값 없음; 가능한 모든 순열을 result 리스트에 추가)
    static void permute(int[] arr, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // 모든 원소를 다 사용한 경우 하나의 순열 완성
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // 모든 위치에 대해 시도
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;             // 이미 사용한 원소는 건너뛰기
            used[i] = true;
            current.add(arr[i]);
            permute(arr, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;                   // 백트래킹: 선택 복원
        }
    }

    // Problem: Power Set (부분집합 생성)
    // Description: 주어진 배열의 모든 부분집합을 생성한다. (공집합부터 모든 원소를 포함하는 집합까지)
    //              재귀를 이용하여 각 원소를 선택하거나 선택하지 않는 방식으로 부분집합을 구성한다.
    // Input: int[] arr, int index (현재 처리 인덱스, 초기 호출 시 0),
    //        List<Integer> current (현재 부분집합 구성), List<List<Integer>> result (모든 부분집합 결과 리스트)
    // Output: (반환값 없음; 가능한 모든 부분집합을 result 리스트에 추가)
    static void subsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        // 모든 원소를 검사한 경우 current 부분집합을 결과에 추가
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // 현재 원소를 선택하지 않는 경우
        subsets(arr, index + 1, current, result);
        // 현재 원소를 선택하는 경우
        current.add(arr[index]);
        subsets(arr, index + 1, current, result);
        current.remove(current.size() - 1);  // 백트래킹: 선택 복원
    }


    /*
     * ===========================
     * 6. 동적계획법 패턴 (DP: 1차원, 2차원, 비트마스크)
     * ===========================
     */

    // Problem: 1D DP Example (일차원 DP 기본형)
    // Description: 1차원 배열을 이용한 DP의 기본 패턴 예시 함수. 
    //              (예를 들어, 최대 부분합 계산이나 특정 조건의 경우의 수 계산 등에서 dp[i] = dp[i-1] +/- something 형태로 사용)
    // Input: int[] arr (입력 배열, 길이 n)
    // Output: int result (DP 계산 결과 값, 예시로 dp[n-1] 등의 값)
    static int dp1D(int[] arr) {
        // TODO: dp 배열 생성 및 초기값 설정 후, i=1..n-1 에 대해 점화식을 적용하여 채움.
        return 0;
    }

    // Problem: 2D DP Example (이차원 DP 기본형)
    // Description: 2차원 표(dp 테이블)를 사용하는 DP의 기본 패턴 예시 함수.
    //              (예: 격자에서 (0,0) -> (r-1,c-1)로 이동하는 최대/최소 경로 값 계산 등에서 사용)
    // Input: int[][] board (입력 격자 또는 DP에 참고할 2차원 배열, 크기 r x c)
    // Output: int result (DP 계산 결과 값, 예시로 dp[r-1][c-1] 등)
    static int dp2D(int[][] board) {
        // TODO: dp 테이블 생성 및 초기화 후, 2중 루프로 dp 값을 채워나감.
        return 0;
    }

    // Problem: Bitmask DP Example (부분집합 상태 DP)
    // Description: 비트마스크를 상태로 사용하는 DP의 예시. (예: Traveling Salesman Problem(TSP) - 모든 노드를 방문하는 최소 비용 경로 문제 등)
    //              상태를 비트mask로 나타내고, dp[mask][i]를 "현재 방문 집합이 mask이고, 현재 위치가 i일 때의 최단 경로" 등으로 정의하여 사용.
    // Input: int n (전체 원소 개수, 예: 도시 개수 <= 20 정도), int[][] cost (예: 비용 행렬 혹은 인접 행렬)
    // Output: int result (DP 계산 결과값, 예: 모든 도시를 방문하는 최소 비용 등)
    static int bitmaskDP(int n, int[][] cost) {
        // TODO: dp[mask][i] 등의 테이블 정의 후, mask를 0부터 2^n - 1까지 순회하며 상태 전이 수행.
        return 0;
    }


    /*
     * ===========================
     * 7. 수학 / 비트 / 이분 탐색 관련 유틸
     * ===========================
     */

    // Problem: Greatest Common Divisor (최대공약수)
    // Description: 주어진 두 정수 a, b의 최대공약수(GCD)를 유클리드 호제법(Euclidean Algorithm)을 사용하여 계산한다.
    // Input: int a, int b
    // Output: int gcd (a와 b의 최대공약수)
    static int gcd(int a, int b) {
        // TODO: 유클리드 호제법 반복 또는 재귀 구현 (b가 0이 될 때까지)
        return 0;
    }

    // Problem: Least Common Multiple (최소공배수)
    // Description: 주어진 두 정수 a, b의 최소공배수(LCM)를 계산한다. (공식: LCM(a,b) = a / GCD(a,b) * b)
    // Input: int a, int b
    // Output: int lcm (a와 b의 최소공배수)
    static int lcm(int a, int b) {
        // TODO: gcd 함수를 사용하여 LCM 계산
        return 0;
    }

    // Problem: Fast Exponentiation (빠른 거듭제곱)
    // Description: 거듭제곱을 분할 정복으로 빠르게 계산하는 알고리즘. O(log exp) 시간에 base^exp 값을 계산한다.
    // Input: long base (밑), long exp (지수, 0 이상의 정수 값)
    // Output: long result (base^exp의 계산 결과)
    static long fastPow(long base, long exp) {
        // TODO: exp를 이진수로 분해하여 거듭제곱을 효율적으로 계산 (반복문이나 재귀 이용)
        return 0L;
    }

    // Problem: Convert to Binary String (10진수 -> 2진수 문자열)
    // Description: 10진수 정수값을 2진법으로 변환하여 그 결과를 문자열로 반환한다.
    //              (예: x=5 -> "101")
    // Input: int x (10진 정수 값)
    // Output: String binStr (x를 2진법으로 표현한 문자열)
    static String toBinaryString(int x) {
        // TODO: x가 0인 경우 "0", 아닐 경우 2로 나눈 나머지를 모아서 변환 (혹은 Integer.toBinaryString 사용 가능)
        return null;
    }

    // Problem: Convert to Base-K String (10진수 -> K진수 문자열)
    // Description: 10진수 숫자 x를 주어진 기반(base) k로 변환하여 문자열로 반환한다.
    //              10~35에 해당하는 값은 'A'~'Z'로 표시 (예: x=31, k=16 -> "1F")
    // Input: long x (10진 정수 값, 변환할 값), int k (진법, 2 이상 36 이하)
    // Output: String baseKStr (x를 k진법으로 표현한 문자열)
    static String toBaseKString(long x, int k) {
        // TODO: x를 k로 나눈 나머지를 이용하여 진법 변환. 10 이상 나머지는 'A'+(나머지-10) 문자 사용.
        return null;
    }

    // Problem: Iterate Submasks of a Mask (부분 비트마스크 순회)
    // Description: 주어진 비트마스크 mask의 모든 부분집합(submask)을 반복 처리한다.
    //              이때 0부터 mask까지의 모든 부분집합을 생성하는 것보다 효율적으로, sub = mask로 시작하여 sub = (sub-1) & mask 방식으로 순회한다.
    // Input: int mask
    // Output: (반환값 없음; 함수 내부에서 각 submask에 대한 필요한 처리를 수행하거나 출력 가능)
    static void iterateSubmasks(int mask) {
        // submask 순회 예시
        for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
            // TODO: sub는 mask의 부분집합을 나타냄. 이곳에서 sub에 대한 처리 수행.
        }
        // (필요시 공집합(0) 처리 별도)
    }

    // Problem: Binary Search in Sorted Array (이분 탐색)
    // Description: 오름차순으로 정렬된 배열에서 목표 값 target의 인덱스를 찾는다. 
    //              만약 존재하지 않으면 -1을 반환한다. (동일한 값이 여러 개 있으면 그중 하나의 인덱스를 반환)
    // Input: int[] arr (오름차순 정렬된 정수 배열), int target (찾고자 하는 값)
    // Output: int index (target 값의 인덱스, 없으면 -1)
    static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    // Problem: Parametric Search (답에 대한 이분 탐색)
    // Description: 결정 문제 형태의 조건 함수 check(mid)를 이용해, 원하는 값을 이분 탐색으로 찾는다.
    //              예를 들어, 어떤 조건을 만족하는 최소의 값 또는 최대의 값을 찾을 때 사용한다.
    // Input: int lo (탐색 범위 최소값), int hi (탐색 범위 최대값) 
    //        [참고: check(int mid) 형태의 별도 함수가 존재한다고 가정하고 사용]
    // Output: int result (주어진 조건을 만족하는 최소 또는 최대의 값)
    static int binarySearchOnAnswer(int lo, int hi) {
        // TODO: mid를 계산하고 조건 check(mid)에 따라 lo/hi 좁혀나감. 원하는 값 리턴.
        return 0;
    }


    /*
     * ===========================
     * 8. 투 포인터 / 슬라이딩 윈도우
     * ===========================
     */

    // Problem: Two Pointers (Find Pair with Target Sum in Sorted Array)
    // Description: 정렬된 배열에서 두 수의 합으로 target을 만들 수 있는 서로 다른 두 원소의 쌍을 찾는다.
    //              모든 가능한 쌍의 개수를 반환하거나, 존재 여부를 확인할 수 있다. (여기서는 쌍의 총 개수를 반환한다고 가정)
    // Input: int[] arr (오름차순 정렬된 정수 배열), int target
    // Output: int count (합이 target이 되는 서로 다른 두 원소 쌍의 개수)
    static int twoPointerSorted(int[] arr, int target) {
        int count = 0;
        int left = 0, right = arr.length - 1;
        // 투 포인터 이동을 통해 합 검사
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                count++;
                // 조건에 따라, 중복되는 값이 있을 경우 처리 (예: 동일한 값 여러 개 있을 시)
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    // Problem: Sliding Window (Minimum Subarray Length with Sum >= S)
    // Description: 양의 정수로 이루어진 배열에서 부분합이 주어진 목표값 이상이 되는 부분배열(subarray)의 최소 길이를 구한다.
    //              투 포인터 (슬라이딩 윈도우) 기법을 사용하여 O(n)에 해결한다.
    // Input: int[] arr (양의 정수 배열), int S (목표 부분합 값)
    // Output: int minLength (합 >= S를 만족하는 최소 연속 부분배열 길이, 없으면 0)
    static int minLengthSubarraySumAtLeast(int[] arr, int S) {
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        // end를 이동하며 윈도우 확장
        for (int end = 0; end < n; end++) {
            sum += arr[end];
            // 현재 윈도우의 합이 S 이상이면, 가능한 한 윈도우를 좁혀서 최소 길이 갱신
            while (sum >= S) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start++];
            }
        }
        // 만족하는 부분배열이 없으면 0 반환
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }

}
