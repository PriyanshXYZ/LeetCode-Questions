class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length)return new int[0][0];
        int[][] arr = new int[m][n];
        int r = 0;
        int c = 0;
        int i = 0;
        while(i<original.length){
            if(r<m){
                if(c < n){
                    arr[r][c] = original[i];
                    c++;
                    i++;
                }else {
                    c = 0;
                    r++;
                }
            }
        }
        return arr;
    }
}