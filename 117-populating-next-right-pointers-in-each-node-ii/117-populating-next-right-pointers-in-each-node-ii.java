/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    //O(n) time and O(1) space
    public Node connect(Node root){
        Node start=root;
        
        while(start!=null){
            Node curr=start;
            Node nextLevelHead=null;
            Node prev=null; 
            while(curr!=null){
                    if(curr.left!=null){
                    if(prev!=null){
                        prev.next=curr.left;
                    }
                    prev=curr.left;
                    if(nextLevelHead==null){
                        nextLevelHead=curr.left;
                    }
                }
                if(curr.right!=null){
                    if(prev!=null){
                        prev.next=curr.right;
                    }
                    prev=curr.right;
                    if(nextLevelHead==null){
                        nextLevelHead=curr.right;
                    }
                }
                curr=curr.next;
            }
            start=nextLevelHead;
        }
        return root;
    }
    //O(n) time and space complexity
    public Node connect1(Node root) {
        if(root==null)return root;
        Queue<Node> q=new ArrayDeque();
        q.add(root);
        Node prev=null;
        while(q.size()!=0){
            int size=q.size();
            Node rnode=null;
            while(size-->0){
                rnode=q.remove();
                rnode.next=q.peek();
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);
            }
            if(rnode!=null)rnode.next=null;
            prev=null;
        }
        return root;
    }
}