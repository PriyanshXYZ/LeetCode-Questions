class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length==0 || d>jobDifficulty.length)return -1;
        Integer[][] dp=new Integer[jobDifficulty.length][d+1];
        // return recursion(0,d,jobDifficulty);
        return memo(0,d,jobDifficulty,dp);
    }
    public int memo(int idx,int d,int[] jd,Integer[][] dp){
        int n=jd.length;
        if(idx==n && d==0)return 0;
        if(idx==n || d==0)return inf;
        
        if(dp[idx][d]!=null)return dp[idx][d];
        
        int currMax=jd[idx];
        int min=inf;
        
        for(int i=idx;i<n;i++){
            currMax=Math.max(currMax,jd[i]);
            int ans=memo(i+1,d-1,jd,dp);
            if(ans!=inf){
                min=Math.min(min,currMax+ans);
            }
        }
        
        return dp[idx][d]=min;
    }
    int inf=Integer.MAX_VALUE;
    public int recursion(int idx,int d,int[] jd){
        int n=jd.length;
        if(idx==n && d==0)return 0;
        if(idx==n || d==0)return inf;
        
        int currMax=jd[idx];
        int min=inf;
        
        for(int i=idx;i<n;i++){
            currMax=Math.max(currMax,jd[i]);
            int ans=recursion(i+1,d-1,jd);
            if(ans!=inf){
                min=Math.min(min,currMax+ans);
            }
        }
        
        return min;
    }
}