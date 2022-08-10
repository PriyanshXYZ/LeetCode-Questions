class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        int lo=matrix[0][0];
        int hi=matrix[m-1][n-1];
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            
            int lowerThanMid=0;
            int j=n-1;
            for(int i=0;i<m;i++){
                while(j>=0 && matrix[i][j]>mid){
                    j--;
                }
                
                lowerThanMid+=(j+1);
            }
            
            if(lowerThanMid < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}
class Solution1 {
    // time O(nlogn) space O(n)
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