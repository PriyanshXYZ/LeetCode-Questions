/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean hasList;
    public void find(TreeNode root,ListNode head){
        if(root==null)return;
        
        if(root.val==head.val){
            hasList|=dfs(root,head);
            
        }
        find(root.left,head);
        find(root.right,head);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        hasList=false;
        //1. find the head in tree
        find(root,head);
        //2. compare both level wise or apply dfs
        return hasList;
        
    }
    
    public boolean dfs(TreeNode node,ListNode head){
        if(head==null)return true;
        if(node==null)return false;
        
        if(head.val==node.val){
            boolean inLeft=dfs(node.left,head.next);
            boolean inRight=dfs(node.right,head.next);
            return inLeft || inRight;
        }
        return false;
        
    }
}