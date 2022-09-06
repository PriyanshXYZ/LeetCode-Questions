class Solution {
    public String removeKdigits(String num, int k) {
        //why next smaller element works?? becuse in order to create smallest number we need to elminate larger  elements
        Stack<Character> stk=new Stack();
        
        
        for(char ch:num.toCharArray()){
            while(stk.size()>0 && k>0 && ch<stk.peek()){
                stk.pop();
                k--;
            }
            stk.push(ch);
        }
        
        while(k>0){
            stk.pop();
            k--;
        }
        
        StringBuilder sb=new StringBuilder();
        
        while(stk.size()>0){
            sb.append(stk.pop());
        }
        
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='0'){
                sb.deleteCharAt(i);
            }else{
                break;
            }
        }
        
        String res=sb.reverse().toString();
        return res.length()==0?"0":res;
    }
}