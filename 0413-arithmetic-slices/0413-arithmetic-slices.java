class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int sum=0,curr=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                curr+=1;
                
                sum+=curr;
            }else{
                curr=0;
            }
        }
        
        return sum;
    }
}
class Solution1 {
    //O(n^2)
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