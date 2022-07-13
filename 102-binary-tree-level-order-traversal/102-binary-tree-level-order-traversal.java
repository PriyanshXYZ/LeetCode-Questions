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
class Solution{
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList();
        ans=new ArrayList();
        recursion(root,0);
        return ans;
    }
    private void recursion(TreeNode root,int level){
        if(ans.size()==level){
            ans.add(new ArrayList());
        }
        ans.get(level).add(root.val);
        if(root.left!=null)recursion(root.left,level+1);
        if(root.right!=null)recursion(root.right,level+1);
    }
}
class Solution1 {
    //bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList();
        List<List<Integer>> res=new ArrayList();
        Queue<TreeNode> q=new ArrayDeque();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> lvl=new ArrayList();
            int size=q.size();
            while(size-- >0){
                TreeNode rNode=q.remove();
                lvl.add(rNode.val);
                if(rNode.left!=null)q.add(rNode.left);
                if(rNode.right!=null)q.add(rNode.right);
            }
            res.add(lvl);
        }
        return res;
    }
}