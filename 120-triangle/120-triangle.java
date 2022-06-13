class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()+1][triangle.get(triangle.size()-1).size()+1];
        for(int r=0;r<triangle.size();r++)
            Arrays.fill(dp[r],Integer.MIN_VALUE);
        return memo(triangle,0,0,dp);
        // return recursion(triangle,0,0);
    }
    private int min(int ...args){
        int min=Integer.MAX_VALUE;
        for(int arg:args){
            min=Math.min(arg,min);
        }
        return min;
    }
    public int recursion(List<List<Integer>> a,int row,int col){
        if(row==a.size())return 0;
        if(col>=a.get(row).size())return Integer.MAX_VALUE;
        
        int minSum=Integer.MAX_VALUE;
        for(int c=col;c<=col+1;c++){
            int sum1=recursion(a,row+1,col)+a.get(row).get(col);
            int sum2=recursion(a,row+1,col+1)+a.get(row).get(col);
            minSum=min(sum1,sum2,minSum);
        }
        return minSum;
    }
    
    public int memo(List<List<Integer>> a,int row,int col,int[][] dp){
        if(row==a.size())return dp[row][col]=0;
        if(col>=a.get(row).size())return Integer.MAX_VALUE;
        
        if(dp[row][col]!=Integer.MIN_VALUE)return dp[row][col];
        
        int minSum=Integer.MAX_VALUE;
        for(int c=col;c<=col+1;c++){
            int sum1=memo(a,row+1,col,dp)+a.get(row).get(col);
            int sum2=memo(a,row+1,col+1,dp)+a.get(row).get(col);
            minSum=min(sum1,sum2,minSum);
        }
        return dp[row][col]=minSum;
    }
    
}