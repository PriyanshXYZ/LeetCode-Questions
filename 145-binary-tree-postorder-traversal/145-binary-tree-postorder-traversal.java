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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        // List<Integer> ans=new ArrayList();
        // postorderTraversal(root,ans);
        return bfs(root);
    }
    public void postorderTraversal(TreeNode root,List<Integer> ans) {
        if(root==null) return;
        postorderTraversal(root.left,ans);
        postorderTraversal(root.right,ans);
        ans.add(root.val);
        
    }
    public List<Integer> bfs(TreeNode root) {
        if(root==null) return new ArrayList();
        List<Integer> ans=new ArrayList();
        Stack<TreeNode> stk=new Stack();
        TreeNode curr=root;
        while(curr!=null || stk.size()>0){
            while(curr!=null){
               
                stk.push(curr);
                ans.add(0,curr.val);//reverse the process
                curr=curr.right;//reverse the process
            }
            curr=stk.pop();
            curr=curr.left;//reverse the process
        }
        return ans;
    }
}