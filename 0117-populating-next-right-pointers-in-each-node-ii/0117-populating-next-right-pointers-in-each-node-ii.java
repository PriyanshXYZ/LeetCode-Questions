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
    public Node connect(Node root) {
        
        Node head = root;
        
        while(head!=null) { // parent level head = head.next
            // dummy node
            Node dummy = new Node(-1);
            Node tail = dummy;
            //connect children
            while(head != null){ // consider head the ll nodes (parent level)
                // consider head as parent nodes and connect the left & right with tails next
                if(head.left!=null){
                    tail.next = head.left;
                    tail = tail.next;
                }
                if(head.right!=null) {
                    tail.next = head.right;
                    tail = tail.next;
                }
                head = head.next;
            }
            head = dummy.next; // 1 -----> 2
        }
        return root;
    }
}
/*
  root = [1,2,3,4,5,null,7]
  
             1   h 1 p null 
        2   >    3      h = h.left p = null -> h.next
    4      5         7
    
    head = prev --> prev.next
    prev -> null > 2   => 2 > 3
    
    head.left?       head.right
    prev -> 
*/ 