class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int i=n-1;
        int j=0;
        while(i>=0 && j<m){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }
}
class Solution1 {
    //o(n^2)
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target)return true;
            }    
        }
        return false;
    }
}