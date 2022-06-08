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

//using DFS
class Solution1 {
    class Pair{
        int maxInLvl;
        int minInLvl;
    }
    
    int maxWidth=0;
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer,Pair> map=new HashMap();
        dfs(root,0,0,map);
        return maxWidth;
    }
    public void dfs(TreeNode root,int level,int idx,HashMap<Integer,Pair> map){
        if(root==null)return;
        
        dfs(root.left,level+1,2*idx+1,map);
        dfs(root.right,level+1,2*idx+2,map);
        
        Pair p=null;
        if(map.containsKey(level)){
            p=map.get(level);
            p.maxInLvl=idx;
        }else{
            p=new Pair();
            p.minInLvl=idx;
            p.maxInLvl=idx;
            map.put(level,p);
        }
        
        maxWidth=Math.max(maxWidth,p.maxInLvl-p.minInLvl+1);
        
    }
}
//using BFS
class Solution {
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    //formula for left child and right child is 2*parentIdx +1 and 2*parentIdx+2
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<Pair> q=new ArrayDeque();
        q.add(new Pair(root,0));
        int width=0;
        while(q.size()>0){
            int size=q.size();
            int start=0,end=0;
            for(int i=0;i<size;i++){
                Pair rnodePair=q.remove();
                if(i==0){
                    start=rnodePair.idx;
                }
                if(i==size-1){
                    end=rnodePair.idx;
                }
                if(rnodePair.node.left!=null){
                    int idx=2*rnodePair.idx+1;
                    Pair p=new Pair(rnodePair.node.left,idx);
                    q.add(p);
                }
                if(rnodePair.node.right!=null){
                    int idx=2*rnodePair.idx+2;
                    Pair p=new Pair(rnodePair.node.right,idx);
                    q.add(p);
                }
            }
            int currWidth=end-start+1;
            width=Math.max(currWidth,width);
        }
        return width;
    }
}