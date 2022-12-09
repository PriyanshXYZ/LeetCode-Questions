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
    int maxDiff;
    public int maxAncestorDiff(TreeNode root) {
        maxDiff=0;
        dfs(root,new ArrayList());
        return maxDiff;
    }
    public void dfs(TreeNode root, List<Integer> list){
        if(root==null)return;
        int maxNum=root.val;
        int minNum=root.val;
        for(int i=0;i<list.size();i++){
            maxNum=Math.max(maxNum, list.get(i));
            minNum=Math.min(minNum,list.get(i));
        }
        maxDiff=Math.max(Math.abs(maxNum-root.val),maxDiff);
        maxDiff=Math.max(Math.abs(minNum-root.val),maxDiff);
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
        list.remove(list.size()-1);
    }
}