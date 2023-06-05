class Solution {
    public boolean checkStraightLine(int[][] c) {
        if(c.length==2)return true;
        
        
        for(int i=2;i<c.length;i++){
            int a = (c[i-1][0]-c[0][0])*(c[i][1]-c[0][1]);
            int b = (c[i-1][1]-c[0][1])*(c[i][0]-c[0][0]);
            if(a!=b)return false;
        }
        return true;
    }
}