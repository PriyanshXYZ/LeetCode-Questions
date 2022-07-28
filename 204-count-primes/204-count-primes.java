class Solution {
    public int countPrimes(int n) {
        if(n<2)return 0;
        boolean[] a=new boolean[n+1];
        Arrays.fill(a,true);
        for(int div=2;div<=n;div++){
            for(int fa=2;div*fa<=n;fa++){
                if(a[div*fa]==true){
                    a[div*fa]=false;
                }else{
                    continue;
                }
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