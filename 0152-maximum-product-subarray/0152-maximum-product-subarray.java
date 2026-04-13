class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxSoFar = 1;
        int minSoFar = 1;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            if(num < 0){
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(num, maxSoFar*num);
            minSoFar = Math.min(num, minSoFar*num);
            max = Math.max(maxSoFar,max);
        }
        return max;
    }
}

class Solution1 {
    
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