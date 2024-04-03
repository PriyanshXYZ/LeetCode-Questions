class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(i, j, 0, board, word, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i, int j,int idx, char[][] board, String word, boolean[][] vis) {
        //base case
        if(idx == word.length())return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || vis[i][j] == true || word.charAt(idx) != board[i][j]) {
            return false;
        }
        vis[i][j] = true;
        
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            
            
            if(dfs(x, y, idx + 1, board, word, vis))return true;
        }
        vis[i][j] = false;
        return false;
    }
}