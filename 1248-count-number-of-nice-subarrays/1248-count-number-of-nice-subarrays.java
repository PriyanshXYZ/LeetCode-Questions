class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }
    public int atMostK(int[] nums,int k){
        HashMap<Integer,Integer> freqMap=new HashMap();
        
        int si=0,ei=0,niceSubArr=0;
        int odd=0;
        for(;ei<nums.length;ei++){
            freqMap.put(nums[ei],freqMap.getOrDefault(nums[ei],0)+1);
            odd+=nums[ei]%2;
            while(odd==k+1){
                freqMap.put(nums[si],freqMap.get(nums[si])-1);
                odd-=nums[si] % 2;
                
                if(freqMap.get(nums[si])==0){
                    freqMap.remove(nums[si]);
                }
                si++;
            }
            niceSubArr+=ei-si+1;
        }
        return niceSubArr;
    }
}