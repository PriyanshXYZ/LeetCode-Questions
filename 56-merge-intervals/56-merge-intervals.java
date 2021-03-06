class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        ArrayList<int[]> ans=new ArrayList();
        for(int i=0;i<intervals.length;i++){
            if(i==0){
                ans.add(intervals[i]);
            }else{
                int[] top=ans.get(ans.size()-1);
                if(top[1]>=intervals[i][0]){
                    top[1]=Math.max(intervals[i][1],top[1]);// remeber interval can also be [1,4][2,3] ..hence math.max
                }else{
                    ans.add(intervals[i]);
                }
            }
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}