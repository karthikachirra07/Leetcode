import java.util.*;

class Solution {

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        // Build adjacency list
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] result = new int[1];  // store component count

        dfs(0, -1, graph, values, k, result);
        return result[0];
    }

    private long dfs(int u, int parent, List<Integer>[] graph, int[] values, int k, int[] result) {

        long sum = values[u];   // MUST be long, avoids overflow

        for (int v : graph[u]) {
            if (v == parent) continue;
            sum += dfs(v, u, graph, values, k, result);
        }

        // If this subtree is divisible by k, cut here
        if (sum % k == 0) {
            result[0]++;
            return 0;  // pass 0 upward since component is separated
        }

        return sum;
    }

    // Main for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 7;
        int[][] edges = {
            {0,1},{0,2},{1,3},{1,4},{2,5},{2,6}
        };
        int[] values = {
            1000000000,1000000000,1000000000,
            1000000000,1000000000,1000000000,1000000000
        };
        int k = 7;

        System.out.println(sol.maxKDivisibleComponents(n, edges, values, k));
    }
}
