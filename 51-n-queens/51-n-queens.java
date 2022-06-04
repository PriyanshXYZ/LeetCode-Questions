class Solution {
    List<List<String>> ans=new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        recursion(n,new boolean[n][n],0,0);
        return ans;
    }
    
    public void recursion(int n,boolean[][] chess,int row,int col){
        //base case
        
        if(row==chess.length){
            List<String> list=new ArrayList();
            for(int r=0;r<n;r++){
                String str=getQueens(chess,r);
                list.add(str);
            }
            ans.add(new ArrayList(list));
            return;
        }
        
        for(int c=0;c<n;c++){
            if(isQueenSafe(chess,c,row)){
                chess[row][c]=true;//edge pre
                recursion(n,chess,row+1,c);
                chess[row][c]=false;///edge post
            }
                
        }
        /*
            here we did edge pre and edge post beacuse after each traversal of element we have to move to next element so prevoius  element should not be marked true so we do here edge pre and edge post INSTEAD OF NODE PRE AMD NODE POST
        */
        
    }
    
    public boolean isQueenSafe(boolean[][] chess,int col,int row){
        for(int r=0;r<row;r++){
            if(chess[r][col]){
                return false;
            }
        }
        //left diagonal check
        int r=row,c=col;
        while(r>=0 && c>=0){
            if(chess[r][c]){
                return false;
            }
            r--;
            c--;
        }
        r=row;
        c=col;
        //right diagonal check
        while(r>=0 && c<chess[0].length){
            if(chess[r][c]){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    public String getQueens(boolean[][] chess,int row){
        String str="";
        for(int c=0;c<chess[0].length;c++){
            if(chess[row][c]){
                str+="Q";
            }else{
                str+=".";
            }
        }
        return str;
    }
    
}