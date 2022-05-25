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
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        HashMap<Integer,Integer> map=new HashMap();//(prefixSum,frequency)
        map.put(0,1);//here we need to add this because there is a possibility of getting 0 in pSum
        dfs(root,root.val,map,targetSum);
        return count;
    }
    //using O(n^2) appproach
    
    //using O(n) approach
    public void dfs(TreeNode root,int pSum,HashMap<Integer,Integer> map,int target){
        if(map.containsKey(pSum-target)){
            count+=map.get(pSum-target);
        }
        
        if(map.containsKey(pSum)==false){
            map.put(pSum,1);
        }else{
            map.put(pSum,map.get(pSum)+1);
        }
        
        //calls
        if(root.left!=null)
            dfs(root.left,pSum+root.left.val,map,target);
        if(root.right!=null)
            dfs(root.right,pSum+root.right.val,map,target);
        
        if(map.get(pSum)==1){
            map.remove(pSum);
        }else{
            map.put(pSum,map.get(pSum)-1);
        }
        
    }
    
}