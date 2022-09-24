class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int lo=matrix[0][0];
        int hi=matrix[n-1][n-1];
        
        while(lo<hi){
            int mid=lo + (hi - lo)/2;
            
            int count=0,j=n-1;
            for(int i=0;i<n;i++){
                while(j>=0 && mid<matrix[i][j]){
                    j--;
                }
                count+=j+1;
            }
            
            if(count<k){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return lo;
    }
}
class Solution1 {
    // time O(n*n) space O(n)
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