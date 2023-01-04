class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

		for(char ch : s.toCharArray()){
			if(ch==')' || ch==']' || ch=='}'){
				if(stk.size()>0 && stk.peek()==ch){
					stk.pop();
				}else{
					return false;
				}
			}else{
				if(ch=='('){
					stk.push(')');
				}else if(ch == '['){
					stk.push(']');
				}else{
					stk.push('}');
				}
			}
		}
		return stk.size()==0;
    }
}