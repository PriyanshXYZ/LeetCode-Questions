class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        
        int prev=1;
        for(int i=0;i<n;i++){
            left[i]=prev*nums[i];
            prev=left[i];
        }
        
        int ahead=1;
        for(int i=nums.length-1;i>=0;i--){
            right[i]=ahead*nums[i];
            ahead=right[i];
        }
        
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int a=i-1>=0?left[i-1]:1;
            int b=i+1<nums.length?right[i+1]:1;
            ans[i]=a*b;
        }
        return ans;
    }
}