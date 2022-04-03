class Solution {
    public void nextPermutation(int[] nums) {
        //corner case
        if(nums.length<2)return;
        int i=nums.length-2;
        //to find first decreasing element
        while(i>=0 && nums[i]>=nums[i+1])i--;
        //if all elements are in decreasing order to i would go negative
        if(i>=0){
            int j=nums.length-1;
            while(nums[i]>=nums[j])j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public void reverse(int[] a,int start){
        int end=a.length-1;
        while(start < end){
            swap(a,start,end);
            start++;
            end--;
        }
    }
}