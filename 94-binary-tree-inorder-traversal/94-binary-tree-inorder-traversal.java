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
        return morrisTraversal(root);
    }
    //Time complexity O(n) space Complexity O(1);
    public List<Integer> morrisTraversal(TreeNode root){
        if(root==null)return new ArrayList();
        List<Integer> ans=new ArrayList();
        TreeNode curr=root;
        
        while(curr!=null){
            if(curr.left==null){
                //print or changes in the code must be implemented here itself
                ans.add(curr.val);
                curr=curr.right;
            }else{
                //check if inorderPredecessor is null or equal to curr node
                TreeNode inorderPred=curr.left;
                while(inorderPred.right!=null && inorderPred.right!=curr){
                    inorderPred=inorderPred.right;
                }
                //if inorderPredecessor is null meaning we have not visited left subtree
                if(inorderPred.right==null){
                    inorderPred.right=curr;//making of thread/link to inorderSuccessor
                    curr=curr.left;
                }else{
                    //print or changes in the code must be implemented here itself
                    ans.add(curr.val);
                    inorderPred.right=null;
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
    //Time complexity O(n) space Complexity O(n);
    public void dfs(TreeNode root,List<Integer> a){
        if(root==null) return;
        dfs(root.left,a);
        a.add(root.val);
        dfs(root.right,a);
    }
    //Time complexity O(n) space Complexity O(n);
    public List<Integer> Bfs(TreeNode root) {
        if(root==null) return new ArrayList();
        List<Integer> a=new ArrayList();
        Stack<TreeNode> stk=new Stack();
        TreeNode curr=root;
        while(curr!=null || stk.size()>0){
            while(curr!=null){
                stk.push(curr);
                curr=curr.left;
            }
            curr=stk.pop();
            a.add(curr.val);
            curr=curr.right;
        }
        return a;
    }
}