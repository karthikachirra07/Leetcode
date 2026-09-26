class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
       if(n==0) return 0;
       if(n<2) return nums[0];
       int []skip_last=new int[n-1]; 
       int []skip_first=new int[n-1];
       for(int i=0;i<n-1;i++){
       skip_last[i]=nums[i];
       skip_first[i]=nums[i+1];
       }
      int loot_skip_last=robhelper(skip_last,n-1);
      int loot_skip_first=robhelper(skip_first,n-1);
      return Math.max(loot_skip_last,loot_skip_first);
    }
    public int robhelper(int[] house,int n) {
       if(n==0) return 0;
       if(n==1)
       return house[0];
       int [] dp=new int[n];
       dp[0]=house[0];
       dp[1]=Math.max(house[0],house[1]);
       for(int i=2;i<n;i++){
        dp[i]=Math.max(dp[i-1],house[i]+dp[i-2]);
       } 
       return dp[n-1];
    }
}