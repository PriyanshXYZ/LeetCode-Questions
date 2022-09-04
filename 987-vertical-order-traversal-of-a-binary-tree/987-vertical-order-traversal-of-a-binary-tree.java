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
    class Pair implements Comparable<Pair>{
        TreeNode node;
        int width;//horizontal lvl
        int depth;//vertical lvl
        
        
        Pair(TreeNode node,int width,int depth){
            this.node=node;
            this.width=width;
            this.depth=depth;
        }
        
        //this-other => increasing order
        //other - this => decereasing order
        public int compareTo(Pair other){
            if(this.depth==other.depth){
                return this.node.val-other.node.val;
            }else{
                return this.depth-other.depth;
            }
        }
        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q=new ArrayDeque();
        q.add(new Pair(root,0,0));
        HashMap<Integer,ArrayList<Pair>> m=new HashMap();
        
        int leftMostWidth=0;
        int rightMostWidth=0;
        
        while(q.size()>0){
            Pair rem=q.remove();
            if(rem.width<leftMostWidth){
                leftMostWidth=rem.width;
            }
            if(rem.width>rightMostWidth){
                rightMostWidth=rem.width;
            }
            if(!m.containsKey(rem.width)){
                m.put(rem.width,new ArrayList());
            }
            m.get(rem.width).add(rem);
            if(rem.node.left!=null){
                q.add(new Pair(rem.node.left,rem.width-1,rem.depth+1));
            }
            
            if(rem.node.right!=null){
                q.add(new Pair(rem.node.right,rem.width+1,rem.depth+1));
            }
        }
        
        List<List<Integer>> res=new ArrayList();
        
        for(int i=0,w=leftMostWidth;w<=rightMostWidth;w++,i++){
            res.add(new ArrayList());
            Collections.sort(m.get(w));
            for(int j=0;j<m.get(w).size();j++){
                res.get(i).add(m.get(w).get(j).node.val);
            }
        }
        return res;
    }
}