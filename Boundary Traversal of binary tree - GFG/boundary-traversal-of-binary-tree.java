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
    void leftMost(Node node,ArrayList<Integer> a){
        if(node==null) return;
        //we cant add leafnodes as it will be added in other function
        if(node.left==null && node.right==null){
            return;
        }
        a.add(node.data);
        //faith
        if(node.left!=null){
             leftMost(node.left,a);
            
        }else{
             leftMost(node.right,a);
        }
    }
    void leaf(Node node,ArrayList<Integer> a){
        if(node==null) return;
        if(node.left==null && node.right==null){
            a.add(node.data);
            return;
        }
        //faith
        leaf(node.left,a);
        leaf(node.right,a);
    }
    void rightMost(Node node,ArrayList<Integer> a){
        if(node==null) return;
        //we cant add leafnodes as it will be added in other function
        if(node.left==null && node.right==null){
            return;
        }
        //faith
        if(node.right!=null){
             rightMost(node.right,a);
            
        }else{
             rightMost(node.left,a);
        }
        a.add(node.data);
        
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList <Integer> ans=new ArrayList<Integer>();
	    //add root node manually
	    ans.add(node.data);
	    if(node.left==null && node.right==null)return ans;
	    //add leftnode
	    ArrayList<Integer> lm=new ArrayList<Integer>();
	    leftMost(node.left,lm);
	    
	    //add leafNode
	    ArrayList<Integer> ln=new ArrayList<Integer>();
	    leaf(node,ln);
	    
	    //add right most
	    ArrayList<Integer> rm=new ArrayList<Integer>();
	    rightMost(node.right,rm);
	    
	    ans.addAll(lm);
	    ans.addAll(ln);
	    ans.addAll(rm);
	    
	    return ans;
	}
}
