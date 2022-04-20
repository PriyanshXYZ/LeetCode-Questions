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
class BSTIterator {
    int idx;
    List<Integer> list;
    public BSTIterator(TreeNode root) {
        list=new ArrayList();
        inorder(root,list);
    }
    
    public int next() {
        return list.get(idx++);
    }
    
    public boolean hasNext() {
        return idx<list.size();
    }
    public void inorder(TreeNode root,List<Integer> list){
        if(root==null)return;
        
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */