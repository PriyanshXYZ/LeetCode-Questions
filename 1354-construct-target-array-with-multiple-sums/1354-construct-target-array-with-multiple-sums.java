class Solution {
    public boolean isPossible(int[] target) {
        if(target.length==1)return target[0]==1;
        
        //max heap
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
        int sum=0;
        for(int item:target){
            pq.add(item);
            sum+=item;
        }
        
        while(pq.peek()!=1){
            int curr=pq.remove();
            // System.out.println(curr+"<- curr sum->"+sum);
            if(sum-curr==1)return true;
            
            
            int x=curr%(sum-curr);
            System.out.println(x);
            sum=sum-curr+x;
            
            if(x==0 || x==curr)return false;
            else{
                pq.add(x);
            }   
        }
        return true;
    }
}