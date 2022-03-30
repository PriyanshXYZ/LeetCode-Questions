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
    public TreeNode searchBST(TreeNode root, int val) {
        return searchBSTusingDFS(root,val);
    }
    public TreeNode searchBSTusingDFS(TreeNode root,int val){
        if(root==null) return null;
        if(root.val==val)return root;
        else if(root.val>val){
            TreeNode lch=searchBST(root.left,val);
            if(lch!=null)return lch;
        }else{
            TreeNode rch=searchBST(root.right,val);
            if(rch!=null)return rch;
        }
        return null;
    }
    public TreeNode searchBSTusingBFS(TreeNode root,int val){
        if(root==null)return null;
        Queue<TreeNode> q=new ArrayDeque();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                TreeNode rnode=q.remove();
                if(rnode.val==val){
                    return rnode;
                }else if(rnode.val>val && rnode.left!=null){
                    q.add(rnode.left);
                }else if(rnode.val<val && rnode.right!=null){
                    q.add(rnode.right);
                }
            }
        }
        return null;
    }
}