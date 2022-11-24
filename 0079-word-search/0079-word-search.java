class Solution {
    int[][] dirs={{0,-1},{0,1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {
        if(word.length() > board[0].length * board.length)
            return false;
        
        Set<Character> hs1 = new HashSet<Character>();
        Set<Character> hs2 = new HashSet<Character>();
        
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                    hs1.add(board[i][j]);
        
        for(int i=0;i<word.length();i++)
                hs2.add(word.charAt(i));
        
        if(hs2.size()>hs1.size())
            return false;
        
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        boolean flag=false;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(dfs(r,c,0,word,board,vis))
                    return true;
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
            if(dfs(x,y,idx+1,s,board,vis))
                return  true;
        }
        vis[r][c]=false;
        return false;
        
    }
}