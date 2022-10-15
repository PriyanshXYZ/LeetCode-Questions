class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int dist=startFuel;
        int idx=0;
        int stops=0;
        
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
        while(dist<target){
            while(idx<stations.length && stations[idx][0]<=dist){
                pq.add(stations[idx][1]);
                idx++;
            }
            // System.out.println(pq+" "+idx);
            if(dist>=target){
                return stops;
            }else if(pq.isEmpty()){
                return -1;
            }
            dist+=pq.remove();
            stops++;
            
        }
        return stops;
    }
}