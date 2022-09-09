class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            else return b[1]-a[1];
        });
        Stack<int[]> stk=new Stack();
        
        int count=0;
        for(int[] prop : properties){
            while(stk.size()>0 && prop[1]>stk.peek()[1]){
                count++;
                stk.pop();
            }
            stk.push(prop);
        }
        return count;
    }
}