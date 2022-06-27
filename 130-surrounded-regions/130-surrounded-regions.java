class Solution {
    public void solve(char[][] board) {
        //mark the border 0's component as true.
        //then we check inside the grid if there is a possibility of getting other component then we make it X
        int n=board.length;
        int m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        
        //checking boundary
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                dfs(board,vis,i,0,'O');
            }
            if(board[i][m-1]=='O'){
                dfs(board,vis,i,m-1,'O');
            }
        }
        for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                dfs(board,vis,0,j,'O');
            }
            if(board[n-1][j]=='O'){
                dfs(board,vis,n-1,j,'O');        
            }
        }
        
        for(int r=1;r<n-1;r++){
            for(int c=1;c<m-1;c++){
                if(board[r][c]=='O' && vis[r][c]==false){
                    dfs(board,vis,r,c,'X');
                }
            }
        }
    }
    
    int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
    private void dfs(char[][] graph,boolean[][] vis,int r,int c,char ch){
        if(r<0 || c<0 || r>=graph.length || c>=graph[0].length || vis[r][c]==true || graph[r][c]=='X')return;
        
        graph[r][c]=ch;
        vis[r][c]=true;
        for(int[] dir : dirs){
            int x=r+dir[0];
            int y=c+dir[1];
            
            dfs(graph,vis,x,y,ch);
        }
    }
}