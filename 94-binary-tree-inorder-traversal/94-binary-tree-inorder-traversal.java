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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList();
        
        helper(root,ans);
        return ans;
    }
    public void helper(TreeNode root,List<Integer> a){
        if(root==null) return;
        helper(root.left,a);
        a.add(root.val);
        helper(root.right,a);
    }
    // //using bfs
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if(root==null) return new ArrayList();
    //     List<Integer> a=new ArrayList();
    //     Stack<TreeNode> stk=new Stack();
    //     TreeNode curr=root;
    //     while(curr!=null || stk.size()>0){
    //         while(curr!=null){
    //             stk.push(curr);
    //             curr=curr.left;
    //         }
    //         curr=stk.pop();
    //         a.add(curr.val);
    //         curr=curr.right;
    //     }
    //     return a;
    // }
}