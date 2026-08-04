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
    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        Node clone = new Node(node.val);
        Set<Integer> vis = new HashSet<>();
        
        dfs(clone, node, vis);
        return clone;
    }

    private void dfs(Node clone, Node node, Set<Integer> vis) {
        vis.add(clone.val);
        map.put(node,clone);
        for(Node nbr : node.neighbors) {
            Node cloneNbr;
            if(!vis.contains(nbr.val)) {
                cloneNbr = new Node(nbr.val);
                clone.neighbors.add(cloneNbr);
                dfs(cloneNbr, nbr, vis);
            }else{
                cloneNbr = map.get(nbr);
                clone.neighbors.add(cloneNbr);
            }
        }
    }
}