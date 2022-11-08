class Solution {
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res=new ArrayList();
        for(int i=1;i<=9;i++){
            dfs(i,n);    
        }
        return res;
    }
    private void dfs(int num,int n){
        if(num>n)return;
        res.add(num);
        num=num*10;
        for(int i=0;i<=9;i++){
            dfs(num+i,n);
        }
    }
}