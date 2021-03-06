class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] stops=new int[1001];
        for(int[] trip:trips){
            int ppl=trip[0];
            int from=trip[1];
            int to=trip[2];
            
            stops[from]+=ppl;
            stops[to]-=ppl;
        }
        int count=0;
        for(int i=0;i<1001;i++){
            count+=stops[i];
            
            if(count>capacity)return false;
        }
        return true;
    }
}
class Solution1 {
    //o(nlogn)
    public boolean carPooling(int[][] trips, int capacity) {
        int[] map=new int[1001];
        TreeSet<Integer> stops=new TreeSet();
        int currPassenger=0;
        
        for(int[] trip:trips){
            int ppl=trip[0];
            int from=trip[1];
            int to=trip[2];
            
            map[from]+=ppl;
            stops.add(from);
            
            map[to]-=ppl;
            stops.add(to);
        }
        
        int maxPassenger=0;
        for(int stop:stops){
            maxPassenger+=map[stop];
            
            if(maxPassenger>capacity)return false;
        }
        return true;
    }
}