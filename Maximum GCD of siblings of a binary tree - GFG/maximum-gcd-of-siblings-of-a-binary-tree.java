// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            
            for(int i=0; i<N-1; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                String S[] = read.readLine().split(" ");
                temp.add(Integer.parseInt(S[0]));
                temp.add(Integer.parseInt(S[1]));
                arr.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxBinTreeGCD(arr,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int n) {
        // code here
        Collections.sort(arr,new Comparator<ArrayList<Integer>>(){
            @Override   
                public int compare(ArrayList<Integer> a1,ArrayList<Integer> a2){
                    return a1.get(0)-a2.get(0);
                }
            });
        if(n<=2)return 0;
        int max=0;
        int i=0;
        while(i<arr.size()-1){
            if(arr.get(i).get(0)==arr.get(i+1).get(0)){
                max=Math.max(gcd(arr.get(i).get(1),arr.get(i+1).get(1)),max);
                i=i+2;
            }else{
                i++;
            }
        }
        return max;
    }
    static int gcd(int a,int b){
        if(a==0)return b;
        return gcd(b%a,a);
    }
};