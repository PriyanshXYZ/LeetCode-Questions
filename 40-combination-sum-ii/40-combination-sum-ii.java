class Solution {
    List<List<Integer>> res=new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursion(0,candidates.length,candidates,target,new ArrayList());
        return res;
        
    }
    public void recursion(int idx,int n,int[] a,int target,List<Integer> list){
        
        if(target==0){
            res.add(new ArrayList(list));
            return;
        }else if(target<0){
            return;
        }
        if(idx>=n)return;
        for(int i=idx;i<n;i++){
            if(i>idx && a[i]==a[i-1])continue;//to skip duplicates
                list.add(a[i]);
                recursion(i+1,n,a,target-a[i],list);
                list.remove(list.size()-1);
        }

    }
}