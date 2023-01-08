class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {open.push(i);}
            else if(s.charAt(i) == '*') {star.push(i);}
            else {
                if(!open.isEmpty()) {open.pop();} // found matched '('with')'
                else if (!star.isEmpty()) {star.pop();} // match '*' with ')'
                else return false; // cannot find match
            }
        }

        // checking leftover on 2 stack
        while(!open.isEmpty()) { // we can have '*' leftover, but 'open' must run out 
            if(star.isEmpty()) {return false;} // '(' leftover
            else if (open.peek()<star.peek()){open.pop(); star.pop();} // '*'index > '(' index, matched
            else {return false;} // open>top, corner case
        }
        return true;
    }
}
class Solution1 {
    public boolean checkValidString(String s) {
        Stack<Character> bkt = new Stack<>();
        Stack<Character> str = new Stack<>();
		for(char ch : s.toCharArray()){
			if(ch=='('){
                bkt.push(ch);
            }else if(ch=='*'){
                str.push(ch);
            }else{
                if(!bkt.isEmpty())bkt.pop();//we found opening for our closing
                else if(!str.isEmpty())str.pop();
                else return false;
            }
		}
        
        while(!bkt.isEmpty()){
            if(bkt.peek()<str.peek()){
                bkt.pop();
                str.pop();
            }else{
                return false;
            }
        }
		return true;
    }
    
}