class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> dp = new HashMap<>();
    int Mod = (int)(1e9+7);
    public int specialPerm(int[] nums) {
        return memo(0,0,0,nums);
    }
    
    public int memo(int idx, int mask, int last, int[] nums){
        if(idx==nums.length)return 1;//we have got our permutation
        
        if(dp.containsKey(last) && dp.get(last).containsKey(mask)){
            return dp.get(last).get(mask);
        }
        
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            if((mask & (1<<i)) ==0){
                if(idx == 0 || nums[last] % nums[i] ==0 || nums[i] % nums[last] ==0){
                    ans += memo(idx+1 , mask | (1<<i) , i, nums);
                    ans %= Mod;
                }
            }
        }
        dp.putIfAbsent(last,new HashMap<>());
        dp.get(last).put(mask,(int)ans);
        return (int)ans;
    }
}