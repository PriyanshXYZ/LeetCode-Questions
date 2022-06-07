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
    
    int idx=0;
    public TreeNode recoverFromPreorder(String s) {
        TreeNode root=dfs(s,0);
        return root;
    }
    public TreeNode dfs(String s,int depth){
        int dash=0;
        while((idx+dash)<s.length() && s.charAt(idx+dash)=='-'){
            dash++;
        }
        if(dash!=depth){
            return null;
        }
        //for finding the value of node in terms of idx
        int nondash=0;
        while((idx+dash+nondash)<s.length() && s.charAt(idx+dash+nondash)!='-'){
            nondash++;
        }
        
        int val=Integer.parseInt(s.substring(idx+dash,idx+dash+nondash));
        TreeNode root=new TreeNode(val);
        
        //update index with visited index
        idx=idx+dash+nondash;
        
        
        root.left=dfs(s,depth+1);
        root.right=dfs(s,depth+1);
        
        return root;
    }
}