class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int sum=0;
        for(int i=1;i<nums.length;i++){
            int count=0;
            int diff=nums[i]-nums[i-1];
            for(int j=i+1;j<nums.length;j++){
                int currDiff=nums[j]-nums[j-1];
                if(currDiff==diff){
                    count++;
                }else{
                    break;
                }
            }
            sum+=count;
        }
        return sum;
    }
}