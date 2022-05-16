// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    System.out.print("()");
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}// } Driver Code Ends

class solve
{
    //Function to find all possible unique subsets.
    
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        recursion(0,n,arr,new ArrayList<Integer>(),new boolean[n],res);
        res.remove(0);
        
        return res;
    }
    
    public static void recursion(int idx ,int n,int[] arr,ArrayList<Integer> list,boolean[] visit,ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList<Integer>(list));
        
        for(int i=idx;i<n;i++){
            if(visit[i])continue;
            if(i!=idx && arr[i]==arr[i-1] && !visit[i-1])continue;
            visit[i]=true;
            list.add(arr[i]);
            recursion(i+1,n,arr,list,visit,res);
            list.remove(list.size()-1);
            visit[i]=false;
            
        }  
        
        return;
    }
}
