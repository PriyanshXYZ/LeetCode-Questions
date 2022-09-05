class Solution {
    //O(log(n+m))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        
        int e1=(n+m+1)/2;
        int e2=(n+m+2)/2;
        
        int median1=findKth(nums1,0,nums2,0,e1);
        int median2=findKth(nums1,0,nums2,0,e2);
        
        return (median1+median2)/2.0;
    }
    private int findKth(int[] A, int aStart, int[] B, int bStart, int k){
        if(aStart >= A.length){
            return B[bStart + k - 1];
        }
        if(bStart >= B.length){
            return A[aStart + k - 1];
        }
        if(k == 1){
            return Math.min(A[aStart], B[bStart]);
        }
        int aMid = aStart + k/2 - 1;
        int bMid = bStart + k/2 - 1;
        int aVal = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];
        int bVal = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];
        if(aVal <= bVal){
            return findKth(A, aMid + 1, B, bStart, k - k/2);
        }else{
            return findKth(A, aStart, B, bMid + 1, k - k/2);
        }
    }
}
class Solution1 {
    //O(n+m)
    public int[] merge2Arrays(int[] n1,int[] n2){
        int n=n1.length+n2.length;
        int[] a=new int[n];
        
        int i=0,j=0;
        int k=0;
        while(i<n1.length && j<n2.length){
            if(n1[i]<=n2[j]){
                a[k]=n1[i];
                i++;
            }else{
                a[k]=n2[j];
                j++;
            }
            k++;
        }
        while(i<n1.length){
            a[k]=n1[i];
            i++;
            k++;
        }
        while(j<n2.length){
            a[k]=n2[j];
            k++;
            j++;
        }
        return a;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans=merge2Arrays(nums1,nums2);
        int mid=ans.length/2;
        if(ans.length%2==0){
            return ((double)(ans[mid-1]+ans[mid])/2);
        }else{
            return (double)(ans[mid]);
        }
    }
}