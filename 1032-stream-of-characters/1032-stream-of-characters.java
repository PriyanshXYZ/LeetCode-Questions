class StreamChecker {
    class Trie{
        boolean isWord=false;
        Trie[] children=new Trie[26];
    }
    Trie root;
    public StreamChecker(String[] words) {
        root=new Trie();
        
        for(String word:words){
            Trie curr=root;
            for(int i=word.length()-1;i>=0;i--){
                char ch=word.charAt(i);
                
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a']=new Trie();
                }
                curr=curr.children[ch-'a'];
            }
            curr.isWord=true;        
        }
    }
    Trie curr;
    StringBuilder sb=new StringBuilder();
    public boolean query(char letter) {
        sb.append(letter);
        
        Trie node=root;        
        for(int i=sb.length()-1;i>=0 && node!=null;i--){
            char ch=sb.charAt(i);
            node=node.children[ch-'a'];
            if(node!=null && node.isWord){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */