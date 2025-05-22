/**
    1 2 3
    []  [1] => [1] []
    [1] [2]
    [1] [2,3] => [1,2] [3]

    1 4 3 2
    [] [1] => [1] []
    [1] [4]
    [1] [3, 4] => [1,3] [4]
    [1,3] [2,4] 

    -1 -2 -3 -4 -5
    [] [-1] => [-1] [0]
    [-1] [-2]
    [-1] [-3, -2] => [-3,-1] [-2]
    []
 */

class MedianFinder {
    PriorityQueue<Integer> maxHeap; // to store lower values
    PriorityQueue<Integer> minHeap; // to store higher values

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        int streamSize = getSize();
        //balance the heaps
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        int streamSize = getSize();
        if(streamSize % 2 == 0){
            double median1 = maxHeap.peek() / 2.0;
            double median2 = minHeap.peek() / 2.0;
            return median1 + median2;
        }else {
            double median = maxHeap.peek() * 1.0;
            return median;
        }
    }

    private int getSize(){
        return minHeap.size() + maxHeap.size();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */