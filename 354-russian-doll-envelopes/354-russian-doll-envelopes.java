class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //sorting width
        Arrays.sort(envelopes, (a, b)->{
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }
        });
        // for(int i=0;i<envelopes.length;i++){
        //     System.out.println(envelopes[i][0]+","+envelopes[i][1]+" ");
        // }
        
        int[] lis=new int[envelopes.length];
        lis[0]=envelopes[0][1];
        int len=1;
        for(int i = 1; i < envelopes.length; i++){
            if(envelopes[i][1] > lis[len-1]){
                len++;
                lis[len-1]=envelopes[i][1];
            }else{
                int idx=Arrays.binarySearch(lis,0,len-1,envelopes[i][1]);
                if(idx<0){
                    idx=-idx;
                    idx=idx-1;
                }
                
                lis[idx]=envelopes[i][1];
            }
        }
        // for(int i=0;i<len;i++){
        //     System.out.print(lis[i]+" ");
        // }
        // System.out.println();
        return len;
    }
}