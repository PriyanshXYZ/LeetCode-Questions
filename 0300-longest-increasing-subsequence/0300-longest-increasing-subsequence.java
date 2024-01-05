class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] tails=new int[n];
        tails[0]=nums[0];
        int len=1;
        
        for(int i=1;i<n;i++){
            if(nums[i]>tails[len-1]){
                len++;
                tails[len-1]=nums[i];
            }else{
                int idx=Arrays.binarySearch(tails,0,len-1,nums[i]);
                
                if(idx<0){
                    idx=-idx;
                    idx=idx-1;
                }
                tails[idx]=nums[i];
            }
        }
        return len;
    }
}
class Solution1 {
    //o(n^2)
    public int lengthOfLIS(int[] nums) {
        int lis=0;
        
        int n=nums.length;
        int[] dp=new int[n];
        
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            
            lis=Math.max(lis,dp[i]);
        }
        return lis;
    }
}