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
                //this has been included in the sum
                int num=nums[i]+val;
                if(num%2==0){
                    sum+=val;
                    
                }else{
                    sum-=nums[i];
                    
                }
            }else{
                int num=nums[i]+val;
                if(num%2==0){
                    sum+=num;
                }
            }
            nums[i]+=val;
            res[idx++]=sum;
        }
        return res;
    }
}