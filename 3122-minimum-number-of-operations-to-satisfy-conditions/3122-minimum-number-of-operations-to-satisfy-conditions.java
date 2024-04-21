class Solution {
    public int minimumOperations(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] freqCol = new int[m][10];
        
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                freqCol[j][grid[i][j]]++;
            }
        }
        for(int j=0;j<m;j++){
            for(int i=0;i<10;i++)
            freqCol[j][i] = n - freqCol[j][i];
        }
        
        Integer[][] dp = new Integer[m][10];
        return recursion(0,-1,freqCol,dp);
    }
    int recursion(int idx, int prev, int[][] comp, Integer[][] dp) {
        //base case
        if(idx==dp.length)return 0;
        //optimization
        if(prev!=-1 && dp[idx][prev]!=null)return dp[idx][prev];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<10;i++){
            if(i!=prev){
                int ops = comp[idx][i];
                ans = Math.min(ops + recursion(idx+1,i,comp,dp),ans);
            }
        }
        if(prev!=-1){
            dp[idx][prev] = ans;
        }
        return ans;
    }
}