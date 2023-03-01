class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(0,nums.length-1,nums);
    }
    public int[] mergeSort(int lo, int hi, int[] nums){
        if(lo==hi){
            return new int[]{nums[lo]};
        }
        int mid = lo + (hi - lo) / 2;
        
        int[] left = mergeSort(lo, mid, nums);
        int[] right = mergeSort(mid + 1, hi, nums);
        
        int[] res = merge2SortedArray(left, right);
//         for(int i=0;i<res.length;i++){
//             System.out.print(res[i]+" ");
//         }
        
//         System.out.println();
        return res;
    }
    public int[] merge2SortedArray(int[] a, int[] b){
        int n = a.length, m = b.length;
        int[] res = new int[n + m];
        int idx1 = 0, idx2 = 0, idx3 = 0;
        
        while(idx1 < n && idx2 < m){
            if(a[idx1]<=b[idx2]){
                res[idx3] = a[idx1];
                idx3++;
                idx1++;
            }else{
                res[idx3] = b[idx2];
                idx3++;
                idx2++;
            }
        }
        
        while(idx1 < n){
            res[idx3] = a[idx1];
            idx3++;
            idx1++;
        }
        
        while(idx2 < m){
            res[idx3] = b[idx2];
            idx3++;
            idx2++;
        }
        
        return res;
    }
}