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
    List<Integer> path;
    public List<Integer> inorderTraversal(TreeNode root) {
        path = new ArrayList<>();
        // dfs(root);
        //using morris traversal
        TreeNode curr = root;

        while(curr!=null) {
            if(curr.left==null){
                //leaf node case
                path.add(curr.val);
                curr = curr.right;
            }else {

                //find the right most in left subtree
                TreeNode inOrderPredecessor = curr.left; 
                while(true) {
                    if(inOrderPredecessor.right == null) break;
                    if(inOrderPredecessor.right == curr) break;

                    inOrderPredecessor = inOrderPredecessor.right;
                }

                //left subtree is not explored
                if(inOrderPredecessor.right == null) {
                    inOrderPredecessor.right = curr; //create thread
                    curr = curr.left;
                }else if(inOrderPredecessor.right == curr){ //right subtree is 
                    path.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return path;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;

        dfs(root.left);
        path.add(root.val);
        dfs(root.right);
    }
}