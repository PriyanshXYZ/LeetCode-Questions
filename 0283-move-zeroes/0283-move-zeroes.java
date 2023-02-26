class Solution {
    public void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public void moveZeroes(int[] nums) {
        int i=0,j=1;
        while(j<nums.length){
            if(nums[i]==0){
                if(nums[j]!=0){
                    swap(nums,i,j);
                    i++;
                    j++;
                }else{
                     j++;
                }
            }else{
                i++;
                j++;
            }
            
        }
    }
}