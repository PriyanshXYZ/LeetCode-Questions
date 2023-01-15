class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap();
        int n = nums.length;
        int strt=0,end = 0;
        long count=0;
        int pairCnt = 0;
        for(; end < n; end++){
            pairCnt+=map.getOrDefault(nums[end],0);// 
            
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            
            while(strt<=end && pairCnt>=k){
                if(map.getOrDefault(nums[strt],0)>1){
                    pairCnt-=(map.get(nums[strt])-1);
                }
                count += n - end;
                map.put(nums[strt],map.getOrDefault(nums[strt],0)-1);
                strt++;
            }
        }
        
        return count;
    }
}