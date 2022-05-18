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
        Pair rootP=new Pair(root,0,0);
        q.add(rootP);
        int leftMostWidth=0;
        int rightMostWidth=0;
        HashMap<Integer,ArrayList<Pair>> hmap=new HashMap();//(width,arraylist of same depth elements)
        while(q.size()>0){
            int size=q.size();
            while(size-- >0){
                Pair rnodePair=q.remove();
                if(rnodePair.width<leftMostWidth){
                    leftMostWidth=rnodePair.width;
                }
                if(rnodePair.width>rightMostWidth){
                    rightMostWidth=rnodePair.width;
                }
                if(!hmap.containsKey(rnodePair.width)){
                    hmap.put(rnodePair.width,new ArrayList());
                    hmap.get(rnodePair.width).add(rnodePair);
                }else{
                    hmap.get(rnodePair.width).add(rnodePair);
                }
                
                if(rnodePair.node.left!=null){
                    q.add(new Pair(rnodePair.node.left,rnodePair.width-1,rnodePair.depth+1));
                }
                if(rnodePair.node.right!=null){
                    q.add(new Pair(rnodePair.node.right,rnodePair.width+1,rnodePair.depth+1));
                }
            }
        }
        List<List<Integer>> res=new ArrayList();
        for(int w=leftMostWidth;w<=rightMostWidth;w++){
            ArrayList<Pair> unsortedList=hmap.get(w);
            List<Integer> list=new ArrayList();
            Collections.sort(unsortedList);
            for(Pair item:unsortedList){
                int val=item.node.val;
                list.add(val);
            }
            res.add(list);
        }
        return res;
    }
}