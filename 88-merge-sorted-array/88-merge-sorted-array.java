class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3=new int[m];
        for(int i=0;i<m;i++){
            nums3[i]=nums1[i];
        }
        
        int p1=0;
        int p2=0;
        int idx=0;
        while(p1<m && p2<n){
            if(nums3[p1]<=nums2[p2]){
                nums1[idx]=nums3[p1];
                idx++;
                p1++;
            }else{
                nums1[idx]=nums2[p2];
                idx++;
                p2++;
            }
        }
        
        while(p1<m){
            nums1[idx]=nums3[p1];
            p1++;
            idx++;
        }
        while(p2<n){
            nums1[idx]=nums2[p2];
            p2++;
            idx++;
        }
        
    }
}