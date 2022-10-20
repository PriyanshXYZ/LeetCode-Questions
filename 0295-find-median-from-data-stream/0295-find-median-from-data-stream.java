class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left=new PriorityQueue(Collections.reverseOrder());
        right=new PriorityQueue();
    }
    
    public void addNum(int num) {
        if(left.size()>0 && num<left.peek()){
            left.add(num);
        }else{
            right.add(num);
        }
        if(left.size()-right.size()==2){
            right.add(left.remove());
        }else if(right.size()-left.size()==2){
            left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if(left.size()>right.size()){
            return left.peek();
        }else if(right.size()>left.size()){
            return right.peek();
        }else{
            return (double)(left.peek()+right.peek())/2;
        }
    }
}
class MedianFinder1 {
    //worst case O(n^2)..
    List<Integer> nums;
    int size;
    public MedianFinder1() {
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

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */