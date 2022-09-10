class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int hac=0;
        int lac=Integer.MIN_VALUE;
        
        for(int i=0;i<weights.length;i++){
            hac+=weights[i];
            lac=Math.max(lac,weights[i]);
        }
        
        while(lac<hac){
            int limit=(hac+lac)/2;
            
            int partitions=getPartitions(weights,limit);
            
            
            if(partitions>days){
                lac=limit+1;
            }else {
                hac=limit;
            }
        }
        return lac;
    }
    private int getPartitions(int[] weights,int limit){
        int partition = 1;
        int currPartWt = 0;
        for(int wt:weights){
            if(currPartWt + wt <= limit ){
                currPartWt+=wt;
            }else{
                currPartWt=wt;
                partition++;
            }
        }
        return partition;
    }
}