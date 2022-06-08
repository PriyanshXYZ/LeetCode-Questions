// { Driver Code Starts
//Initial template for Java

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

class GFG {
    
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
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Solution ob = new Solution();
            if((turn = ob.NumberOfTurns(root, nd1, nd2)) != 0)
              System.out.println(turn);
            else
              System.out.println("-1");
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{
    static int NumberOfTurns(Node root, int first, int second)
    {
        //your code here
        List<Node> p1=n2r(root,first);
        List<Node> p2=n2r(root,second);
        int end1=p1.size()-1;
        int end2=p2.size()-1;
        
        while(end1>=0 && end2>=0 ){
            if(p1.get(end1)==p2.get(end2)){
                end1--;
                end2--;
            }else{
                break;
            }
        }
        end1++;
        end2++;
        Node LCA=p1.get(end1);
        
        if(LCA.data!=first && LCA.data!=second){
            int turn1=getTurns(p1,end1);
            int turn2=getTurns(p2,end2);
            return turn1+turn2+1;
        }else if(LCA.data==first){
            int turn=getTurns(p2,end2);
            return turn;
        }else if(LCA.data==second){
            int turn=getTurns(p1,end1);
            return turn;
        }
        return 0;
        
        
    }
    static int getTurns(List<Node> p1,int end1){
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=end1;i++){
            if(p1.get(i-1)==p1.get(i).right){
                sb.append("R");
            }else{
                sb.append("L");
            }
        }
        int turn=0;
        
        for(int i=1;i<sb.length();i++){
            if(sb.charAt(i-1)!=sb.charAt(i)){
                turn++;
            }
        }
        return turn;
    }
    static public List<Node> n2r(Node root,int val){
        if(root==null)return new ArrayList<>();
        
        if(root.data==val){
            List<Node> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        
        List<Node> left=n2r(root.left,val);
        if(left.size() > 0){
            left.add(root);
            return left;
        }
        
        List<Node> right=n2r(root.right,val);
        if(right.size() > 0){
            right.add(root);
            return right;
        }
        
        return new ArrayList<>();
    }
}