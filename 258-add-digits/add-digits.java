class Solution {
    public int addDigits(int num) {
        int sum=0;
        if(num==0)
            return 0;
        return 1+(num-1)%9;
    }
}