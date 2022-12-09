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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,root.val,root.val);
    }
    public int dfs(TreeNode root, int min, int max){
        if(root==null)return 0;
        max=Math.max(root.val, max);
        min=Math.min(root.val, min);
        int left=dfs(root.left, min, max);
        int right=dfs(root.right, min, max);
        return Math.max(left,Math.max(right,max-min));
    }
}
class Solution1 {
    //o(nlogn) solution
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