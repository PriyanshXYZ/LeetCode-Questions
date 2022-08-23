class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //start from reverse
        int n=matrix.length;
        int m=matrix[0].length;
        
        int[] dig=new int[n];
        //fill
        for(int i=0;i<m;i++){
            dig[i]=matrix[0][i];
        }
        
        // for(int i=0;i<n;i++){
        //     System.out.print(dig[i]+" ");
        // }
        // System.out.println();
        
        for(int i=1;i<n;i++){
            int[] temp=new int[m];
            
            for(int j=0;j<m;j++){
                int min=Integer.MAX_VALUE;
                if(j-1>=0){
                    min=Math.min(min,dig[j-1]);
                }
                min=Math.min(min,dig[j]);
                if(j+1<m){
                    min=Math.min(min,dig[j+1]);
                }
                temp[j]=min+matrix[i][j];
            }
            dig=temp;
            // for(int k=0;k<n;k++){
            //     System.out.print(dig[k]+" ");
            // }
            // System.out.println();
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,dig[i]);
        }
        return ans;
    }
}