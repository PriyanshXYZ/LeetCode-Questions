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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        return morrisTraversal(root);
    }
    public List<Integer> dfs(TreeNode root){
        List<Integer> res=new ArrayList();
        if(root==null)return new ArrayList();
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
    public List<Integer> morrisTraversal(TreeNode root){
        if(root==null)return new ArrayList();
        List<Integer> ans=new ArrayList();
        TreeNode curr=root;
        
        while(curr!=null){
            
            if(curr.left==null){
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
                    ans.add(curr.val);
                    inorderPred.right=curr;//making of thread/link to inorderSuccessor
                    curr=curr.left;
                }else{
                    
                    inorderPred.right=null;
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}