class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int val : piles)pq.add(val);
        int idx=0;
        for(int i=k;i >0; i--){
            int val = pq.remove();
            val = (val+1)/2;
            pq.add(val);
        }
        int sum = 0;
        while(pq.size()>0){
            sum += pq.remove();
        }
        return sum;
    }
}