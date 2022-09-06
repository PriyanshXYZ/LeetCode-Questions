class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stk=new Stack();
        int[] res=new int[temp.length];
        for(int i=0;i<temp.length;i++){
            while(stk.size()>0 && temp[i]>temp[stk.peek()]){
                int idx=stk.pop();
                res[idx]=i-idx;
            }
            
            stk.push(i);
        }
        return res;
    }
}