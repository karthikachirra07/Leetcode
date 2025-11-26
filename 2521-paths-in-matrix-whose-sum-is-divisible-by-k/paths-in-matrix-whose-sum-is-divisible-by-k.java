class Solution {
    static final int MOD = 1_000_000_007;
    
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[i][j][r] = number of ways to reach (i, j) with sum % k = r
        int[][][] dp = new int[m][n][k];

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = grid[i][j] % k;

                // From top
                if (i > 0) {
                    for (int r = 0; r < k; r++) {
                        int newR = (r + val) % k;
                        dp[i][j][newR] = (dp[i][j][newR] + dp[i-1][j][r]) % MOD;
                    }
                }

                // From left
                if (j > 0) {
                    for (int r = 0; r < k; r++) {
                        int newR = (r + val) % k;
                        dp[i][j][newR] = (dp[i][j][newR] + dp[i][j-1][r]) % MOD;
                    }
                }
            }
        }

        return dp[m-1][n-1][0];
    }
}
 
    
