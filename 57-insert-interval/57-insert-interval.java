class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
        ArrayList<int[]> res=new ArrayList<>();
        
        //adding nonoverlapping intervals
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            res.add(intervals[i++]);
        }
        
        //merging intervals
        int[] interval=newInterval;
        while(i<intervals.length && intervals[i][0]<=interval[1]){
            interval[0]=Math.min(intervals[i][0],interval[0]);
            interval[1]=Math.max(intervals[i][1],interval[1]);
            i++;
        }
        res.add(interval);
        
        //adding rest non overlapping intervals....
        while(i<intervals.length){
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
class Solution1 {
    //nlogn
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list=new ArrayList();
        
        for(int i=0;i<intervals.length;i++){
            list.add(intervals[i]);
        }
        list.add(newInterval);
        
        Collections.sort(list,(a,b)->{
           return a[0]-b[0]; 
        });
        
        ArrayList<int[]> ans=new ArrayList();
        for(int i=0;i<list.size();i++){
            if(i==0){
                ans.add(list.get(i));
            }else{
                int[] top=ans.get(ans.size()-1);
                if(top[1]>=list.get(i)[0]){
                    top[1]=Math.max(list.get(i)[1],top[1]);// remeber interval can also be [1,4][2,3] ..hence math.max
                }else{
                    ans.add(list.get(i));
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}