// { Driver Code Starts
//Initial Template for Java

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
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
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
// }

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        List<Node> n2r=node2root(root,target);
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int idx=0;idx<n2r.size();idx++){
            Node blocker=idx-1>=0?n2r.get(idx-1):null;
            res.addAll(kDistance(n2r.get(idx),blocker,new ArrayList<Integer>(),k-idx));
        }
        Collections.sort(res);
        return res;
    }
    
    public static ArrayList<Integer> kDistance(Node root,Node blocker,ArrayList<Integer> ans,int level){
        if(root==null || root==blocker)return new ArrayList<>();
        
        if(level==0){
            ans.add(root.data);
            return ans;
        }
        kDistance(root.left,blocker,ans,level-1);
        kDistance(root.right,blocker,ans,level-1);
        return ans;
        
    }
    public static List<Node> node2root(Node root,int target){
        if(root==null)return new ArrayList<>();
        
        if(root.data==target){
            List<Node> base=new ArrayList();
            base.add(root);
            return base;
        }
        
        List<Node> left=node2root(root.left,target);
        if(left.size()>0){
            left.add(root);
            return left;
        }
        List<Node> right=node2root(root.right,target);
        if(right.size()>0){
            right.add(root);
            return right;
        }
        return new ArrayList();
    }
};