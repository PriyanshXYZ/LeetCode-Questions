class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        //greedy = approach is to go as farthest we can go from current point , which automatically lead us to shortest jump path
        int minJumps = 0, currIdx = 0, idxAfterJump = 0;
        

        for(int i = 0; i < n - 1; i++) {
            idxAfterJump = Math.max(idxAfterJump, i + nums[i]);
            if(i == currIdx) {
                minJumps++;
                currIdx = idxAfterJump;

                if(idxAfterJump >= n -1)break;
            }
        }
        return minJumps;
    }
    private int tabulation(int[] nums ){
        int[] dp=new int[nums.length];
        int n=nums.length-1;
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