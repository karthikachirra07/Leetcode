class Solution {
    public boolean isHappy(int n) {
        int s = n;
        int f = n; 

        do {
            s = sqr(s);         
            f = sqr(sqr(f));     
        } while (s != f);

        return s == 1; // if cycle ends at 1, it's happy
    }

    public static int sqr(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        return ans;
    }
}
