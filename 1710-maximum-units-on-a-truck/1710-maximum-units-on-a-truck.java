class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->{
            return b[1]-a[1];
        });
        
        int maxUnits=0;
        for(int[] box:boxTypes){
            int load=box[1];
            int units=box[0];
            if(units>truckSize){
                maxUnits+=truckSize*load;
                truckSize=0;
            }else{
                maxUnits+=units*load;
                truckSize-=units;
            }
        }
        return maxUnits;
    }
}