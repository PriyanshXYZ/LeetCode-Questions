class Solution {
    public long countPairs(int[] nums, int k) {
        HashMap<Integer,Integer> div=new HashMap();//store occurance of each gcd
        
        long count=0;
        for(int i=0;i<nums.length;i++){
            int gcd=gcd(k,nums[i]);
            for(int fac:div.keySet()){
                if((long)gcd*fac%k==0){
                    count+=div.get(fac);
                }
            }
            div.put(gcd,div.getOrDefault(gcd,0)+1);
        }
        return count;
    }
    private int gcd(int a,int b){
        if(a==0)return b;
        return gcd(b%a,a);
    }
}