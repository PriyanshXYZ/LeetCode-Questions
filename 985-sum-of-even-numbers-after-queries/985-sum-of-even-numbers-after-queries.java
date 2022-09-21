class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        //Priyansh Ragit is best
        int[] res=new int[queries.length];
        int sum=0;
        for(int val:nums){
            if(val%2==0)sum+=val;
        }
        int idx=0;
        for(int[] query:queries){
            int val=query[0];
            int i=query[1];
            if(nums[i]%2==0){
                sum-=nums[i];
            }
            nums[i]+=val;
            if(nums[i]%2==0){
                sum+=nums[i];
            }
            res[idx++]=sum;
        }
        return res;
    }
}