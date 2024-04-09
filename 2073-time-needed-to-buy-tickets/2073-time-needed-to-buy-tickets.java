class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int idx = 0;
        while(tickets[k]>0){
            if(tickets[idx]>0){
                tickets[idx]--;
                ans++;
            }
            idx=(idx+1)%tickets.length;
        }
        return ans;
    }
}