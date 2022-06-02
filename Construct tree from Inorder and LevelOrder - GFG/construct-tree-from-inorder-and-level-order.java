// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<level.length;i++){
            map.put(level[i],i);
        }
        
        Node root=construct(inord,map,0,inord.length-1);
        return root;
    }
    Node construct(int[] in, HashMap<Integer,Integer> map,int lo,int hi){
        //base case
        if(lo>hi)return null;
        //finding minidx in from map for range lo to hi and making node of it
        int minIdx=lo;
        for(int i=lo;i<hi;i++){
            if(map.get(in[i])<map.get(in[minIdx])){
                minIdx=i;
            }
        }
        
        Node node=new Node(in[minIdx]);
        node.left=construct(in,map,lo,minIdx-1);
        node.right=construct(in,map,minIdx+1,hi);
        return node;
    }
    
    
   
}


