class Solution {
    public int maxProduct(int[] nums) {
        int x = 0;
        int y = 0;
        for(int num : nums){
            if(x<num){
                y = x;
                x = num;
            }else{
                y = Math.max(y,num);
            }
        }
        return (x-1)*(y-1);
    }
}