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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList();
        
        dfs(root,targetSum,0,new ArrayList());
        return ans;
    }
    
    public void dfs(TreeNode root , int target, int curr,List<Integer> path){
        if(root==null)return;
        
        if(root.left==null && root.right==null ){
            if(target==curr+root.val){
                List<Integer> base=new ArrayList();
                base.addAll(path);
                base.add(root.val);
                ans.add(base);
            }
            return;
        }
        path.add(root.val);
        curr+=root.val;
        dfs(root.left, target,curr,path);
        if(path.size()>0)
            path.remove(path.size()-1);
        
        path.add(root.val);
        dfs(root.right, target,curr,path);
        
        if(path.size()>0)
            path.remove(path.size()-1);
        
        return;
    }
}