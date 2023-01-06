class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100005];
        
        int maxcost = 0;
        for(int cost : costs){
            freq[cost]++;
            maxcost = Math.max(maxcost , cost);
        }
        
        int maxCream = 0;
        for(int i= 1 ;i<=maxcost;i++){
            if(freq[i]==0)continue;
            
            if(i>coins)break;
            
            int val = i * freq[i];
            if(val <= coins){
                maxCream += freq[i];
                coins -= val;
            }else{
                int f= coins / i;
                maxCream += f;
                coins -= f*i;
            }
        }
        return maxCream;
    }
    
}