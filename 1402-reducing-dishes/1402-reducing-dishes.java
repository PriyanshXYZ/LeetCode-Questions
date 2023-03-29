class Solution {
    Integer[][] dp;
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        dp = new Integer[501][501];
        return memo(0, satisfaction, 1);
    }
    
    public int recursion(int idx, int[] a, int time){
        if(idx == a.length){
            return 0;
        }
        
        int inc = a[idx]*time + recursion(idx + 1, a, time + 1);
        int exc = recursion(idx + 1, a, time);
        
        return Math.max(inc , exc);
    }
    
    public int memo(int idx, int[] a, int time){
        if(idx == a.length){
            return 0;
        }
        
        if(dp[idx][time]!=null)return dp[idx][time];
        
        int inc = a[idx]*time + memo(idx + 1, a, time + 1);
        int exc = memo(idx + 1, a, time);
        
        return dp[idx][time] = Math.max(inc , exc);
    }
}