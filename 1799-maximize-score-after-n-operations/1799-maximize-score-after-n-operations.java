class Solution {
    Integer[] dp = new Integer[1<<14];
    public int gcd(int a, int b){
        if(a==0)return b;
        return gcd(b % a, a);
    }
    public int maxScore(int[] nums) {
        int n = nums.length;
        return backtracking(nums, 0, 1);
    }
    public int backtracking(int[] nums, int mask,int cnt){
        if(dp[mask] != null)return dp[mask];
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if((mask & (1<<i)) !=0)continue;
            for(int j = i+1;j<nums.length; j++){
                if((mask & (1<<j)) !=0)continue;
                int newMask =  (1<<i) | (1<<j) | mask;
                int curr = cnt * (gcd(nums[i],nums[j]));
                curr += backtracking(nums,newMask,cnt+1);
                ans = Math.max(curr,ans);

            }
        }
        return dp[mask] = ans;
    }
}