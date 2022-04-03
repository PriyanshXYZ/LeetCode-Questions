class Solution {
   
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList();
        List<Integer> temp=new ArrayList();
        backtrack(ans,temp,nums);
        return ans;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> temp,int[] a){
        if(temp.size()==a.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<a.length;i++){
            if(temp.contains(a[i]))continue;
            temp.add(a[i]);
            backtrack(res,temp,a);
            temp.remove(temp.size()-1);
        }
    }
}