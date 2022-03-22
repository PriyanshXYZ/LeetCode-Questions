// { Driver Code Starts
//Initial Template for Java
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node{
    public int data;
    public Node left,right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            System.out.println(obj.imgMultiply(root));
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java
/* Tree node structure  used in the program
class Node{
    public int data;
    public Node left,right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
 */
 class Solution {
    long sum=0;
    long res=0;
    public long imgMultiply(Node root)
    {
        // code here
        sum=root.data*root.data;
        if(root==null)return sum;
        helper(root.left,root.right);
        sum+=res;
        return sum%(long)(Math.pow(10,9)+7);
       
    }
    public void helper(Node left,Node right){
        if(left==null && right==null){
            return;
        }
        if(left==null || right==null)return;
        if(left!=null && right!=null) res+=left.data*right.data;
        
        helper(left.left,right.right);
        helper(left.right,right.left);
    }
}
 //bfs
        // if(root==null)return 0;
        // Queue<Node> q=new ArrayDeque<Node>();
        // long sum=root.data*root.data;
        // q.add(root);
        // ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        // while(q.size()>0){
        //     int size=q.size();
        //     ArrayList<Integer> child=new ArrayList<Integer>();
        //     while(size-->0){
        //         Node rnode=q.remove();
                
        //         child.add(rnode.data);
        //         if(rnode.left!=null)q.add(rnode.left);
        //         if(rnode.right!=null) q.add(rnode.right);
        //     }
        //     ans.add(child);
        // }
        // // System.out.println(ans);
        // for(int i=1;i<ans.size();i++){
        //     ArrayList<Integer> res=ans.get(i);
        //     if(res.size()<2) return sum;
        //     int j=0,k=res.size()-1;
        //     while(j<k){
        //         sum+=res.get(j)*res.get(k);
        //         j++;
        //         k--;
        //     }
        // }
        // return sum;