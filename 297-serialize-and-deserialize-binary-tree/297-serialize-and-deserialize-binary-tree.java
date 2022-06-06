/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node,int state){
            this.node=node;
            this.state=state;
        }
    }
    private final String toSep=",";
    private final String forNull=".";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        convertTree(root,sb);
        return sb.toString();
    }
    
    public StringBuilder convertTree(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(forNull).append(toSep);
        }else{
            sb.append(root.val).append(toSep);
            convertTree(root.left,sb);
            convertTree(root.right,sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)return null;
        //using Bfs
        String[] arr=data.split(",");
        
        Stack<Pair> stk=new Stack();
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Pair p=new Pair(root,0);
        stk.add(p);
        int idx=1;
        while(idx<arr.length){
            Pair top=stk.peek();
            if(top.state==0){
                //add left to top stack node
                if(!arr[idx].equals(".")){
                    TreeNode left=new TreeNode(Integer.parseInt(arr[idx]));
                    top.node.left=left;
                    Pair pl=new Pair(left,0);
                    stk.push(pl);
                    
                }
                top.state++;
                idx++;
            }else if(top.state==1){
                //add right to top stack node
                if(!arr[idx].equals(".")){
                    TreeNode right=new TreeNode(Integer.parseInt(arr[idx]));
                    top.node.right=right;
                    Pair pr=new Pair(right,0);
                    stk.push(pr);
                    
                }
                top.state++;
                idx++;
            }else{
                stk.pop();
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));