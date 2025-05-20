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
    Map<Node,Node> vis = new HashMap();
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        if(node.neighbors == null)return new Node(node.val);
        Node clonedNode = new Node(node.val);
        
        dfs(clonedNode, node);
        return clonedNode;
    }

    private void dfs(Node clonedNode, Node node) {
        vis.put(node,clonedNode);
        List<Node> clonedNeighbors = new ArrayList();
        for(Node nbr : node.neighbors){
            if(vis.containsKey(nbr)){
                clonedNeighbors.add(vis.get(nbr));
            }else{
                Node clonedNbr = new Node(nbr.val);
                clonedNeighbors.add(clonedNbr);
                dfs(clonedNbr, nbr);
            }
        }
        // clonedNode.val = node.val;
        clonedNode.neighbors = clonedNeighbors;
    }
}