class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];
        return possibleDecodings(0, s, dp);
    }
    
    private int possibleDecodings(int idx, String s, Integer[] dp) {
        //base case
        if(idx >=s.length()) return 1;
        
        if(dp[idx]!=null)return dp[idx];
        
        char ch = s.charAt(idx);
        int ans = 0;
        if(ch!='0')
            ans = possibleDecodings(idx + 1, s, dp);
        if(idx + 1 <s.length()){
            char ch2 = s.charAt(idx+1);
            if(ch=='1' || (ch == '2' && ch2 <='6')){
                ans += possibleDecodings(idx+2, s, dp);
            }
        }
        return dp[idx] = ans;
    }
}


// "0", "1"
/*
  s = 16537
                            2        ""
                            1            16
                       1<- 1,6   16,5 ->1 
          1<  1,6,5    16,5,3 ->1       
           1<- 1,6,5,3  16,5,3,7 ->1
            1,6,5,3,7 ->
  
  if we reach at the >=n  -> 1
  
  
  fn(s) = fn(s.substring(0,1)) + fn(s.substring(0,2))
    dp[idx][digitChoice]
       0  1  
    1  1  0
    6  1  1
    5  1  0 
    3  1  0
    7  1  0
    
*/