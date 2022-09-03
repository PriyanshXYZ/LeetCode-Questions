class Solution {
    List<Integer> res;
    public int[] numsSameConsecDiff(int n, int k) {
        res=new ArrayList();
        for(int i=1;i<=9;i++){
            recursion(1,n,k,i);
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
    private void recursion(int idx,int n,int k,int num){
        if(idx==n){
            res.add(num);
            return;
        }
        
        int last=num%10;
        if(last+k<10)
            recursion(idx+1,n,k,num*10+(last+k));
        if(k!=0 && last>=k)
            recursion(idx+1,n,k,num*10+(last-k));
    }
}