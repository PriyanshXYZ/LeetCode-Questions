class Solution {
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        int n = nums.length;
        while(j<n){
            
            while(j<n && nums[j]==0){
                j++;
            }
            if(j==n)break;
            if(nums[i]==0){
                swap(nums,i,j);
                i++;
            }else{
                i++;
                j++;
            }
        }
    }
}