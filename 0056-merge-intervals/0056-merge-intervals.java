class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        
        List<int[]> ans=new ArrayList<>();
        
        for(int i=0;i<intervals.length;i++){
            if(i==0){
                ans.add(intervals[i]);
            }else{
                int[] top=ans.get(ans.size()-1);
                if(top[1]>=intervals[i][0]){
                    top[1]=Math.max(top[1],intervals[i][1]);
                }else{
                    ans.add(intervals[i]);
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}