class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        // store smallest elements of each remainder group
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int sec1 = Integer.MAX_VALUE, sec2 = Integer.MAX_VALUE;

        for (int x : nums) {
            sum += x;

            if (x % 3 == 1) {
                if (x < min1) {
                    sec1 = min1;
                    min1 = x;
                } else if (x < sec1) {
                    sec1 = x;
                }
            } 
            else if (x % 3 == 2) {
                if (x < min2) {
                    sec2 = min2;
                    min2 = x;
                } else if (x < sec2) {
                    sec2 = x;
                }
            }
        }

        int r = sum % 3;

        if (r == 0) return sum;

        int ans = 0;

        if (r == 1) {
            int option1 = (min1 == Integer.MAX_VALUE) ? Integer.MIN_VALUE : sum - min1;
            int option2 = (min2 == Integer.MAX_VALUE || sec2 == Integer.MAX_VALUE) 
                          ? Integer.MIN_VALUE : sum - (min2 + sec2);
            ans = Math.max(option1, option2);
        } else { // r == 2
            int option1 = (min2 == Integer.MAX_VALUE) ? Integer.MIN_VALUE : sum - min2;
            int option2 = (min1 == Integer.MAX_VALUE || sec1 == Integer.MAX_VALUE) 
                          ? Integer.MIN_VALUE : sum - (min1 + sec1);
            ans = Math.max(option1, option2);
        }

        return ans < 0 ? 0 : ans;
    }
}

    
