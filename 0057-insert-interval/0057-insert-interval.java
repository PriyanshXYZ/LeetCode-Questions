class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int idx = 0;
        int n =intervals.length;
        while(idx<n && newInterval[0]>intervals[idx][1]){
            res.add(intervals[idx]);
            idx++;
        }
        
        //merging the new interval
        while(idx<n && newInterval[1]>=intervals[idx][0]){
            newInterval[0] = Math.min(intervals[idx][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1],newInterval[1]);
            idx++;
        }
        
        res.add(newInterval);
        while(idx<n){
            res.add(intervals[idx]);
            idx++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}