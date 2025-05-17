class Solution {
    /**
        Algo => 1. add k first elements to maxHeap
                2. remove the out of window elements
                3. update the answer for the window by peeking the element 
        nums = [1,3,-1,-3,5,3,6,7], k = 3
        [{0,1},{1,3},{-1,3}] -> [{1,3},{0,1},{2,-1}]
        res[0] = 3 [{0,1},{2,-1}]
        [{0,1},{2,-1}] => 0th index is invalid so we will have to remove this!!
        [3,-1,-3] -> [2,-1,]

        [9,8,1,2,3,4,5,6,7] 
        maxHeap => [9,8,1] i->0-2
                => [8,2,1] i->1-3
                => [3,2,1] i->2-4
                => [4,3,2,1] i->3-5
                => [5,4,3,2,1] i>4-
        TC -> nlogn
        SC -> n

        [9,8,1,2,3,4,5,6,7]
        Deque=>[0{9},1{8},2{1}]  i->0-2 ans => 9
             =>[1{8},3{2},]

     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque();
        int[] res = new int[n-k+1];
        int idx = 0;
        while(idx<n){
            //remove invalid index from behind
            while(!deque.isEmpty() && deque.peekFirst()<(idx-k+1)){
                deque.removeFirst();
            }
            //remove smaller element than current from behind
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[idx]){
                deque.removeLast();
            }
            deque.addLast(idx);
            //if we are in valid window add to our answer the peek of the queue
            if(idx>=k-1 && idx<n){
                res[idx-k+1] = nums[deque.peek()];
            }
            idx++;
        }
        return res;
    }
}