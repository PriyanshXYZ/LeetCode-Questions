class Solution {
    List<List<Integer>> res=new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        recursion(1,k,n,new ArrayList());
        return res;
    }
    
    public void recursion(int idx,int size,int target,List<Integer> list){
        
        if(target==0 ){
            if(list.size()==size){
                res.add(new ArrayList(list));
                return;
            }else{
                return;
            }
        }else if(target<0)return;
        
        if(idx>9)return;
        
        for(int i=idx;i<=9;i++){
            list.add(i);
            recursion(i+1,size,target-i,list);
            list.remove(list.size()-1);
        }
    }
}

    