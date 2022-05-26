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
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    //sol 1 using return type
    private int dfs(TreeNode root,int  currSum){
        if(root==null)return 0;
        currSum=currSum*10+root.val;
        if(root.left==null && root.right==null){
          return currSum;
        }
        
        int leftSum=dfs(root.left,currSum);
        int rightSum=dfs(root.right,currSum);
        return leftSum+rightSum;
    } 
}
//sol2 using static variable
class Solution2 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    
    private void dfs(TreeNode root,int  currSum){
        if(root==null)return;
        currSum=currSum*10+root.val;
        if(root.left==null && root.right==null){
           sum+=currSum;
        }
        
        dfs(root.left,currSum);
        dfs(root.right,currSum);
        
    } 
}
//sol3 using list to store String value =>brute force
class Solution3 {
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
