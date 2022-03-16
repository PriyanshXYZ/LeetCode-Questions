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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //using one Queue only
        Queue<TreeNode> q=new ArrayDeque();
        List<List<Integer>> ans=new ArrayList();
        if(root==null) return new ArrayList();
        q.add(root);
        int level=1;
        while(q.size()>0){
            int size=q.size();
           
            List<Integer> currlvl=new ArrayList();
                for(int i=0;i<size;i++){
                    TreeNode rnode=q.remove();
                    currlvl.add(rnode.val);    
        
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);
                }
            if(level%2==0){
                Collections.reverse(currlvl);
            }
            ans.add(currlvl);
            level++;
            }
        return ans;
        }
    }
