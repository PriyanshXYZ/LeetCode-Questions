class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev=-1;
        int res=1;
        for(int i=0;i<seats.length;i++){
            int ans=0;
            if(seats[i]==1){
                
                if(prev==-1){
                    ans=i;
                }else{
                    ans=(i-prev)/2;
                }
                res=Math.max(res,ans);
                prev=i;
            }
        }
        if(prev!=seats.length-1){
            res=Math.max(res,seats.length-1-prev);
        }
        return res;
    }
}

class Solution1 {
    //tc O(n) and sc O(n)
    public int maxDistToClosest(int[] seats) {
        int n=seats.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Arrays.fill(left,n);
        Arrays.fill(right,n);
        
        
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                left[i]=0;
            }else if(i>0){
                left[i]=left[i-1]+1;
            }
        }
        
        for(int i=n-1;i>=0;i--){
            if(seats[i]==1){
                right[i]=0;
            }else if(i<n-1){
                right[i]=right[i+1]+1;
        
            }
        }
        
        int maxDist=0;
        for(int i=0;i<n;i++){
            int dist=Math.min(left[i],right[i]);
            maxDist=Math.max(dist,maxDist);
        }
        return maxDist;
    }
}