class Solution {
    //Priyansh Ragit is the best
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int val;
        
        Pair(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
        
        public int compareTo(Pair other){
            return this.val-other.val;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        
        List<List<Integer>> res=new ArrayList();
        int n1=nums1.length;
        int n2=nums2.length;
        
        PriorityQueue<Pair> pq=new PriorityQueue();
        for(int i=0;i<nums1.length && i<k;i++){
            pq.add(new Pair(i,0,nums1[i]+nums2[0]));
        }
        
        
        while(k-->0 && !pq.isEmpty()){
            Pair rem=pq.remove();
            res.add(new ArrayList());
            res.get(res.size()-1).add(nums1[rem.x]);
            res.get(res.size()-1).add(nums2[rem.y]);
            if(rem.y==nums2.length-1)continue;
            pq.add(new Pair(rem.x,rem.y+1,nums1[rem.x]+nums2[rem.y+1]));
        }
        return res;
    }
}