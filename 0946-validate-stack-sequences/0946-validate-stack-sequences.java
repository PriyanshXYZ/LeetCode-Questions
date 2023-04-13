class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j=0; //popped index
        Stack<Integer> stk=new Stack();
        for(int x:pushed){
            stk.push(x);
            while(stk.size()>0 && stk.peek()==popped[j]){
                stk.pop();
                j++;
            }
        }
        return stk.isEmpty();
    }
}