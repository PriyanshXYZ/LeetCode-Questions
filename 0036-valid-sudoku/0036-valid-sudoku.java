class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9)
            return false;
        boolean[][] row_seen = new boolean[9][9], col_seen = new boolean[9][9];
        boolean[][][] small_seen = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            
            if (board[i].length != 9) return false;
            
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if (digit == '.') continue;
                
                int index = digit - '0' - 1;
                
                if (row_seen[i][index]) return false;
                
                row_seen[i][index] = true;
                
                if (col_seen[j][index]) return false;
                
                col_seen[j][index] = true;
                
                int x = i / 3, y = j / 3;
                
                if (small_seen[x][y][index]) return false;
                
                small_seen[x][y][index] = true;
            }
        }
        return true;
    }
}