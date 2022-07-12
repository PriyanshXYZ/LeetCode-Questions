class Solution {
    
    public boolean makesquare(int[] matchsticks) {
        int n=matchsticks.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=matchsticks[i];
        }
        if(sum%4!=0){
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return recursion(matchsticks,0,sum/4,new int[4]);
    }
    public boolean recursion(int[] a,int idx,int target,int[] sum ){
        if(idx==a.length){
            if(sum[0]==target && sum[1]==target && sum[2]==target){
                return true;
            }else{
                return false;
            }
        }
        
        for(int i=0;i<4;i++){
            if(sum[i]+a[idx]>target){
                continue;
            }
            sum[i]+=a[idx];
            if(recursion(a,idx+1,target,sum))return true;
            sum[i]-=a[idx];
        }
        return false;
    }
    private void reverse(int[] a){
        int i=0,j=a.length-1;
        while(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
    }
}