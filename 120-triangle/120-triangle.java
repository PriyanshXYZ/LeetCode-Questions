class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return tabulation(triangle);
        // int[][] dp=new int[triangle.size()+1][triangle.get(triangle.size()-1).size()+1];
        // for(int r=0;r<triangle.size();r++)
        //     Arrays.fill(dp[r],Integer.MIN_VALUE);
        // return memo(triangle,0,0,dp);
        // return recursion(triangle,0,0);
    }
    private int min(int ...args){
        int min=Integer.MAX_VALUE;
        for(int arg:args){
            min=Math.min(arg,min);
        }
        return min;
    }
    //O(2^(row)) Tc and O(row) Sc
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
    //O(row) Tc O(row*(maxCol)) Sc
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
    //O(row) tc O(row)Sc
    public int tabulation(List<List<Integer>> a){
        int[] dp=new int[a.size()+1];//dp on col
        int n=a.size();
        int m=a.get(n-1).size();
        for(int col=0;col<m;col++){
            dp[col]=a.get(n-1).get(col);
        }
        for(int row=n-2;row>=0;row--){//n-2 because we already stored last row values in dp
            for(int col=0;col<row+1;col++){
                dp[col]=Math.min(dp[col],dp[col+1])+a.get(row).get(col);
            }
        }
        return dp[0];
    }
    
}