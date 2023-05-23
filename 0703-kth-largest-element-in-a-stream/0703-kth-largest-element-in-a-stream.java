class KthLargest {
    List<Integer> list;
    int K;
    public KthLargest(int k, int[] nums) {
        K=k;
        list = new ArrayList<>();
        for(int val : nums){
            list.add(val);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size() - K);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */