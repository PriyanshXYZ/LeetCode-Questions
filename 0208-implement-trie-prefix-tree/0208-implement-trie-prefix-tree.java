class Trie {
    class Node{
        Node[] child = new Node[26];
        boolean isEnd = false;
    }
    Node root; 
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            if(node.child[ch-'a']==null){
                node.child[ch-'a']=new Node();
            }
            node = node.child[ch-'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            if(node.child[ch-'a']==null){
                return false;
            }
            node = node.child[ch-'a'];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch : prefix.toCharArray()){
            if(node.child[ch-'a']==null)return false;
            node=node.child[ch-'a'];
        }
        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */