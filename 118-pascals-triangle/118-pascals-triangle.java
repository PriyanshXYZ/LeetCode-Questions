class Solution {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList();
        
        for(int i=1;i<=numRows;i++){
            List<Integer> row=new ArrayList();
            for(int j=0;j<i;j++){
                if(i==1){
                    row.add(1);
                    continue;
                }
                List<Integer> prev=ans.get(ans.size()-1);
                int a=j-1>=0?prev.get(j-1):0;
                int b=j<prev.size()?prev.get(j):0;
                row.add(a+b);
            }
            ans.add(row);
        }
        return ans;
    }
    
    
}