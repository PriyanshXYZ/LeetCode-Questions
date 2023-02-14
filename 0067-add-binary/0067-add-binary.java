class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        
        int idx1 = a.length() - 1, idx2 = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while(idx1>=0 || idx2>=0 || carry==true){
            int val1 = idx1>=0?a.charAt(idx1)-'0':0;
            int val2 = idx2>=0?b.charAt(idx2)-'0':0;
            
            int sum = val1+val2 + (carry?1:0);
            int rem  = sum % 2;
            
            res.append(rem);
            if(sum/2!=0){
                carry =true;
            }else{
                carry =false;
            }
            idx1--;
            idx2--;
        }
        return res.reverse().toString();
    }
}