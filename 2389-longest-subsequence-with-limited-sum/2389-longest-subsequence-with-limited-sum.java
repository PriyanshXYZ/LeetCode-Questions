class Solution {
    public int[] answerQueries(int[] A, int[] queries) {
        Arrays.sort(A);
        
        int n = A.length, m = queries.length, res[] = new int[m];
        for (int i = 1; i < n; ++i)
            A[i] += A[i - 1];
        for (int i = 0; i < m; ++i) {
            int j = binarySearch(A, queries[i]);
            res[i] = j;
        }
        return res;
    }
    int binarySearch(int[] a, int val){
        int lo = 0, hi = a.length - 1;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(a[mid] == val){
                return mid + 1;
            }else if(a[mid] < val){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return a[lo] > val ? lo : lo + 1;
    }
}