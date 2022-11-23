class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            HashSet<Character> row=new HashSet();
            HashSet<Character> col=new HashSet();
            HashSet<Character> cube=new HashSet();
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                char ch1=board[j][i];
                if(ch!='.'){
                    if(!row.add(ch)){
                        return false;
                    }
                }
                if(ch1!='.'){
                    if(!col.add(ch1)){
                        return false;
                    }
                }
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
                
            }
        }
        return true;
    }
}