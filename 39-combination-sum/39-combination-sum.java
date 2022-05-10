class Solution {
    List<List<Integer>> res=new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            recursion(0,candidates.length,candidates,target,new ArrayList());
            return res;
        
    }
    public void recursion(int idx,int n,int[] a,int target,List<Integer> list){
        if(idx==n){
            if(target==0){
                res.add(new ArrayList(list));
                return;
            }else if(target<0){
                return;
            }
        }else{
            if(target-a[idx]>=0){
                list.add(a[idx]);
                recursion(idx,n,a,target-a[idx],list);
                list.remove(list.size()-1);
            }
            recursion(idx+1,n,a,target,list);    
            return;
        }
        
        
        
        
        
    }
}