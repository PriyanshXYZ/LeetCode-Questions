class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            //to search if element is already present at mid left or right
            if(nums[mid]==target){
                return mid;
            }        
            if(nums[mid]<=nums[right]){
                //mid to right is sorted
                if(target>nums[mid] && target<=nums[right]) left=mid+1;
                else right=mid-1;
            }else{
                if(target<nums[mid] && target>=nums[left]) right=mid-1;
                else left=mid+1;
            }
        }
        return -1; 

    }
}