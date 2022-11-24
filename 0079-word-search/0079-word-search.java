class Solution {
    int[][] dirs={{0,-1},{0,1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        boolean flag=false;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                flag=dfs(r,c,0,word,board,vis);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int r,int c,int idx,String s,char[][] board,boolean[][] vis){
        if(idx==s.length()){
            return true;
        }
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || s.charAt(idx)!=board[r][c] || vis[r][c]){
            return false;
        }
        
        vis[r][c]=true;
        char ch=s.charAt(idx);
        boolean ans=false;
        for(int[] dir:dirs){
            int x=r+dir[0];
            int y=c+dir[1];
            ans|=dfs(x,y,idx+1,s,board,vis);
            if(ans)return  true;
        }
        vis[r][c]=false;
        return false;
        
    }
}