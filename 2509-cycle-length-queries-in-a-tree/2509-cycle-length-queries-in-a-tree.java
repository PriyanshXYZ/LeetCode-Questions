class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
            res[i]++;
            int x=queries[i][0];
            int y=queries[i][1];
            
            while(x != y){
                if(x > y){
                    x = x / 2;
                }else
                    y = y / 2;
                res[i]++;
            }
        }
        return res;
    }
}