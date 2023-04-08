/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        Node[] vis=new Node[101];
        Node clone=dfs(node,vis);
        return clone;
    }
    
    public Node dfs(Node node,Node[] vis){
        Node clone=new Node(node.val);
        vis[node.val]=clone;
        
        for(Node nbr:node.neighbors){
            if(vis[nbr.val]==null){
                Node child=dfs(nbr,vis);
                clone.neighbors.add(child);
            }else{
                clone.neighbors.add(vis[nbr.val]);
            }
        }
        return clone;
    }
}