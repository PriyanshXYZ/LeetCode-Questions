class Solution {
    public int maxSumDistinctTriplet(int[] X, int[] Y) {
        // we have to get 3 distinct number which are giving maximum sum in other array at same index
        int n = X.length;
        TreeMap<Integer,Integer> xToMaxY = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            if(!xToMaxY.containsKey(X[i])){ 
                xToMaxY.put(X[i],0);
            }
            int max = Math.max(Y[i], xToMaxY.get(X[i]));
            xToMaxY.put(X[i],max);
        }

        if(xToMaxY.size()<3)return -1;

        int x = 0, y=0, z=0;
        for(int val : xToMaxY.values()) {
            if(val>x){
                z = y;
                y = x;
                x = val;
            }else if(val>y) {
                z = y;
                y = val;
            }else if(val>z) {
                z = val;
            }
        }
        return x + y + z;
    }
}