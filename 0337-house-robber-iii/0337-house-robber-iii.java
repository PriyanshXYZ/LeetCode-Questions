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
    public int rob(TreeNode root) {
        if(root.left ==null && root.right==null)return root.val;
        
        // return Math.max(dfs(root,0),dfs(root,1));//0=> taking root  1=> not taking root;
        int[] res=optimal(root);
        return Math.max(res[0],res[1]);
    }
    public int[] optimal(TreeNode root){
        if(root==null)return new int[2];
        
        int[] left=optimal(root.left);
        int[] right=optimal(root.right);
        
        int[] curr=new int[2];
        curr[1]=root.val;
        curr[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);//not take curr val
        curr[1]+=left[0]+right[0];
        // System.out.println(curr[0]+" "+curr[1]);
        return curr;
    }
    //Exponentail 4^n
    public int dfs(TreeNode root,int flag){
        if(root==null)return 0;
        
        int ans=0;
        if(flag==1){//not taking curr val
            ans=dfs(root.left,0)+dfs(root.right,0);
        }else{// taking curr val
            int left=dfs(root.left,1);
            int right=dfs(root.right,1);
            
            int take=left+right+root.val;
            int notTake=dfs(root.left,0)+dfs(root.right,0);
            ans=Math.max(take,notTake);
        }
        
        return ans;
    }
}