//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int numOfPairs(int[] X, int[] Y, int N) {
        // code here
        HashMap<Integer, Integer> x_pt=new HashMap<>();
        HashMap<Integer, Integer> y_pt=new HashMap<>();
        HashMap<List<Integer>, Integer> xy_pt=new HashMap<>();
        
        int cX=0,cY=0,cXY=0;
        for(int i=0;i<N;i++){
            cX+=x_pt.getOrDefault(X[i],0);
            x_pt.put(X[i],x_pt.getOrDefault(X[i],0)+1);
            
            cY+=y_pt.getOrDefault(Y[i],0);
            y_pt.put(Y[i],y_pt.getOrDefault(Y[i],0)+1);
            
            List<Integer> p=new ArrayList<>();
            p.add(X[i]);
            p.add(Y[i]);
            cXY+=xy_pt.getOrDefault(p,0);
            xy_pt.put(p,xy_pt.getOrDefault(p,0)+1);
        }
        return cX+cY-(2*cXY);
    }
};