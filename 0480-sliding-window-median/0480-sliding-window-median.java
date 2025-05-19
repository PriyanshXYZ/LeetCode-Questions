class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        TreeSet<Integer> minHeap = new TreeSet<>((a, b) -> (nums[a] == nums[b] ? (a - b) : Integer.compare(nums[a], nums[b])));
        TreeSet<Integer> maxHeap = new TreeSet<>((a, b) -> (nums[a] == nums[b] ? (a - b) : Integer.compare(nums[b], nums[a])));
        
        double[] res = new double[n-k+1];
        int i = 0;
        int j = 0;
        while(i < n){
            //remove out of index arrays
            //balance the heaps
            minHeap.add(i);
            maxHeap.add(minHeap.pollFirst());
            
            if(maxHeap.size() > minHeap.size()) minHeap.add(maxHeap.pollFirst());
            double median = 0;
            System.out.println("after rebalance :"+maxHeap+" "+minHeap);
            if(maxHeap.size() + minHeap.size() == k){
                if(maxHeap.size() == minHeap.size()){
                    median = nums[maxHeap.first()]/2.0 + (long)nums[minHeap.first()]/2.0;
                }else{
                    median = nums[minHeap.first()];
                }
                res[j] = median;
                if(minHeap.contains(j)){
                    minHeap.remove(j);
                }else{
                    maxHeap.remove(j);
                }
                j++;
            }
            i++;
        }
        return res;
    }
}