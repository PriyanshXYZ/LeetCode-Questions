class MapSum {
    class Node{
        boolean end=false;
        int val=0;
        Node[] children=new Node[26];
    }
    
    
    Node root;
    public MapSum() {
        root=new Node();
    }
    
    public void insert(String key, int val) {
        Node node=root;
        for(char ch:key.toCharArray()){
            if(node.children[ch-'a']==null)node.children[ch-'a']=new Node();
            node=node.children[ch-'a'];
        }
        node.end=true;
        node.val=val;
    }
    public void dfs(Node node){
        sum+=node.val;
        for(int i=0;i<26;i++){
            Node child=node.children[i];
            if(child!=null){
                dfs(child);
            }
        }
    }
    
    int sum;
    public int sum(String prefix) {
        Node node=root;
        for(char ch:prefix.toCharArray()){
            if(node.children[ch-'a']==null)return 0;
            node=node.children[ch-'a'];
        }
        
        sum=0;
        
        dfs(node);
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */