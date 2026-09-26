class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int s=0;
        int dp[]=new int[n];
        for(int x:nums){
        int i=0,j=s;
                while(i!=j){
                    int m=(i+j)/2;
                    if(dp[m]<x)
                    i=m+1;
                    else j=m;
                }
                dp[i]=x;
                if(i==s)++s;
            }
        return s;
    }
}