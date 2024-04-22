class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 0;
        int hi = m * n;
        
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = count(m,n,mid);
            if(cnt < k) {
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
    public int count(int m , int n, int num) {
        int lesser = 0;
        for(int i=1;i<=m;i++){
            lesser+=Math.min(num/i, n);
        }
        return lesser;
    }
}