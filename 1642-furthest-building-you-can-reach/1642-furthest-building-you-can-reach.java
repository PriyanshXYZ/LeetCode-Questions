class Solution {
    //using priority queue AC
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        
        
        for(int i=0;i<heights.length-1;i++){
            int diff=heights[i+1]-heights[i];
            if(diff>0){
                pq.add(diff);   
            }
            if(pq.size()>ladders){
                bricks-=pq.remove();
            }
            if(bricks<0)return i;
            }
        return heights.length-1;
    }
}
class Solution1 {
    //brute force have error in testCase [1,5,1,2,3,4,10000] bricks 4 ladder 1
    //because we are using laddder only when bricks are not there...but in this if we first use ladder and then use brick for small climb we can go further....
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int prev=heights[0];
        for(int i=1;i<heights.length;i++){
            if(prev<heights[i]){
                int diff=heights[i]-prev;
                if(bricks>=diff){
                    bricks-=diff;
                    System.out.println(diff+" brick "+" at "+i);
                }else{
                    if(ladders>0){
                        ladders--;
                        System.out.println(1+" ladder "+" at "+i);
                    }else{
                        return i-1;   
                    }
                }
            }
            prev=heights[i];
        }
        return heights.length-1;
    }
}