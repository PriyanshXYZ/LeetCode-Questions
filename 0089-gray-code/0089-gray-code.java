class Solution {
    
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList();
        res.add(0);
        res.add(1);
        
        for(int i=2;i<=n;i++){
            int size=res.size();
            for(int k=size-1 ;k>=0;k--){
                int val=res.get(k) | (1<<(i-1));
                res.add(val);
            }
        }
        
        return res;
    }
}