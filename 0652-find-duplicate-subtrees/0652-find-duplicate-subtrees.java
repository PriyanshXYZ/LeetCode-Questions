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
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        ans = new ArrayList<>();
        dfs(root, map);
        // System.out.p
        return ans;
    }
    public String dfs(TreeNode root, HashMap<String, Integer> map){
        if(root==null){
            return "";
        }
        String leftStr = dfs(root.left, map);
        String rightStr = dfs(root.right, map);
        
        String subTreeStr ="(" + leftStr +")"+ root.val + "(" + rightStr+")";
        if(map.containsKey(subTreeStr)){
            
            if(map.get(subTreeStr)==1){
                ans.add(root);
            }
        }
        map.put(subTreeStr,map.getOrDefault(subTreeStr,0)+1);
        return subTreeStr;
    }
}