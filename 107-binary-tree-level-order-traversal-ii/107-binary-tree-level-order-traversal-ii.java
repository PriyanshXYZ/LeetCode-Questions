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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            List<List<Integer>> base=new ArrayList();
            return base;
        }
        Queue<TreeNode> q=new ArrayDeque();
        List<List<Integer>> ans=new ArrayList();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            List<Integer> currlvl=new ArrayList();
            while(size-->0){
                TreeNode rnode=q.remove();
                currlvl.add(rnode.val);
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);
            }
            ans.add(currlvl);
        }
        Collections.reverse(ans);
        return ans;
            
    }
    public List<List<Integer>> levelOrderBottom2(TreeNode root){
         if(root==null){
            List<List<Integer>> base=new ArrayList();
            return base;
        }
        Queue<TreeNode> q=new ArrayDeque();
        List<List<Integer>> ans=new ArrayList();
        List<Integer> currLvl=new ArrayList();
        q.add(root);
        q.add(new TreeNode(-1));
        while(q.size()>0){
            TreeNode rnode=q.remove();
            if(rnode.val!=-1){
                currLvl.add(rnode.val);  
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);    
            }else{
                ans.add(currLvl);
                if(q.size()!=0){
                    q.add(new TreeNode(-1));
                    currLvl=new ArrayList();
                }
            }    
        }
        Collections.reverse(ans);
        return ans;
    }
}