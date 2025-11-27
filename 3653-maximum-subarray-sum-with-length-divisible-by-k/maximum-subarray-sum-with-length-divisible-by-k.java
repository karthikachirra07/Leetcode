class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] minPrefix = new long[k];
        boolean[] seen = new boolean[k];

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        // prefix[0] = 0 at index 0 (index 0 mod k == 0)
        minPrefix[0] = 0;
        seen[0] = true;

        int idx = 1;  // prefix index starts from 1

        for (int x : nums) {
            prefix += x;

            int r = idx % k;  // CORRECT remainder based on index, not prefix sum

            if (seen[r]) {
                ans = Math.max(ans, prefix - minPrefix[r]);
                minPrefix[r] = Math.min(minPrefix[r], prefix);
            } else {
                seen[r] = true;
                minPrefix[r] = prefix;
            }

            idx++;
        }

        return ans;
    }
}
