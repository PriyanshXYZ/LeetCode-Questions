class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }
    public int atMostK(int[] nums,int k){
        
        
        int si=0,ei=0,niceSubArr=0;
        int odd=0;
        for(;ei<nums.length;ei++){
            
            odd+=nums[ei]%2;
            while(odd==k+1){
        
                odd-=nums[si] % 2;
                
        
                si++;
            }
            niceSubArr+=ei-si+1;
        }
        return niceSubArr;
    }
}