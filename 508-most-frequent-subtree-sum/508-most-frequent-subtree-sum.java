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
    int maxFreq;
    public int[] findFrequentTreeSum(TreeNode root) {
        maxFreq=0;
        Map<Integer,Integer> map=new HashMap();
        dfs(root,map);
        List<Integer> list=new ArrayList();
        for(int sum:map.keySet()){
            int freq=map.get(sum);
            if(freq==maxFreq){
                list.add(sum);
            }
        }
        
        int[] freq=new int[list.size()];
        int i=0;
        for(int sum: list){
            freq[i]=sum;
            i++;
        }
        return freq;
    }
    
    public int dfs(TreeNode root,Map<Integer,Integer> map){
        if(root==null)return 0;
        
        int leftSum=dfs(root.left,map);
        int rightSum=dfs(root.right,map);
        
        int currSum=leftSum+rightSum+root.val;
        map.put(currSum,map.getOrDefault(currSum,0)+1);
        if(map.get(currSum)>maxFreq){
            maxFreq=map.get(currSum);
        }
        return currSum;
    }
}