class Solution {
    static final long MOD = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        java.util.HashMap<Integer, Long> map = new java.util.HashMap<>();

        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0L) + 1);
        }

        long sum = 0;
        long sumSq = 0;

        for (long c : map.values()) {
            if (c < 2) continue;
            long comb = (c * (c - 1) / 2) % MOD;

            sum = (sum + comb) % MOD;
            sumSq = (sumSq + (comb * comb) % MOD) % MOD;
        }

        long total = (sum * sum) % MOD;
        total = (total - sumSq + MOD) % MOD;
        total = (total * ((MOD + 1) / 2)) % MOD; 

        return (int) total;
    }
}
