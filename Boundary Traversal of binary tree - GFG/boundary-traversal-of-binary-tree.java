// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    void leftnode(Node node,ArrayList<Integer> lm){
        if(node==null)return;
        //leaf node will be added in other function so skip here
        if(node.left==null && node.right==null)return;
        
        lm.add(node.data);
        if(node.left!=null){
            leftnode(node.left,lm);
        }else{
            leftnode(node.right,lm);
        }
    }
    void leaf(Node node,ArrayList<Integer> ln){
        if(node==null)return;
        //leaf node will be added in other function so skip here
        if(node.left==null && node.right==null){
            ln.add(node.data);
            return;
        }
        leaf(node.left,ln);
        leaf(node.right,ln);
    }
    void rightnode(Node node,ArrayList<Integer> rm){
        if(node==null)return;
        //leaf node will be added in other function so skip here
        if(node.left==null && node.right==null)return;
        
        
        if(node.right!=null){
            rightnode(node.right,rm);
        }else{
            rightnode(node.left,rm);
        }
        rm.add(node.data);
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans=new ArrayList<Integer>();
	    ans.add(node.data);
	    
	    ArrayList<Integer> leftMost=new ArrayList<Integer>();
	    leftnode(node.left,leftMost);
	    
	    ArrayList<Integer> leafNodes=new ArrayList<Integer>();
	    if(node.left!=null || node.right!=null){
    	    leaf(node,leafNodes);
	    }
	    
	    ArrayList<Integer> rightMost=new ArrayList<Integer>();
	    rightnode(node.right,rightMost);
	    
	    ans.addAll(leftMost);
	    ans.addAll(leafNodes);
	    ans.addAll(rightMost);
	    return ans;
	}
}
