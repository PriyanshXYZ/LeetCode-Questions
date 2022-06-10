/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { 
            this.val = val; 
        }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1 {
    class Pair{
        int nodes;
        int coins;
    }
    int moves=0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }
    public Pair helper(TreeNode root){
        //base case 
        if(root==null)return new Pair();
        
        Pair lp=helper(root.left);
        Pair rp=helper(root.right);
        
        Pair currPair=new Pair();
        currPair.nodes=lp.nodes+rp.nodes+1;
        currPair.coins=lp.coins+rp.coins+root.val;
        
        moves+=Math.abs(currPair.nodes-currPair.coins);
        return currPair;
    }
}
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        moves=0;
        dfs(root);
        return moves;
    }
    public int dfs(TreeNode root){
        if(root==null)return 0;
        
        int left=dfs(root.left);
        int right=dfs(root.right);
        
        moves+=Math.abs(left)+Math.abs(right);
        return left+right+root.val-1;
    }
}