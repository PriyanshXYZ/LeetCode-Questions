class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        // return recursion(0,nums.length-1,nums);
        // return memoization(0,nums.length-1,nums,dp);
        int n=nums.length-1;
        //tabulation
        for(int idx=n;idx>=0;idx--){
            if(idx==n){
                dp[idx]=0;
                continue;
            } 
            
            int ans=Integer.MAX_VALUE;
            for(int jumps=1; jumps <= nums[idx] ;jumps++){
                if(idx+jumps<=n)
                    ans=Math.min(dp[idx+jumps],ans);
            }
            if(ans!=Integer.MAX_VALUE){
                ans+=1;
            }
            dp[idx]=ans;    
        }
        return dp[0];
    }
    public int recursion(int idx,int n,int[] nums){
        if(idx==n)return 0;
        
        int ans=Integer.MAX_VALUE;
        for(int jumps=1; jumps <= nums[idx] ;jumps++){
            if(idx+jumps<=n)
                ans=Math.min(recursion(idx+jumps,n,nums),ans);
        }
        if(ans!=Integer.MAX_VALUE){
            return ans+1;
        }
        return ans;
    }
    
    public int memoization(int idx,int n,int[] nums,int[] dp){
        if(idx==n)return dp[idx]=0;
        
        if(dp[idx]!=0)return dp[idx];
        int ans=Integer.MAX_VALUE;
        for(int jumps=1; jumps <= nums[idx] ;jumps++){
            if(idx+jumps<=n)
                ans=Math.min(memoization(idx+jumps,n,nums,dp),ans);
        }
        if(ans!=Integer.MAX_VALUE){
            ans+=1;
        }
        return dp[idx]=ans;
    }
}