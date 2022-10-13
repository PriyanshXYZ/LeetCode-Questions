//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        HashMap<String , Integer> m=new HashMap<>();
        int c0=1;
        int c1=0;
        int c2=0;
        
        
        int count=0;
        String temp=(c1-c0)+"#"+(c2-c1);
        m.put(temp,1);
        for(char ch:str.toCharArray()){
            if(ch=='0'){
                c0+=1;
            }else if(ch=='1'){
                c1+=1;
            }else{
                c2+=1;
            }
            
            temp=(c1-c0)+"#"+(c2-c1);
            if(m.containsKey(temp)){
                count+=m.get(temp);
            }
            m.put(temp,m.getOrDefault(temp,0)+1);
        }
        return count;
    }
} 