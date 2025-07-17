class Solution {
    Integer[][] dp;
    public int mincostTickets(int[] days, int[] costs) {
        // question revolves around choosing best of 3 choices 
        //.. wherein we have to also loop over array over and over again
        // better we can do something binary search 
        // and exploring all option with caching 
        // so it would be O(nlogn)
        dp = new Integer[days.length + 1][400];
        return recursion(0, 0, days, costs);
    }

    private int recursion(int idx, int curr, int[] days, int[] costs) {
        //base case
        if(idx == days.length) return dp[idx][curr] = 0;

        if(dp[idx][curr] != null)return dp[idx][curr];

        if(curr > days[idx]) return  recursion(idx + 1, curr, days, costs);
        int oneDay = costs[0] + recursion(idx + 1, days[idx] + 1, days, costs);
        int sevenDays = costs[1] + recursion(idx + 1, days[idx] + 7, days, costs);
        int thirtyDays = costs[2] + recursion(idx + 1, days[idx] + 30, days, costs);

        return dp[idx][curr] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
    }
}