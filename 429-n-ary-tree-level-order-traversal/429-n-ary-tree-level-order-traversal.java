/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null)return new ArrayList();
        Queue<Node> q=new ArrayDeque();
        
        List<List<Integer>> res=new ArrayList();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            List<Integer> curr=new ArrayList();
            while(size-- >0){
                Node rNode=q.remove();
                curr.add(rNode.val);
                for(Node child:rNode.children){
                    q.add(child);
                }
            }
            res.add(curr);
        }
        return res;
    }
}