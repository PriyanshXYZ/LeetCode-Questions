class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int idx = n-1;
        int i = 0 , j = n-1 ;
        while(idx>=0){
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                res[idx] = nums[i]*nums[i];
                i++;
            }else{
                res[idx] = nums[j]*nums[j];    
                j--;
            }
            idx--;
        }
        return res;
    }
}