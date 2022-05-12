class Solution {
     // 1. Find the largest index k such that nums[k] < nums[k + 1]. If no such index , just reverse
    // 2. Find the largest index l > k such that nums[k] < nums[l]
    // 3. Swap nums[k] and nums[l]
    // 4. Reverse the sub-array nums[k + 1:]
    
    // how to understand it:
    // step-1: easy, find the first digit that can be swapped to make permutation bigger
    // step-2: easy, find the digit bigger but closest to nums[k]
    // step-3: swap(nums[k], nums[l])
    // step-4: sort the subarray nums[k+1:end], why we can just reverse instead of sort?
    //         because we know nums[k+1:end] must be non-increasing, reason:
    //         1. at step 1, we know nums[k+1:end] is non-decreasing
    //         2. before swap in step 3, we know nums[l-1] >= nums[l] > nums[k] >= nums[l+1]
    //         3. so after swap, we still have nums[l-1] > nums[k] >= nums[l+1], so we can reverse it
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