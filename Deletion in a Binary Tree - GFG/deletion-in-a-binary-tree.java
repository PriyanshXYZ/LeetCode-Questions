// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0)
	        {
	            String arr[] = br.readLine().split(" ");
	            int key = Integer.parseInt(arr[0]);
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution g = new Solution();
        		g.deletionBT(root,key);
        		printInorder(root);
        		System.out.println();
                    t--;
            
        }
    }
}


// } Driver Code Ends


/*
Node class is as follows:

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    
    public Node deletionBT(Node root, int key){
        //Write your code here and return the root of the changed tree
        Node leaf=getBottomRightNode(root);
        Node target=get(root,key);
        int temp=target.data;
        target.data=leaf.data;
        leaf.data=temp;
        delete(root,leaf.data);
        return root;
    }
    private Node  getBottomRightNode(Node root){
        if(root==null)return null;
        Queue<Node> q=new ArrayDeque<>();
        q.add(root);
        Node leaf=root;
        while(q.size()>0){
            int size=q.size();
            while(size-- >0){
                Node rnode=q.remove();
                leaf=rnode;
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);
            }
        }
        return leaf;
    }
    private Node get(Node root,int key){
        if(root==null)return null;
        if(root.data==key)return root;
        
        Node left=get(root.left,key);
        if(left!=null)return left;
        Node right=get(root.right,key);
        if(right!=null)return right;
        return null;
    }
    private Node delete(Node root,int key){
        if(root==null || root.data==key)return null;
        
        Node left=delete(root.left,key);
        Node right=delete(root.right,key);
        root.left=left;
        root.right=right;
        return root;
    }
}