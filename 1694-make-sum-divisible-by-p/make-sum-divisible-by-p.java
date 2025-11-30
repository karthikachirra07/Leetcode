import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        
        long need = total % p;
        if (need == 0) return 0;

        long prefix = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);  // prefix mod at index -1

        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;

            long target = (prefix - need + p) % p;

            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }

            map.put(prefix, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}
  
    
