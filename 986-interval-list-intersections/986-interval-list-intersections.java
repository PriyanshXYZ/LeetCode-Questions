class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0,j=0;
        ArrayList<int[]> ans=new ArrayList();
        while(i<firstList.length && j<secondList.length){
            int lo=Math.max(firstList[i][0],secondList[j][0]);
            int hi=Math.min(firstList[i][1],secondList[j][1]);
            
            if(lo<=hi){
                ans.add(new int[]{lo,hi});
            }
            
            if(firstList[i][1]<=secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}