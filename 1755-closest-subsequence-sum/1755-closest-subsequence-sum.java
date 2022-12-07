class Solution {
    
    private List<Integer> list;
    
    public int minAbsDifference(int[] nums, int goal) {
        list = new ArrayList<>();
        for (int x: nums) list.add(x);
        Collections.shuffle(list);

        int n = nums.length;
        
        TreeSet<Integer> first = new TreeSet<>();
        TreeSet<Integer> second = new TreeSet<>();
        
        generate(0, n / 2, 0, first);
        generate(n / 2, n, 0, second);
        
        int res = Integer.MAX_VALUE;
        
        for (int secSum: second) {
            int left = goal - secSum;
            
            Integer floor = first.floor(left);
            if (floor != null) res = Math.min(res, left - floor);
            
            Integer ceiling = first.ceiling(left);
            if (ceiling != null) res = Math.min(res, ceiling - left);
            
            if (res == 0) return 0;
        }
        
        return res;
    }
    
    private void generate(int i, int end, int sum, Set<Integer> sums) {
        if (i == end) {
            sums.add(sum);
            return;
        }
        
        generate(i + 1, end, sum + list.get(i), sums);
        generate(i + 1, end, sum, sums);
    }
}
class Solution1 {
    public int minAbsDifference(int[] nums, int goal) {
        List<Integer> set1 = new ArrayList();
        List<Integer> set2 = new ArrayList();
        int n=nums.length;
        dfs(0, n/2, 0, nums, set1);
        dfs(n/2, n, 0, nums, set2);
        
        Collections.sort(set2);
        int ans = Integer.MAX_VALUE;
        for(int lNum : set1){
            int left = goal - lNum;
            
            if(left<set2.get(0)){
                ans=Math.min(ans,Math.abs(set2.get(0)+lNum-goal));
                continue;
            }
            
            if(left>set2.get(set2.size()-1)){
                ans=Math.min(ans,Math.abs(set2.get(set2.size()-1)+lNum-goal));
                continue;
            }
            int pos=Collections.binarySearch(set2,left);
            if(pos>=0){//exact match
                return 0;
            }else{
                pos=-1*(pos+1);
                int low=pos-1;
                
                ans=Math.min(ans,Math.abs(set2.get(pos)+left-goal));//floor value
                ans=Math.min(ans,Math.abs(set2.get(low)+left-goal));//ceil value
            }
        }
        return (int)ans;
    }
    public void dfs(int start, int end, int sum, int[] nums, List<Integer> list){
        if(start==end){
            list.add(sum);
            return;
        }
        dfs(start+1, end, sum+nums[start], nums,list);//inc
        dfs(start+1, end, sum, nums,list);//exc
    }
}