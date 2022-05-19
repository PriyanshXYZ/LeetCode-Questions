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
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        // inorderDfs(root);
        morrisTraversal(root);
        swap(first,second);
        
    }
    public void swap(TreeNode n1,TreeNode n2){
        int temp=n1.val;
        n1.val=n2.val;
        n2.val=temp;
    }
    public void morrisTraversal(TreeNode root){
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                
                if(prev!=null){
                    if(curr.val<=prev.val){
                        //in case we get curr node smaller than prev node we update first
                        if(first==null){
                            first=prev;
                        }
                        // when first is already found and we get smaller node than prev
                        second=curr;
                        }
                    }
                prev=curr;
                curr=curr.right;
            }else{
                //iop=>inorderPredecessor
                TreeNode iop=curr.left;
                while(true){
                    if(iop.right==null)break;
                    if(iop.right==curr)break;
                    iop=iop.right;
                }
                if(iop.right==null){
                    iop.right=curr;//make the link with successor
                    curr=curr.left;//start traveesing to left of subtree
                }else{
                    if(prev!=null){
                    if(curr.val<=prev.val){
                        //in case we get curr node smaller than prev node we update first
                        if(first==null){
                            first=prev;
                        }
                        // when first is already found and we get smaller node than prev
                        second=curr;
                        }
                    }
                    prev=curr;
                    iop.right=null;
                    curr=curr.right;
                }
            }
        }
    }

    public void inorderDfs(TreeNode root){
        if(root==null) return;
        
        inorderDfs(root.left);
        //in case we get curr node smaller than prev node we update first
        if(prev!=null){
            if(first==null && root.val<=prev.val){
                first=prev;
            }
        }
        // when first is already found and we get smaller node than prev
        if(first!=null && prev.val>=root.val){
            second=root;
        }
        prev=root;

        inorderDfs(root.right);
        
        return;
    }
}