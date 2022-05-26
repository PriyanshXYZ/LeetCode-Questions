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
    List<String> list=new ArrayList();
    public int sumNumbers(TreeNode root) {
        dfs(root,"");
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=Integer.parseInt(list.get(i));
        }
        return sum;
    }
    
    private void dfs(TreeNode root,String op){
        if(root==null)return;
        op+=root.val;
        if(root.left==null && root.right==null){
            list.add(op);
        }
        
        dfs(root.left,op);
        dfs(root.right,op);
    } 
}