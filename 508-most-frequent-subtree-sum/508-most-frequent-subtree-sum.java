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
    HashMap<Integer,Integer> map=new HashMap();
    int maxFreq;
    public int[] findFrequentTreeSum(TreeNode root) {
        maxFreq=0;
        dfs(root);
        
        List<Integer> list=new ArrayList();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==maxFreq){
                list.add(entry.getKey());
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    
    public int dfs(TreeNode root){
        if(root==null)return 0;
        
        int leftSum=dfs(root.left);
        int rightSum=dfs(root.right);
        
        int subtreeSum=leftSum+rightSum+root.val;
        map.put(subtreeSum,map.getOrDefault(subtreeSum,0)+1);
        if(map.get(subtreeSum)>maxFreq){
            maxFreq=map.get(subtreeSum);
        }
        return subtreeSum;
    }
}