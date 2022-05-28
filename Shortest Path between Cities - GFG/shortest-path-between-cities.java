// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
        	String input_line[] = read.readLine().trim().split("\\s+");
        	int x = Integer.parseInt(input_line[0]);
        	int y = Integer.parseInt(input_line[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestPath(x,y));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution { 
    int shortestPath( int x, int y){ 
        // code here
        int count=0;
        while(true){
            if(x>y){
                x=x/2;
                count++;
            }else if(y>x){
                y=y/2;
                count++;
            }else{
                break;   
            }
        }
        return count;
    }
}