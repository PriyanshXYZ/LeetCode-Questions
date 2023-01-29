class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if(k == 1|| k == n)return 0;
        
        List<Long> res = new ArrayList();
        for(int i=0;i<n-1;i++){
            res.add((long)weights[i]+(long)weights[i+1]);
        }
        
        long min = 0;
        Collections.sort(res);
        for(int i =0;i<k-1;i++)min+=res.get(i);
        
        Collections.reverse(res);
        long max =0;
        for(int i=0;i<k-1;i++)max+=res.get(i);
        
        return max - min;
    }
}