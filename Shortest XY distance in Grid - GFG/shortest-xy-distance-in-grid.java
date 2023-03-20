//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N, int M) {
        //code here
        List<int[]> X = new ArrayList<>();
        List<int[]> Y = new ArrayList<>();
        
        for(int i=0;i<grid.size();i++){
            ArrayList<Character> col = grid.get(i);
            for(int j = 0;j<col.size();j++){
                char ch = col.get(j);
                if(ch=='X'){
                    X.add(new int[]{i,j});
                }else if(ch=='Y'){
                    Y.add(new int[]{i,j});
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int[] x : X){
            for(int[] y : Y){
                int dist = Math.abs(x[0]-y[0]) + Math.abs(x[1]-y[1]);
                // System.out.println(dist+" "+x[0]+" "+x[1]+","+y[0]+" "+y[1]);
                if(dist<min){
                    min = dist;
                }
            }
        }
        return min;
    }
};