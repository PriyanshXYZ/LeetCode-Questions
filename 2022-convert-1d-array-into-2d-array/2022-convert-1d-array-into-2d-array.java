class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length)return new int[0][0];
        int[][] arr = new int[m][n];
        int r = 0;
        int c = 0;
        for(int i=0;i<original.length;i++){
            if(c < n){
                arr[r][c] = original[i];
                c++;
            }else {
                c = 0;
                r++;
                if(r<m){
                    arr[r][c] = original[i];
                    c++;
                }
            }
        }
        return arr;
    }
}