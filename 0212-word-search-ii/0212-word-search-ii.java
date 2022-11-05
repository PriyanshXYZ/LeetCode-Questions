class Solution {
    class Trie{
        String word;
        Trie[] children=new Trie[26];
    }
    
    private Trie build(Trie root,String[] words){
        root=new Trie();
        for(String word:words){
            Trie node=root;
            for(char ch:word.toCharArray()){
                if(node.children[ch-'a']==null){
                    node.children[ch-'a']=new Trie();
                }
                node=node.children[ch-'a'];
            }
            node.word=word;
        }
        return root;
    }
    
    
    Set<String> ans=new HashSet();
    public List<String> findWords(char[][] board, String[] words) {
        int n=board.length;
        int m=board[0].length;
        Trie root=new Trie();
        root=build(root,words);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean[][] vis=new boolean[n][m];
                dfs(i,j,root,board,vis);
            }
        }
        return new ArrayList(ans);
    }
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    
    private void dfs(int r,int c,Trie root,char[][] board,boolean[][] vis){
        if(r<0 || c<0 || c>=board[0].length || r>=board.length)return;
        
        char ch=board[r][c];
        
        if(vis[r][c]==true || root.children[ch-'a']==null)return;
        
        root=root.children[ch-'a'];
        
        if(root.word!=null){
            ans.add(root.word);
        }
        for(int[] dir:dirs){
            int x=r+dir[0];
            int y=c+dir[1];
            
            vis[r][c]=true;
            dfs(x,y,root,board,vis);
            vis[r][c]=false;   
        }
    }
}