class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] oneZero=new int[strs.length][2];//0 =>cnt 0 1=>cnt 1
        
        int idx=0;
        for(String str:strs){
            int one=0;
            int zero=0;
            for(char ch:str.toCharArray()){
                if(ch=='1')one++;
                else zero++;
            }
            oneZero[idx][0]=zero;
            oneZero[idx][1]=one;
            idx++;
        }
        int[][][] dp=new int[strs.length][m+1][n+1];
        return memo(oneZero,0,m,n,dp);
    }
    public int memo(int[][] oneZero,int idx,int m ,int n, int[][][] dp){
        if(idx==oneZero.length){
            return 0;
        }
        if(dp[idx][m][n]!=0){
            return dp[idx][m][n];
        }
        
        int reject=memo(oneZero,idx+1,m,n,dp);
        int select=0;
        if(oneZero[idx][0]<=m && oneZero[idx][1]<=n){
            select=1+memo(oneZero,idx+1,m-oneZero[idx][0],n-oneZero[idx][1],dp);
        }
        
        dp[idx][m][n]=Math.max(reject,select);
        return dp[idx][m][n];
    }
}