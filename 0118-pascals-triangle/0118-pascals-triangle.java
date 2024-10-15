class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=1;i<=numRows;i++){
            ans.add(new ArrayList<>());
            if(i == 1){
                ans.get(i-1).add(1);
            }else{
                for(int j=0;j<i;j++){
                    int valL = j>0?ans.get(i-2).get(j-1):0;
                    int valR = j<i-1?ans.get(i-2).get(j):0;
                    ans.get(i-1).add(valL+valR);
                }
            }
        }
        return ans;
    }
}