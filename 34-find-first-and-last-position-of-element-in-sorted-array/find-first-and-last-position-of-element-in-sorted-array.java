class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int f=-1;
        int l=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==target)
            {
                f=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]==target){
                l=i;
                break;
            }
        }
        return new int[]{f,l};
    }
}