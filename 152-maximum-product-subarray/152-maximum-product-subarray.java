class Solution {
    
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int prod=1;
        int n=nums.length;
        //prefix
        for(int i=0;i<n;i++){
            prod=prod*nums[i];
            ans=Math.max(prod,ans);
            
            if(prod==0)prod=1;
        }
        
        prod=1;
        //suffix 
        for(int i=n-1;i>=0;i--){
            prod=prod*nums[i];
            ans=Math.max(prod,ans);
            
            if(prod==0)prod=1;
        }
        return ans;
    }
}