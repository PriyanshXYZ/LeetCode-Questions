class Solution {
    public int calPoints(String[] ops) {
        List<Integer> stk=new ArrayList();
        for(int i=0;i<ops.length;i++){
            int prev=stk.size()-1;
            int prev2=stk.size()-2;
            if(ops[i].equals("C")){
                stk.remove(prev);
            }else if(ops[i].equals("D")){
                stk.add(stk.get(prev)*2);
            }else if(ops[i].equals("+")){
                stk.add(stk.get(prev)+stk.get(prev2));
            }else{
                stk.add(Integer.parseInt(ops[i]));
            }
        }
        int sum=0;
        for(int i=0;i<stk.size();i++){
            sum+=stk.get(i);
        }
        return sum;
    }
}