class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
//         PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
//             return b[0] - a[0];
//         });
        
//         heap.add(new int[] {nums[0], 0});
//         int ans = nums[0];
        
        
//         for (int i = 1; i < nums.length; i++) {
//             while (i - heap.peek()[1] > k) {
//                 heap.remove();
//             }
            
//             int curr = Math.max(0, heap.peek()[0]) + nums[i];
//             ans = Math.max(ans, curr);
//             heap.add(new int[] {curr, i});
//         }
        
//         return ans;
        Deque<Integer> q = new ArrayDeque<>();
        int[] dp = new int[nums.length];
        
        for(int i = 0;i < nums.length; i++){
            if(!q.isEmpty() && i - q.peek() > k){
                q.poll();
            }
            
            dp[i] = (!q.isEmpty() ? dp[q.peek()]:0)+nums[i];
            
            while(!q.isEmpty()&&  dp[q.peekLast()] < dp[i]){
                q.pollLast();
            }
            
            if(dp[i] > 0){
                q.add(i);
            }
        }
        
        int ans = Integer.MIN_VALUE;
        for(int num : dp){
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
//     public int recursion(int idx, int k, int[] nums, int sum){
//         if(idx==nums.length)return sum;
        
//         int take = recursion(idx + 1, k , nums, sum + nums[idx]);
//         int notTake = recursion(idx + 1, k , nums, sum );
        
//         return Math.max(take, notTake);
//     }
// }