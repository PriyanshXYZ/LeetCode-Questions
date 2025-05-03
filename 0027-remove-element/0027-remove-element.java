class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int num : nums){
            if(num!=val){
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}
class Solution1 {
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public int removeElement(int[] nums, int val) {
        int left=0;
        int right=nums.length-1;
        if(left==right && nums[left]==val) return 0;
        if(left==right && nums[left]!=val) return 1;
        while(left<=right){
            if(nums[left]==val){
                swap(nums,left,right);
                right--;
            }else{
            left++;
            }
        }
        int k=nums.length-(nums.length-1-right);
        return k;
    }
}