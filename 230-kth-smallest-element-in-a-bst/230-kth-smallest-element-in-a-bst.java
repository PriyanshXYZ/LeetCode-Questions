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
/*
public int min(TreeNode root){
        if(root==null)return Integer.MAX_VALUE;
        return Math.min(min(root.left),root.val);
    }
    public int max(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(max(root.right),root.val);
    }
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root==null)return null;
        if(root.val>val){
          root.left=deleteNode(root.left,data);
          return root;
        }else if(root.val<data){
          root.right=deleteNode(root.right,data);
          return root;
        }else{
          //case1
          if(root.left==null && root.right==null){
            return null;
          }
          //case2
          if(root.left==null){
            return root.right;
          }
          if(root.right==null){
            return root.left;
          }
          //case3
          int justSmaller=max(root.left);
          root.val=justSmaller;
          root.left=deleteNode(root.left,justSmaller);
          return root;
        }
    
  }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return Integer.MAX_VALUE;
        while(k-->1){//delete elements only when we need to find 2nd smallet or larger
            root=deleteNode(root,min(root));
        }
        return min(root);
    }
    */
class Solution {
    List<Integer> ans=new ArrayList();
    public List<Integer> dfs(TreeNode root){
        if(root==null)return new ArrayList();
        List<Integer> left=dfs(root.left);
        ans.add(root.val);
        List<Integer> right=dfs(root.right);
        return ans;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res=dfs(root);
        return res.get(k-1);
    }
}