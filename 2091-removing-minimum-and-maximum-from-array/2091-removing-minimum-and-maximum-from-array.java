class Solution {
    public int minimumDeletions(int[] a) {
        if(a.length==1)return 1;
        int n=a.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int minIdx=0;
        int maxIdx=0;
        for(int i=0;i<n;i++){
            if(a[i]<min){
                minIdx=i;
                min=a[i];
            }
            if(a[i]>max){
                maxIdx=i;
                max=a[i];
            }
        }
        //case 1=>min and max idx closer to 0
        //case 2=>min and max idx closer to n
        //case 3=>min and max idx are distinct
        if(minIdx==maxIdx){
            return 1;
        }else if(minIdx>maxIdx){
            int ans=maxIdx+1+(n-minIdx);
            
            ans=Math.min(ans,minIdx+1);
            
            ans=Math.min(ans,n-maxIdx);
            
            return ans;
        }else{
            int ans=minIdx+1+(n-maxIdx);
            
            ans=Math.min(ans,maxIdx+1);
            
            ans=Math.min(ans,n-minIdx);
            
            return ans;
        }
    }
}