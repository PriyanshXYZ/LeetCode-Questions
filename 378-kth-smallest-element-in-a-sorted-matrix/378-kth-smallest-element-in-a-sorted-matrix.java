class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] a=new int[matrix.length*matrix[0].length];
        int idx=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                a[idx++]=matrix[i][j];
            }
        }
        Arrays.sort(a);
        int n=a.length;
        return a[k-1];
    }
}