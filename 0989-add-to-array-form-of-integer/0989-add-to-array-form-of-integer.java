class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int i1=num.length-1;
        int carry =0;
        while(i1>=0 || k>0 || carry>0){
            int dig1 = i1>=0?num[i1]:0;
            int dig2 = k%10;
            
            int sum = dig1 + dig2 + carry;
            int rem = sum % 10;
            res.add(0,rem);
            if(sum/10>0){
                carry=1;
            }else{
                carry=0;
            }
            k=k/10;
            i1--;
        }
        
        return res;
    }
    public StringBuilder add(StringBuilder a, String b){
        int carry = 0;
        int i1 = a.length() - 1, i2 = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while(i1 >=0 || i2 >= 0 || carry > 0){
            int dig1 = i1>=0?(a.charAt(i1)-'0'):0;
            int dig2 = i2>=0?(b.charAt(i2)-'0'):0;
            
            int sum = dig1+dig2+carry;
            int rem = sum%10;
            res.append(rem);
            
            if(sum/10>0){
                carry = 1;
            }else{
                carry = 0;
            }
            i1--;
            i2--;
        }
        return res.reverse();
    }
}