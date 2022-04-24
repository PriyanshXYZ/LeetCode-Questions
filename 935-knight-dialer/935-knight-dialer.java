class Solution {
    public static int max=(int)Math.pow(10,9)+7;
    
    public int knightDialer(int n) {
        long[][][] dp=new long[5][3][n+1];
        long s=0;
        for(int r=0;r<4;r++){
            for(int c=0;c<3;c++){
                // s=(s+recursion(r,c,n))%max;
                s=(s+memo(r,c,n,dp))%max;
            }
        }
        return (int)s;
    }
    
    public long recursion(int r,int c,int n){
        //out of dailpad or on * or #
        if(r<0 || c<0 || r>=4 || c>=3 || (r==3 &&(c!=1)))return 0;
        
        //n==1 => we just have to be in that spot i.e a way possible
        if(n==1)return 1;
        
        long ans=recursion(r-2,c+1,n-1)%max+//2up 1 right
                recursion(r-1,c+2,n-1)%max+//1 up 2 right
                recursion(r+1,c+2,n-1)%max+//1 down 2 right
                recursion(r+2,c+1,n-1)%max+//2 down 1 right
                recursion(r+2,c-1,n-1)%max+//2 down 1 left
                recursion(r+1,c-2,n-1)%max+//1 down 2 left
                recursion(r-1,c-2,n-1)%max+//1 up 2 left
                recursion(r-2,c-1,n-1)%max;//2 up 1 left
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
        long ans=memo(r-2,c+1,n-1,dp)%max+//2up 1 right
                memo(r-1,c+2,n-1,dp)%max+//1 up 2 right
                memo(r+1,c+2,n-1,dp)%max+//1 down 2 right
                memo(r+2,c+1,n-1,dp)%max+//2 down 1 right
                memo(r+2,c-1,n-1,dp)%max+//2 down 1 left
                memo(r+1,c-2,n-1,dp)%max+//1 down 2 left
                memo(r-1,c-2,n-1,dp)%max+//1 up 2 left
                memo(r-2,c-1,n-1,dp)%max;//2 up 1 left
        return dp[r][c][n]=ans;
    }
}