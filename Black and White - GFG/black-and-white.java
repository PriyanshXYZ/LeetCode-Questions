//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static boolean isValid(int r, int c,int n, int m){
        if(r < 0 || r >= n || c >= m || c < 0)return false;
        return true;
    }
    static long numOfWays(int N, int M)
    {
        int mod = (int)(1e9 + 7);
        // add your code here
        int[][] dirs={{2, 1}, {1, 2}, {-1, -2},{-2, -1}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}};
        long ans = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                long count = 0;
                for(int[] dir : dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(isValid(x, y, N, M)){
                        count++;
                    }
                }
                ans = ans % mod + (N * M - 1 - count ) % mod;
            }
        }
        return ans;
    }
}