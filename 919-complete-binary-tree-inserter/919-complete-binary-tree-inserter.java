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
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> q;
    public CBTInserter(TreeNode root) {
        this.root=root;
        q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode rem=q.peek();
            if(rem.left==null || rem.right==null){
                if(rem.left!=null){
                    q.add(rem.left);
                }
                break;
            }
            q.remove();
            if(rem.left!=null){
                q.add(rem.left);
            }
            if(rem.right!=null){
                q.add(rem.right);
            }
        }
    }
    
    public int insert(int val) {
        
        TreeNode node=q.peek();
        TreeNode newNode=new TreeNode(val);
        q.add(newNode);
        if(node.left==null){
            node.left=newNode;
        }else{
            q.remove();
            node.right=newNode;

        }
        return node.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */