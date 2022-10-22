class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList();
        
        for(int i=1;i<=numRows;i++){
            List<Integer> row=new ArrayList();
            if(i==1){
                row.add(1);
                
            }else{
                List<Integer> prev=res.get(res.size()-1);
                for(int j=0;j<i;j++){
                    int a=j>0?prev.get(j-1):0;
                    int b=j<prev.size()?prev.get(j):0;
                    row.add(a+b);
                }
            }
            res.add(row);
        }
        return res;
    }
}