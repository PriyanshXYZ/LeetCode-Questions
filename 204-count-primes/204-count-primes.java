class Solution {
    public int countPrimes(int n) {
        if(n<2)return 0;
        boolean[] a=new boolean[n+1];
        Arrays.fill(a,true);
        for(int div=2;div*div<=n;div++){
            
            if(a[div]==false)continue;
            
            for(int fa=div;div*fa<=n;fa++){
                a[div*fa]=false;
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(a[i]){
                count++;
            }
        }
        return count;
    }
}