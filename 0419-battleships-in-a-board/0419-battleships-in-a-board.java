class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'X'){
                    dfs(i,j,board);
                    ans++;
                }
            }
        }
        return ans;
    }
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int i, int j, char[][] board) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='.')return;

        board[i][j] = '.';
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x,y,board);
        }
    }
}