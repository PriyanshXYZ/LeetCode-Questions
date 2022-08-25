class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        //start from reverse
        int n=matrix.length;
        int m=matrix[0].length;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        //fill
        for(int i=0;i<m;i++){
            pq.add(matrix[0][i]);
        }
        
      
        
        for(int i=1;i<n;i++){
            int small1=pq.remove();
            int small2=pq.remove();
            for(int j=0;j<m;j++){
                if(matrix[i-1][j]==small1){
                    matrix[i][j]=small2+matrix[i][j];
                }else{
                    matrix[i][j]=small1+matrix[i][j];
                }
            }
            pq=new PriorityQueue();
            for(int j=0;j<m;j++){
                pq.add(matrix[i][j]);
            }
        }
        
        return pq.remove();
    }
}