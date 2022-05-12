class Solution {
    List<List<Integer>> res=new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(0,nums.length,nums,new ArrayList(),new boolean[nums.length]);
        return res;
    }
    
    public void backtrack(int idx,int n,int[] nums,List<Integer> list,boolean[] visited){
        if(idx==n){
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            visited[i]=true;
            list.add(nums[i]);
            backtrack(idx+1,n,nums,list,visited);
            visited[i]=false;
            list.remove(list.size()-1);
        }
    }
}