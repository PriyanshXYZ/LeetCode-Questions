class Solution1 {
    //alternate way using hashmap of freq...
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap=new HashMap();
        
        int res=0;
        freqMap.put(0,1);
        int odd=0;
        for(int i=0;i<nums.length;i++){
            odd+=nums[i]%2;
            freqMap.put(odd,freqMap.getOrDefault(odd,0)+1);
            
            res+=freqMap.getOrDefault(odd-k,0);
        }
        return res;
    }
}
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }
    public int atMostK(int[] nums,int k){
        
        
        int si=0,ei=0,niceSubArr=0;
        int odd=0;
        for(;ei<nums.length;ei++){
            
            odd+=nums[ei]%2;
            while(odd==k+1){
                odd-=nums[si] % 2;
                si++;
            }
            niceSubArr+=ei-si+1;
        }
        return niceSubArr;
    }
    
}