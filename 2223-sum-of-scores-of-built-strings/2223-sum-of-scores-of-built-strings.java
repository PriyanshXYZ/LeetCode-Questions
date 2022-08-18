class Solution {
    public long sumScores(String s) {
        int l=0,r=0;
        int n=s.length();
        
        int[] z=new int[n];
        for(int i=1;i<n;i++){
            if(i>r){
                l=r=i;
                
                while(r<n && s.charAt(r)==s.charAt(r-l)){
                    r++;
                }
                r--;
                z[i]=r-l+1;
            }else{
                int k=i-l;
                if(z[k]<r-i+1){
                    z[i]=z[k];
                }else{
                    l=i;
                    
                    while(r<n && s.charAt(r)==s.charAt(r-l)){
                        r++;
                    }
                    r--;
                    z[i]=r-l+1;
                }
            }
        }
        
        long ans=0;
        for(long val:z){
            ans+=val;
        }
        return ans+s.length();//for whole array also as a prefix
    }
}