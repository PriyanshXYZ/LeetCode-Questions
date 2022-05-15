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
    int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        // return bfs(root);
        int depth= depth(root);
        // System.out.println(depth);
        dfs(root,depth);
        return sum;
    }
    public int depth(TreeNode root){
        if(root==null)return 0;
        
        int lch=depth(root.left);
        int rch=depth(root.right);
        
        return Math.max(lch,rch)+1;
    }
    public void dfs(TreeNode root,int depth){
        if(root==null)return;
        if(depth==1){
            sum+=root.val;
            return;
        }
        
        dfs(root.left,depth-1);
        dfs(root.right,depth-1);
        
    }
    public int bfs(TreeNode root){
        if(root==null)return 0;
        
        Queue<TreeNode> q=new ArrayDeque();
        q.add(root);
        int levelsum=0;
        while(q.size()>0){
            levelsum=0;
            int size=q.size();
            while(size-- >0){
                TreeNode rnode=q.remove(); 
                levelsum+=rnode.val;
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);
            }
        }
        return levelsum;
    }
}