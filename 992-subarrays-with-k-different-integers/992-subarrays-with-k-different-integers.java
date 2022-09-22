class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArrayWithAtmostK(nums,k)-subArrayWithAtmostK(nums,k-1);
    }
    
    public int subArrayWithAtmostK(int[] nums,int k){
        if(k==0)return 0;
        int n=nums.length;
        HashMap<Integer,Integer> elemFreq=new HashMap();
        int si=0,ei=0,numSubArr=0;
        
        for(;ei<n;ei++){
            elemFreq.put(nums[ei],elemFreq.getOrDefault(nums[ei],0)+1);
            
            while(elemFreq.size()==k+1){
                elemFreq.put(nums[si],elemFreq.get(nums[si])-1);
                if(elemFreq.get(nums[si])==0)elemFreq.remove(nums[si]);
                si++;
            }
            
            numSubArr+=ei-si+1;
        }
        return numSubArr;
    }
}