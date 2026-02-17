class Solution {
    public int maximumCount(int[] nums) {
        int poscount=0;
        int negcount=0;
        for(int num:nums){
            if(num>0){
                poscount++;
            }else if(num<0){
                negcount++;
            }
        }
        return Math.max(poscount,negcount);
    }
}