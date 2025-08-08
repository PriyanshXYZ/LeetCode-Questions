class Solution {
    public double soupServings(int n) {
        if(n > 5000){
            return 1;
        }
        Double[][] dp = new Double[n+1][n+1];
        return memoization(n, n, dp);
    }
    int[][] serves ={{100,0},{75,25},{50,50},{25,75}};
    public double memoization(int a, int b, Double[][] dp){
        if(a<=0 && b<=0)return 0.5;
        if(a<=0)return 1.0;
        if(b<=0)return 0.0;
        
        if(dp[a][b] != null)return dp[a][b];
        
        
        double ans = 0;
        for(int[] serve : serves){
            int aServe = serve[0];
            int bServe = serve[1];
            
            ans += memoization(a - aServe, b - bServe, dp);
        }
        return dp[a][b] = (double)(0.25 * ans);
    }
}