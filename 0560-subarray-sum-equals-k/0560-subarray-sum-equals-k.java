class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap();
        int ans=0;
        int sum=0;
        map.put(sum,1);
        for(int val:nums){
            sum+=val;
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
        
    }
}