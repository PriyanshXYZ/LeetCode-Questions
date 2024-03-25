class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long[] ans = new long[queries.length];
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->{
            if(a.getKey()-b.getKey()==0)return a.getValue() - b.getValue();
            return a.getKey()-b.getKey();
        });
        long sum = 0;
        int idx = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            sum += num;
            pq.add(new Pair(num,idx));
            idx++;
        }
        
        idx = 0;
        for(int[] q : queries){
            int iddx = q[0];
            if(!set.contains(iddx)){
                sum -= nums[iddx];
                
            }
            set.add(iddx);
            pq.remove(new Pair(nums[iddx],iddx));
            int val = q[1];
            
            while(pq.size()>0 && val-- >0){
                Pair p = pq.remove();
                set.add((int)p.getValue());
                sum -= (int)p.getKey();
            }
            ans[idx++] = sum<0?0:sum;
        }
        return ans;
    }
}