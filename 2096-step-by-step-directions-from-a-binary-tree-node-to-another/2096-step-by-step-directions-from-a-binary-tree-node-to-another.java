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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNode> p1=new ArrayList(),p2=new ArrayList();
        
        p1=n2r(root,startValue);
        p2=n2r(root,destValue);
        
        int end1=p1.size()-1;
        int end2=p2.size()-1;
        
        while(end1>=0 && end2>=0 ){
            if(p1.get(end1)==p2.get(end2)){
                end1--;
                end2--;
            }else{
                break;
            }
        }
        end1++;
        end2++;
        StringBuilder sb=new StringBuilder();
        //add for node to lca 
        for(int i=0;i<end1;i++){
            sb.append("U");
        }
        //adding for lac to node
        for(int i=end2;i>0;i--){
            if(p2.get(i-1)==p2.get(i).right){
                sb.append("R");
            }else{
                sb.append("L");
            }
        }
        return sb.toString();
    }
    public List<TreeNode> n2r(TreeNode root,int val){
        if(root==null)return new ArrayList();
        
        if(root.val==val){
            List<TreeNode> base=new ArrayList();
            base.add(root);
            return base;
        }
        
        List<TreeNode> left=n2r(root.left,val);
        if(left.size() > 0){
            left.add(root);
            return left;
        }
        
        List<TreeNode> right=n2r(root.right,val);
        if(right.size() > 0){
            right.add(root);
            return right;
        }
        
        return new ArrayList();
    }
    
}