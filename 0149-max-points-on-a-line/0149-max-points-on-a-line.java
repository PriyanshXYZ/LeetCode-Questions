class Solution {
    public int maxPoints(int[][] points) {
        
        int maxInLine=1;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> map = new HashMap<>();
            for(int j= i+1 ; j< points.length; j++){
                int x1 = points[i][0], x2 = points[j][0];
                int y1 = points[i][1], y2 = points[j][1];
                double slope = calcSlope( x1, x2, y1, y2);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                
                maxInLine = Math.max(maxInLine , map.get(slope));
            }
        }
        
        return maxInLine;
    }
    public double calcSlope(int x1, int x2, int y1 , int y2){
        if(x1==x2)return Double.MAX_VALUE;
        else if(y1==y2)return 0;
        return (double)(y2-y1) / (double)(x2-x1);
    }
}