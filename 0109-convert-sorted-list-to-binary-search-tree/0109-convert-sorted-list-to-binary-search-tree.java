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
    public TreeNode sortedListToBST(ListNode head) {
        //even numbers me balance krna is not possible
        //odd me humhesha hi balance rehega
        if(head==null)return null;
        List<Integer> list = new ArrayList<>();
        
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int n = list.size();
        return dfs(list,0,n-1);
    }
    public TreeNode dfs(List<Integer> list , int left, int right){
        if(left>right)return null;
        if(left==right)return new TreeNode(list.get(right));
        
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(list.get(mid));
        
        root.left = dfs(list, left , mid - 1);
        root.right = dfs(list, mid + 1, right);
        return root;
    }
}