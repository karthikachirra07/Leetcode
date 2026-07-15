class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1=0,c2=0;
        int e1=Integer.MIN_VALUE;
        int e2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(c1==0&&nums[i]!=e2){
                c1=1;
                e1=nums[i];
            }
            else if(c2==0&&nums[i]!=e1){
                c2=1;
                e2=nums[i];
            }
            else if(e1==nums[i]) c1++;
            else if(e2==nums[i]) c2++;
            else{
                c1--;
                c2--;
            }
        }
        List<Integer> list=new ArrayList<>();
        c1=0;c2=0;
        c1=0;
        c2=0;
        for(int num:nums){
            if(num==e1){
                c1++;
            }
            else if(num==e2){
                c2++;
            }
        }
        int min=nums.length/3+1;
        if(c1>=min){
            list.add(e1);
        }
        if(c2>=min){
            list.add(e2);
        }
        Collections.sort(list);
        return list;
    }
}