class WordDictionary {
    class Node{
        boolean end=false;
        Node[] children =new Node[26];
    }
    
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(node.children[ch-'a']==null){
                node.children[ch-'a']=new Node();
            }
            node=node.children[ch-'a'];
        }
        node.end=true;
    }
    public boolean dfs(String word,int idx,Node node){
        if(idx==word.length()){
            return node.end;
        }
        char ch=word.charAt(idx);
        if(ch!='.'){
            Node child=node.children[ch-'a'];
            if(child==null)return false;
            return dfs(word,idx+1,child);
        }else{
            for(int i=0;i<26;i++){
                Node child=node.children[i];
                if(child!=null){
                    boolean res=dfs(word,idx+1,child);
                    if(res)return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean search(String word) {
        return dfs(word,0,root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */