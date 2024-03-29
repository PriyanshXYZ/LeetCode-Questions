class Solution {
    //O(n) 
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new ArrayDeque();//store idx of elem
        int n=nums.length;
        int[] res=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            //remove out of window elements
            while(q.size()>0 && q.peekFirst()<i-k+1){
                q.removeFirst();
            }
            //remove smaller elements than curr
            while(q.size()>0 && nums[q.peekLast()]<nums[i]){
                q.removeLast();
            }
            q.add(i);
            if(i>=k-1)
                res[idx++]=nums[q.peekFirst()];
        }
        return res;
        
    }
}
class Solution1 {
    //O(nlog(n-k))
    class Pair implements Comparable<Pair>{
        int val;
        int idx;
        Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=nums.length;
        // if(n==1)return new int[]{nums[0]};
        int[] window=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            if(i<k-1){
                pq.add(new Pair(nums[i],i));
            }else{
                while(pq.size()>0 && pq.peek().idx<i-k+1){
                    pq.remove();
                }
                
                pq.add(new Pair(nums[i],i));
                window[idx++]=pq.peek().val;
            }
        }
        return window;
    }
}