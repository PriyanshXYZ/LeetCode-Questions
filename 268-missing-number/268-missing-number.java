class Solution {
    //tc O(n)
    public int missingNumber(int[] nums) {
        int sum=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=i;
            sum-=nums[i];
        }
        return sum;
        
    }
    // O(nlogn)
    public int solve(int[] nums){
        Arrays.sort(nums);
        int missing=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                missing=i;
                break;
            }
        }
        if(missing==-1)return nums.length;
        return missing;
    }
}