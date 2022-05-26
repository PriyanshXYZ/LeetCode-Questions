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
    public Node connect1(Node root) {
        Node head=root;
        while(head!=null){
            Node curr=head;
            while(curr!=null){
                if(curr.left!=null){
                    curr.left.next=curr.right;
                }
                if(curr.right!=null && curr.next!=null){
                    curr.right.next=curr.next.left;
                }
                curr=curr.next;
            }
            head=head.left;
        }
        return root;
    }
    public Node connect(Node root){
        if(root==null)return null;
        Queue<Node> q=new ArrayDeque();
        root.next=null;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            Node rnode=null;
            while(size-- >0){
                rnode=q.remove();
                rnode.next=q.peek();
                if(rnode.left!=null){
                    q.add(rnode.left);
                }
                if(rnode.right!=null){
                    q.add(rnode.right);
                }
            }
            if(rnode!=null)rnode.next=null;
        }
        return root;
    }
}