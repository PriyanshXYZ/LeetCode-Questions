/**
 similar to decode ways 1 
   but there are additional conditions to it!!
    when we get *
    at middle of somewhere
        1. we check previous element
            a. * => 15
            b. digit => 0 -> invalid
                     => 1 -> 9
                     => 2 -> 6
                     => invalid
    at start 
     only possible is 
      9 digits for single
      and <=6 then 12 
      otherwise 17 18 19 20 
        will implement this soon
 */
class Solution {

    int mod = (int)(1e9+7);

    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            //single digit
            char ch = s.charAt(i-1);
            // System.out.print("for 1 digit: "+i+"=>"+dp[i]+" ");
            if(!Character.isDigit(ch)) {
                dp[i] += 9*dp[i-1];
            }else if(ch!='0'){
                dp[i] += dp[i-1];
            }
            // System.out.println(dp[i]);

            //two digit
            if(i>=2){
                // System.out.print("for 2 digit: "+i+"=>"+dp[i]+" ");
                char ch1 = s.charAt(i-2);
                char ch2 = s.charAt(i-1);
                if(ch1 != '*' && ch2 != '*') {
                    int num = Integer.parseInt(ch1+""+ch2);
                    if(num>=10 && num<=26)
                        dp[i] += dp[i-2];
                }else if(ch2 != '*') {
                    if(ch2 > '6'){
                        dp[i] += 1*dp[i-2];
                    }else if(ch1 !='0'){
                        dp[i] += 2*dp[i-2]; // eg *1 => 11 / 21
                    }
                }else if(ch1 != '*') {
                    if(ch1=='1') {
                        dp[i] += 9*dp[i-2]; // 11 ...... 19
                    }else if(ch1=='2') {
                        dp[i] += 6*dp[i-2]; // 21 , 22 , 23, 24, 25, 26
                    }
                }else {
                    dp[i] += 15*dp[i-2]; //11.......20(not included)..........26
                }
                // System.out.println(dp[i]);
            }
            dp[i] %= mod;
        }
        return (int)dp[n];
    }
}