class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack();
        
        for(String str : tokens){
            if(isDigit(str)){
                stk.push(Integer.parseInt(str));
            }else{
                String op = str;
                if(stk.size() >= 2){
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(operate(op, a, b));
                }else{
                    return -1;
                }
            }
        }
        return stk.peek();
    }
    public boolean isDigit(String str){
        for(char ch : str.toCharArray()){
            if(!Character.isDigit(ch)){
                if(str.length()>1 && ch=='-'){
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public int operate(String op, int num1, int num2){
        if(op.equals("+")){
            return num1 + num2;
        }else if(op.equals("-")){
            return num1 - num2;
        }else if(op.equals("*")){
            return num1 * num2;
        }else{
            return num1 / num2;
        }
    }
}