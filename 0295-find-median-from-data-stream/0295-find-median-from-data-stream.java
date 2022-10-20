class MedianFinder {
    
    List<Integer> nums;
    int size;
    public MedianFinder() {
        nums=new ArrayList();
        size=0;
    }
    
    public void addNum(int num) {
        int idx=Collections.binarySearch(nums,num);
        if(idx<0){
            idx=-idx;
            idx-=1;
        }
        if(size<=idx){
            nums.add(num);
        }else{
            nums.add(idx,num);
        }
        size=nums.size();
        // System.out.println(nums);
    }
    
    public double findMedian() {
        if(size%2==0){
            return (double)(nums.get((size-1)/2)+nums.get((size)/2))/2;
        }
        return nums.get(size/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */