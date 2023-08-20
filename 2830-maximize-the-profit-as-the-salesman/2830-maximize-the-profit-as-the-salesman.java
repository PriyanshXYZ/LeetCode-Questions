class Solution {
    Integer[] dp;
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
         Collections.sort(offers,(list1,list2)->{
           if(list1.get(0)!=list2.get(0)){
               return list1.get(0)-list2.get(0);
           }else{
               return list1.get(1)-list2.get(1);
           }
        });
        
        dp = new Integer[offers.size()+1];
        return recursion(0,offers);
    }
    
    public int bs(List<List<Integer>> offer,int curr){
        int lo = 0, hi = offer.size()-1;
        int ans = offer.size();
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            
            if(offer.get(mid).get(0)>curr){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return ans;
    }
    public int recursion(int idx, List<List<Integer>> offers){
        if(idx==offers.size())return 0;
        
        if(dp[idx]!=null)return dp[idx];
        
        int nextIdx = bs(offers,offers.get(idx).get(1));
        int take = offers.get(idx).get(2) + recursion(nextIdx, offers);
        
        int notTake = recursion(idx+1, offers);
        
        int ans = Math.max(take,notTake);
        dp[idx]=ans;
        return ans;
    }
}