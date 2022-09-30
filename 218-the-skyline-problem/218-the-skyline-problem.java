class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        //Priyansh Ragit is the best
        List<List<Integer>> res=new ArrayList();
        
        List<int[]> height=new ArrayList();
        for(int[] b:buildings){
            int sp=b[0];
            int ep=b[1];
            int ht=b[2];
            
            height.add(new int[]{sp,-ht}); // initail with -ve so that we can get to know the distinction between strt of skyline vs end of skyline
            height.add(new int[]{ep,ht});
        }
        
        Collections.sort(height, (a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });
        
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
        pq.add(0);
        int maxHt=0;
        for(int[] ht:height){
            if(ht[1]<0){//start point
                pq.add(-ht[1]);
            }else{//end point
                pq.remove(ht[1]);
            }
            
            if(maxHt!=pq.peek()){
                maxHt=pq.peek();
                
                List<Integer> skyline=new ArrayList();
                skyline.add(ht[0]);
                skyline.add(pq.peek());
                
                res.add(skyline);
            }
        }
        return res;
    }
}