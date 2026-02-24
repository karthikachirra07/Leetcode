class Solution {
    public int maxProduct(int[] nums) {
       int res=nums[0];
       int mx=nums[0];
       int mn=nums[0];
       int t=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                t=mn;
                 mn=mx;
                 mx=t;
            }
                 mx=Math.max(nums[i],mx*nums[i]);
                mn=Math.min(nums[i],mn*nums[i]);
                res=Math.max(res,mx);
        }
        return res;
    }
}