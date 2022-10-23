class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] res=new int[2];
        int num=-1;
        int missing=1;
        for(int i=1;i<n;i++){
           if(nums[i]==nums[i-1]){
               num=nums[i];
           }else if(nums[i]>nums[i-1]+1){
               missing=nums[i-1]+1;
           }
        }
        res[0]=num;
        res[1]=nums[n-1]!=n?n:missing;
        return res;
    }
}