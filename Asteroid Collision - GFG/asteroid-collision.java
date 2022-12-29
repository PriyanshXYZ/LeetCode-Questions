//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> stk = new Stack<>();
        for(int asteroid : asteroids){
            if(stk.size()==0){
                stk.push(asteroid);
            }else if(asteroid<0){
                while(stk.size() >0 && stk.peek()>0 && stk.peek()<Math.abs(asteroid)){
                    stk.pop();
                }
                if(stk.size()==0){
                    stk.push(asteroid);
                }else if(stk.peek()<0){
                    stk.push(asteroid);
                }else if(stk.peek()>Math.abs(asteroid)){
                    //do nothing
                }else if(stk.peek()==Math.abs(asteroid)){
                    stk.pop();
                }
            }else if(asteroid>0){
                stk.push(asteroid);
            }
        }
        int[] res = new int[stk.size()];
        int idx = stk.size() - 1;
        while(stk.size() > 0 ){
            res[idx--] = stk.pop();
        }
        return res;
    }
}
