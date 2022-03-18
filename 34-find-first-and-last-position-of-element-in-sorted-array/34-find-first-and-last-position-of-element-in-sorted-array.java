class Solution {
    //if we are not updating like mid+1 or mid-1 for strt or end indx then make sure that iterating condition must be such that i and j must not be adjecant;
    public int[] searchRange(int[] a, int target) {
        if(a.length==0)return new int[]{-1,-1};
        return new int[]{ firstIdxbs(a,target), lastIdxbs(a,target)};
    }
    public int firstIdxbs(int[] a,int target){
        int i=0,j=a.length-1;
        int idx=-1;
        while(i<j-1){
            int mid=i+(j-i)/2;
            if(a[mid]>=target){
                //update j drop i
                j=mid;
            }else{
                i=mid;
            }
        }
        if(a[i]==target) return i;
        if(a[j]==target) return j;
        return idx;
    }
     public int lastIdxbs(int[] a,int target){
        int i=0,j=a.length-1;
        int idx=-1;
        while(i<j-1){
            int mid=i+(j-i)/2;
            if(a[mid]<=target){
                i=mid;
            }else{
               j=mid;
            }
        }
        if(a[j]==target) return j;
        if(a[i]==target) return i;
        return idx;
    }
}