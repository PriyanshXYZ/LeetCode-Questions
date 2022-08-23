class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //start from reverse
        int n=matrix.length;
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int min=Integer.MAX_VALUE;
                if((j-1)>=0){
                    min=Math.min(min,matrix[i+1][j-1]);
                }
                
                min=Math.min(min,matrix[i+1][j]);
                
                if((j+1)<n){
                    min=Math.min(min,matrix[i+1][j+1]);
                }
                matrix[i][j]+=min;
            }
            // for(int j=0;j<n;j++){
            //     System.out.print(matrix[i][j]+" ");
            // }
            // System.out.println();
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,matrix[0][i]);
        }
        return ans;
    }
}