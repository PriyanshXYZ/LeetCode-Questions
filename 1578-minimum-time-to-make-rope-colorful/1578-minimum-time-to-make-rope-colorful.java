class Solution {

    public int minCost(String colors, int[] neededTime) {
        int minCount=0;
        
        int n=colors.length();
        char[] c=colors.toCharArray();
        int i=0,j=0;
        while(j<n){
            int sum=0;
            int idx=0;
            int currMax=0;
            if(c[i]==c[j]){
                while(j<n && c[i]==c[j]){
                    sum+=neededTime[j];
                    if(currMax<neededTime[j]){
                        currMax=neededTime[j];
                        idx=j;
                    }
                    j++;
                }
                sum-=neededTime[idx];
                minCount+=sum;
                
            }else{
                i=j;
            }
            
        }
        return minCount;
    }
}