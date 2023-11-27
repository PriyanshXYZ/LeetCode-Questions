class Solution {
    public static int MOD=(int)Math.pow(10,9)+7;
    
    public int knightDialer(int n) {
        int[][] dp=new int[n+1][10];
        int[][] tab={{4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {3, 9, 0},
            {},
            {1, 7, 0},
            {2, 6},
            {1, 3},
            {2, 4}};
        
        for(int square = 0; square < 10; square++){
            dp[0][square] = 1;
        }
        
        for(int remain = 1; remain < n; remain++){
            for (int square = 0; square < 10; square++) {
                int ans = 0;
                for (int nextSquare : tab[square]) {
                    ans = (ans + dp[remain - 1][nextSquare]) % MOD;
                }
                dp[remain][square] = ans;
            }
        }
        
        int ans = 0;
        for (int square = 0; square < 10; square++) {
            ans = (ans + dp[n - 1][square]) % MOD;
        }
        
        return (int)ans;
    }
    
    public long recursion(int r,int c,int n){
        //out of dailpad or on * or #
        if(r<0 || c<0 || r>=4 || c>=3 || (r==3 &&(c!=1)))return 0;
        
        //n==1 => we just have to be in that spot i.e a way possible
        if(n==1)return 1;
        
        long ans=recursion(r-2,c+1,n-1)%MOD+//2up 1 right
                recursion(r-1,c+2,n-1)%MOD+//1 up 2 right
                recursion(r+1,c+2,n-1)%MOD+//1 down 2 right
                recursion(r+2,c+1,n-1)%MOD+//2 down 1 right
                recursion(r+2,c-1,n-1)%MOD+//2 down 1 left
                recursion(r+1,c-2,n-1)%MOD+//1 down 2 left
                recursion(r-1,c-2,n-1)%MOD+//1 up 2 left
                recursion(r-2,c-1,n-1)%MOD;//2 up 1 left
        return ans;
    }
    
    public long memo(int r,int c,int n,long[][][] dp){
        //out of dailpad or on * or #
        if(r<0 || c<0 || r>=4 || c>=3 || (r==3 &&(c!=1)))return 0;
        
        //n==1 => we just have to be in that spot i.e a way possible
        if(n==1)return dp[r][c][n]=1;
        
        if(dp[r][c][n]!=0){
            return dp[r][c][n];
        }
        long ans=memo(r-2,c+1,n-1,dp)%MOD+//2up 1 right
                memo(r-1,c+2,n-1,dp)%MOD+//1 up 2 right
                memo(r+1,c+2,n-1,dp)%MOD+//1 down 2 right
                memo(r+2,c+1,n-1,dp)%MOD+//2 down 1 right
                memo(r+2,c-1,n-1,dp)%MOD+//2 down 1 left
                memo(r+1,c-2,n-1,dp)%MOD+//1 down 2 left
                memo(r-1,c-2,n-1,dp)%MOD+//1 up 2 left
                memo(r-2,c-1,n-1,dp)%MOD;//2 up 1 left
        return dp[r][c][n]=ans;
    }
}