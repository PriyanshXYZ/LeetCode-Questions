class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs=new int[startTime.length][3];
        
        for(int i=0;i<jobs.length;i++){
            jobs[i][0]=startTime[i];
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }
        
        Arrays.sort(jobs,(a,b)->{
            return a[1]-b[1];
        });
        
        TreeMap<Integer,Integer> dp=new TreeMap<>();
        dp.put(0,0);
        for(int[] job:jobs){
            int curr=dp.floorEntry(job[0]).getValue()+job[2];
            if(curr>dp.lastEntry().getValue()){
                dp.put(job[1],curr);
            }
        }
        return dp.lastEntry().getValue();
    }
}