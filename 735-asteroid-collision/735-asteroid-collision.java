class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk=new Stack();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            // System.out.println(stk);
            if(stk.size()==0){
                stk.push(asteroids[i]);
            }else if(asteroids[i]<0){
                while(stk.size() >0 && stk.peek()>0 && stk.peek()<Math.abs(asteroids[i])){
                    stk.pop();
                }
                if(stk.size()==0){
                    stk.push(asteroids[i]);
                }else if(stk.peek()<0){
                    stk.push(asteroids[i]);
                }else if(stk.peek()>Math.abs(asteroids[i])){
                    //do nothing
                }else if(stk.peek()==Math.abs(asteroids[i])){
                    stk.pop();
                }
            }else if(asteroids[i]>0){
                stk.push(asteroids[i]);
            }
        }
        
        int[] res=new int[stk.size()];
        int idx=stk.size()-1;
        while(stk.size()>0){
            res[idx--]=stk.pop();
        }
        
        return res;
    }
}