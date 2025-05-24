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
        long prev = 1;
        long prevToPrev = 0;
        
        for(int i = 1; i <= n; i++) {
            //single digit
            long curr = 0;    
            char ch = s.charAt(i-1);
            if(!Character.isDigit(ch)) {
                curr += 9*prev;
            }else if(ch!='0'){
                curr += prev;
            }
            curr%=mod;
            //two digit
            if(i>=2){
            
                char ch1 = s.charAt(i-2);
                char ch2 = s.charAt(i-1);
                if(ch1 != '*' && ch2 != '*') {
                    int num = Integer.parseInt(ch1+""+ch2);
                    if(num>=10 && num<=26)
                        curr += prevToPrev;
                }else if(ch2 != '*') {
                    if(ch2 > '6'){
                        curr += 1*prevToPrev;
                    }else if(ch1 !='0'){
                        curr += 2*prevToPrev; // eg *1 => 11 / 21
                    }
                }else if(ch1 != '*') {
                    if(ch1=='1') {
                        curr += 9*prevToPrev; // 11 ...... 19
                    }else if(ch1=='2') {
                        curr += 6*prevToPrev; // 21 , 22 , 23, 24, 25, 26
                    }
                }else {
                    curr += 15*prevToPrev; //11.......20(not included)..........26
                }
                curr %= mod;
            }

            prevToPrev = prev;
            prev = curr;
        }
        return (int)prev;
    }
}