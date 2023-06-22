class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int cost;
        
        public int compareTo(Pair o){
            return this.num-o.num;
        }
    }
    public long minCost(int[] nums, int[] cost) {
        Pair[] a=new Pair[nums.length];
        int n =nums.length;
        for(int i=0;i<nums.length;i++){
            Pair p=new Pair();
            p.num=nums[i];
            p.cost=cost[i];
            a[i]=p;
        }
        Arrays.sort(a);
        
        
        long[] costL=new long[n];
        costL[0]=a[0].cost;
        for(int i=1;i<n;i++){
            costL[i]=a[i].cost + costL[i-1];
        }
        
        long total = 0;
        for(int i = 1; i < n; i++){
            total += 1l*  a[i].cost * (a[i].num - a[0].num);
        }
        
        long ans = total ; 
        for(int i=1;i<n;i++){
            int gap = a[i].num - a[i-1].num;
            total += 1l * costL[i - 1] * gap;
            total -= 1l * (costL[n-1] - costL[i-1]) * gap;
            
            ans = Math.min(total, ans);
        }
        return ans;
    }
}