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
    String encoded;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        encoded = "";
        dfs(root);
        return encoded;
    }

    private void dfs(TreeNode root) {
        if(root == null)return;

        encoded += root.val + ",";
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        int[] values = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();

        return dfs(new int[]{0}, values,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] idx, int[] values, int low, int hi) {
        if(idx[0] == values.length)return null;
        if(values[idx[0]]<low || values[idx[0]]>hi) return null;
    
        TreeNode root = new TreeNode(values[idx[0]]);
        idx[0]++;
        
        root.left = dfs(idx, values, low , root.val);
        root.right = dfs(idx, values, root.val, hi);
    
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;