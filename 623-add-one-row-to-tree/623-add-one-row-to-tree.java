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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth ==1){
            TreeNode temp=new TreeNode(val);
            temp.left=root;
            return temp;
        }
        Queue<TreeNode> q=new ArrayDeque();
        q.add(root);
        int curDepth=1;
        
        while(q.isEmpty()==false){
            int size=q.size();
            // int flag=0;
            while(size-->0){
                TreeNode rNode=q.remove();
                if(rNode.left!=null)q.add(rNode.left);
                if(rNode.right!=null)q.add(rNode.right);
                if(curDepth+1==depth){
                    TreeNode left=rNode.left;
                    TreeNode right=rNode.right;
                    rNode.left=new TreeNode(val);
                    rNode.right=new TreeNode(val);
                    rNode.left.left=left;
                    rNode.right.right=right;
                    // flag=1;
                }
            }
            // if(flag==1)break;
            curDepth++;
        }
        return root;
    }
//     public void dfs(TreeNode root,int val,int currDepth,int depth){
//         if(root==null)return;
        
//         if(currDepth+1==depth){
//             TreeNode left=root.left;
//             TreeNode right=root.right;
//             root.left=new TreeNode(val);
//             root.right=new TreeNode(val);
//             root.left.left=left;
//             root.right.right=right;
//             return;
//         }
//         dfs(root.left,val,currDepth+1,depth);
//         dfs(root.right,val,currDepth+1,depth);
//     }
}