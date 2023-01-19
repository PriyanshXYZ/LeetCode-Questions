//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int A, int B, int C, int D) { 
        //code here
        int moves = 0;
        int movesRot = 0;
         
        int l1 = A,b1 = B;
        int l2 = B,b2 = A;
        
        while(l1>C){
            l1=l1/2;
            moves++;
        }
        while(b1>D){
            b1=b1/2;
            moves++;
        }
        
        while(l2>C){
            l2=l2/2;
            movesRot++;
        }
        while(b2>D){
            b2=b2/2;
            movesRot++;
        }
        return Math.min(movesRot, moves);
    }
   
}
