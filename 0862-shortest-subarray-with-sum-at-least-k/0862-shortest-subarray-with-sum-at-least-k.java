class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int minLen=nums.length+1;
        
        //creating a prefix array
        long[] prefix=new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        
        Deque<Integer> idxQ=new ArrayDeque();
        
        for(int i=0;i<=nums.length;i++){
            
            //to get the shortest possible subarray with sum least k
            while(idxQ.size()>0 && prefix[i]-prefix[idxQ.peekFirst()]>=k){
                minLen=Math.min(minLen,i-idxQ.removeFirst());
            }
            
            while(idxQ.size()>0 && prefix[i]<=prefix[idxQ.peekLast()]){
                idxQ.removeLast();
            }
            idxQ.addLast(i);
        }
        return minLen>nums.length?-1:minLen;
    }
}