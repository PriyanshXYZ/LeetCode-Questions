class Solution {
    HashMap<Integer,Long> dp;
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides,(a,b)->(a[0]-b[0]));
        dp = new HashMap();
        return dfs(0,rides);
    }
    public long dfs(int curr , int[][] rides){
        //base case
        if(curr == rides.length)return 0;
        
        //memoize
        if(dp.containsKey(curr))return dp.get(curr);
        
        int nextIdx = findNext(curr, rides);
        
        long incFair = rides[curr][1] - rides[curr][0] + rides[curr][2] + (nextIdx==-1?0:dfs(nextIdx,rides));
        long excFair = dfs(curr + 1, rides);
        long profit = Math.max(incFair , excFair);
        dp.put(curr, profit);
        return profit;
    }
    public int findNext(int curr, int[][] rides){
        int lo = curr + 1, hi = rides.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            
            if(rides[mid][0] < rides[curr][1]){
                lo = mid + 1;
            }else{
                if(rides[mid-1][0] >= rides[curr][1]){
                    hi = mid - 1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }
}