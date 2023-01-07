class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int cumulativeGas=0;
        int n=gas.length;
        
        int startPt=0;
        for(int i=0;i<n;i++){
            totalGas+=gas[i]-cost[i];
            
            cumulativeGas+=gas[i]-cost[i];
            
            if(cumulativeGas<0){
                cumulativeGas=0;
                startPt=i+1;
            }
        }
        
        if(totalGas>=0)return startPt;
        return -1;
    }
}