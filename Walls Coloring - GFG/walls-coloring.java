//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static final int P = 0;//pink color
    static final int B = 1;//black color
    static final int Y = 2;//yellow color
	int minCost(int [][] colors, int N){
        //Write your code here
        int[][] dp = new int[N][3];
        dp[0] = colors[0];
        
        for(int i = 1; i < N; i++){
            dp[i][P] = colors[i][P] + Math.min(dp[i-1][B],dp[i-1][Y]);
            dp[i][B] = colors[i][B] + Math.min(dp[i-1][P],dp[i-1][Y]);
            dp[i][Y] = colors[i][Y] + Math.min(dp[i-1][B],dp[i-1][P]);
        }
        return Math.min(dp[N-1][P],Math.min(dp[N-1][B],dp[N-1][Y]));
    }
}