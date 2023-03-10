class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        return atLeast(nums,k)-atLeast(nums,k-1);
    }
    public int atLeast(int[] nums, int k){
        int n = nums.length;
        // HashMap<Integer,Integer> map = new HashMap<>();
        int ans =0;
        int si =0,cntOfOdd=0;
        for(int ei =0;ei < n;ei++){
            if(nums[ei]%2==1){
                cntOfOdd++;
            }
            
            while(cntOfOdd > k){
                if(nums[si] % 2 ==1){
                    cntOfOdd--;
                }
                si++;
            }
            ans += (ei - si + 1);
        }
        return ans;
    }
}