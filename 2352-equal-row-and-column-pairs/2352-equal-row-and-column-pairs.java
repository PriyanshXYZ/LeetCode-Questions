class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        HashMap<String, Integer> row = new HashMap<>();
        HashMap<String, Integer> col = new HashMap<>();
        
        for(int i=0;i<n;i++){
            String s = "";
            for(int j=0;j<m;j++){
                s += grid[i][j]+" ";
            }
            row.put(s, row.getOrDefault(s,0)+1);
        }
        
        for(int j=0;j<m;j++){
            String s = "";
            for(int i=0;i<n;i++){
                s += grid[i][j]+" ";
            }
            col.put(s, col.getOrDefault(s,0)+1);
        }
        
        int ans = 0;
        
        for(String s : row.keySet()){
            if(col.containsKey(s)){
                ans += row.get(s) * col.get(s);
            }
        }
        return ans;
    }
}