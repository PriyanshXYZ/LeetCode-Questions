class Solution {
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