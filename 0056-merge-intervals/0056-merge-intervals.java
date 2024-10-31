class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n = intervals.length;
        List<int[]> arr = new ArrayList();
        arr.add(intervals[0]);
        
        for(int i=1;i<n;i++){
            int[] interval = arr.get(arr.size()-1);
            if(interval[1]>=intervals[i][0]){
                interval[1] = Math.max(intervals[i][1], interval[1]);
            }else{
                arr.add(intervals[i]);
            }
        }
        return arr.toArray(new int[arr.size()][2]);
    }
}