class Solution {
    public int smallestRepunitDivByK(int k) {
        // If k is divisible by 2 or 5, no repunit can be divisible by k
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int remainder = 0;

        // Try up to k iterations (Pigeonhole principle)
        for (int length = 1; length <= k; length++) {
            remainder = (remainder * 10 + 1) % k;

            if (remainder == 0) {
                return length;  // Found the smallest repunit divisible by k
            }
        }

        return -1;  // No solution (won't happen except above)
    }
}

    
