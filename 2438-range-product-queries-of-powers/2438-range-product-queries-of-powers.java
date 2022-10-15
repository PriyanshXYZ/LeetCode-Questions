class Solution {
    int mod=(int)(1e9+7);
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> temp = new ArrayList<>();
        List<Integer> power = new ArrayList<>();
        while(n > 0) {
            temp.add((int)n % 2);
            n /= 2;
        }

        for(int i = 0; i < temp.size(); i++) {
            if(temp.get(i) == 1) {
                int t = (int)Math.pow(2, i);
                power.add(t);
            }
        }
        
        int[] res=new int[queries.length];
        int idx=0;
        for(int[] query:queries){
            int lo=query[0];
            int hi=query[1];
            long ans=1;
            for(int i=lo;i<=hi;i++){
                ans=(ans%mod*power.get(i)%mod)%mod;    
            }
            res[idx++]=(int)ans;
        }
        return res;
    }
}