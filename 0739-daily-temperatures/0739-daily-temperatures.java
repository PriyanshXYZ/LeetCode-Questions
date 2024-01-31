class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>(); // store idx here
        
        for(int i=0;i<n;i++){
            if(stk.size()==0){
                stk.push(i);
            }else{
                while(stk.size()>0 && temperatures[stk.peek()] < temperatures[i]){
                    int lastIdx = stk.pop();
                    res[lastIdx] = i - lastIdx;
                }
                stk.push(i);
            }
        }
        return res;
    }
}