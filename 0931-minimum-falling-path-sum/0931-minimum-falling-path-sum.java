class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer[] dp = new Integer[n];
        
        for(int i=0;i<n;i++){
            dp[i]=matrix[0][i];
        }
        
        for(int i=1;i<n;i++){
            Integer[] curr = new Integer[n];
            for(int j=0;j<n;j++){
                int ans = matrix[i][j] + dp[j];
                if(j>0){
                    ans = Math.min(ans,matrix[i][j]+dp[j-1]);
                }
                if(j<n-1){
                    ans = Math.min(ans,matrix[i][j]+dp[j+1]);
                }
                curr[j] = ans;
                // System.out.print(curr[j]+" ");
            }
            // System.out.println();
            dp = curr;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int val : dp){
            ans = Math.min(ans, val);
        }
        return ans;
    }
}