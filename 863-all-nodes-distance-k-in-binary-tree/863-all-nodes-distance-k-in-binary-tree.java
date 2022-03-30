/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> node2root=n2r(root,target);
        List<Integer> res=new ArrayList();
        for(int i=0;i<node2root.size();i++){
            TreeNode blocker=i-1>=0?node2root.get(i-1):null;
            res.addAll(printKLevelDown(node2root.get(i),blocker,k-i));
        }
        return res;
    }
    public List<Integer> printKLevelDown(TreeNode root,TreeNode blocker,int k){
        if(root==null || root==blocker) return new ArrayList();
        List<Integer> res=new ArrayList();
        if(k==0){
            res.add(root.val);
        }
        List<Integer> lch=printKLevelDown(root.left,blocker,k-1);
        List<Integer> rch=printKLevelDown(root.right,blocker,k-1);
        
        
        res.addAll(lch);
        res.addAll(rch);
        return res;
    }
    public List<TreeNode> n2r(TreeNode root,TreeNode target){
        if(root==null)return new ArrayList();
        if(root==target){
            List<TreeNode> base=new ArrayList();
            base.add(root);
            return base;
        }
        List<TreeNode> lch=n2r(root.left,target);
        if(lch.size()>0){
            lch.add(root);
            return lch;
        }
        List<TreeNode> rch=n2r(root.right,target);
        if(rch.size()>0){
            rch.add(root);
            return rch;
        }
        return new ArrayList();
    }
}