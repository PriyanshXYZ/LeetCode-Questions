class Solution {
    class Pair implements Comparable<Pair>{
        int list;
        int idx;
        int val;
        
        Pair(int list,int idx,int val){
            this.list=list;
            this.idx=idx;
            this.val=val;
        }
        @Override
        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq=new PriorityQueue();
        
        
        int max=0;
        for(int i=0;i<nums.size();i++){
            max=Math.max(nums.get(i).get(0),max);
            pq.add(new Pair(i,0,nums.get(i).get(0)));
            
        }
        int diff=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        while(nums.size()==pq.size()){
            Pair p=pq.remove();
            
            int currdiff=max-p.val;
            
            if(currdiff<diff){
                diff=currdiff;
                start=p.val;
                end=max;
            }
            
            if(p.idx < nums.get(p.list).size()-1){
                p.idx++;
                p.val=nums.get(p.list).get(p.idx);
                pq.add(p);
                max=Math.max(max,p.val);
            }
        }
        
        return new int[]{start,end};
    }
}