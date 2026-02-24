class Solution {
    public int maxProfit(int[] prices) {
        int mx=0;
        int mn=prices[0];
        for(int i=1;i<prices.length;i++){
            mx=Math.max(mx,prices[i]-mn);
            mn=Math.min(mn,prices[i]);
        }
        return mx;
    }
}