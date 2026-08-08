class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if(a[0]!=b[0])
                Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int arrows = 0;
        List<int[]> intervals = new ArrayList();
        for(int[] pt : points) {
            if(intervals.size() ==0){
                arrows++;
                intervals.add(pt);
            }else{
                int[] prevPt = intervals.get(intervals.size() - 1);
                // System.out.println(prevPt[0] + " "+ prevPt[1] + "->" + pt[0] + " " +pt[1]);
                if(prevPt[1] >= pt[0]){ // merge exist and we do not need to throw a new arrow
                    prevPt[0] = pt[0]; //update the previous interval
                }else{
                    intervals.add(pt);
                    arrows++;
                }
            }
        }
        return arrows;
    }
}