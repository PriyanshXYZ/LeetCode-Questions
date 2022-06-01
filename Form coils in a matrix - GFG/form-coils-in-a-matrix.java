// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            int[][] ptr = ob.formCoils(n);
            
            for(int i=0; i<2; i++)
            {
                for(int j=0; j<ptr[i].length; j++)
                {
                    System.out.print(ptr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[][] formCoils(int n) {
        // code here
        int[][] mat=new int[4*n][4*n];
        int val=1;
        for(int i=0;i<4*n;i++){
            for(int j=0;j<4*n;j++){
                mat[i][j]=val++;
            }
        }
        int[] coil1=new int[8*n*n];
        
        
        int minRow=0,minCol=0,maxRow=4*n,maxCol=4*n-1;
        int count=8*n*n-1;
        while(count>=0){
            for(int i=minRow;i<maxRow;i++){
                if(count>=0)
                    coil1[count--]=mat[i][minCol];
                
            }
            minRow++;
            minCol++;
            for(int j=minCol;j<maxCol;j++){
                if(count>=0)
                    coil1[count--]=mat[maxRow-1][j];
                
            }
            maxRow--;
            minCol++;
            for(int i=maxRow-1;i>=minRow;i--){
                if(count>=0)
                    coil1[count--]=mat[i][maxCol-1];
                
            }
            maxCol--;
            maxRow--;
            for(int j=maxCol-1;j>=minCol;j--){
                if(count>=0)
                    coil1[count--]=mat[minRow][j];
                
            }
            maxCol--;
            minRow++;
        }
        int[] coil2=new int[8*n*n];
        minRow=0;minCol=1;maxRow=4*n-1;maxCol=4*n-1;
        count=8*n*n-1;
        while(count>=0){
            for(int i=maxRow;i>=minRow;i--){
                if(count>=0)
                    coil2[count--]=mat[i][maxCol];
            }
            maxRow--;
            maxCol--;
            for(int j=maxCol;j>=minCol;j--){
                if(count>=0)
                    coil2[count--]=mat[minRow][j];
            }
            minCol++;
            minRow++;
            for(int i=minRow;i<=maxRow;i++){
                if(count>=0)
                    coil2[count--]=mat[i][minCol-1];
            }
            
            minCol++;
            maxCol--;
            for(int j=minCol-1;j<=maxCol;j++){
                if(count>=0)
                    coil2[count--]=mat[maxRow][j];
            }
            minRow++; 
            maxRow--;
            
        }
        return new int[][]{coil2,coil1};
    }
}