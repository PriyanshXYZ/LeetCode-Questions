class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap();
        int res=0;
        int sum=0;
        map.put(sum,1);
        
        for(int val:nums){
            sum+=val;
            int rem=sum%k;
            //we cannot have remainder <0 becuase it not valid
            if(rem<0){
                rem+=k;
            }
            
            if(map.containsKey(rem)){
                res+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return res;
    }
}