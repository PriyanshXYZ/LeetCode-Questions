class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue();
        int idx=0;
        while(k>0){
            pq.add(nums[idx]);
            idx++;
            k--;
        }
        
        while(idx<nums.length){
            if(pq.peek()<nums[idx]){
                pq.remove();
                pq.add(nums[idx]);
            }
            idx++;
        }
        return pq.peek();
    }
}