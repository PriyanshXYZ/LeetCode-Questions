class Solution {
    int count=0;
    public int totalNQueens(int n) {
        recursion(n,new boolean[n][n],0,0);
        return count;
    }
    public void recursion(int n,boolean[][] board,int row,int col){
        //base case
        if(row==n){
            count++;
            return;
        }
        
        for(int c=0;c<n;c++){
            if(!hasQueens(board,row,c)){
                board[row][c]=true;
                recursion(n,board,row+1,c);
                board[row][c]=false;
            }
        }
    }
    public boolean hasQueens(boolean[][] board,int row,int col){
        //checking in column
        for(int r=0;r<row;r++){
            if(board[r][col]==true){
                return true;
            }
        }
        
        //for up left diagnal
        int r=row;
        int c=col;
        while(r>=0 && c>=0){
            if(board[r][c]==true){
                return true;
            }
            r--;
            c--;
        }
        
        //for up right diagonal
        r=row;
        c=col;
        while(r>=0 && c<board.length){
            if(board[r][c]==true){
                return true;
            }
            r--;
            c++;
        }
        return false;
    }
}