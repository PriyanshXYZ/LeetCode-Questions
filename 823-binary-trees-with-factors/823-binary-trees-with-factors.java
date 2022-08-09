class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int mod =(int)(1e9+7);
        HashMap<Integer,Long> trees=new HashMap();
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            long count=1;
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && trees.containsKey(arr[i]/arr[j])){
                    count+=trees.get(arr[j])*trees.get(arr[i]/arr[j]);
                }
            }
            trees.put(arr[i],count);
        }
        // System.out.println(trees);
        long sum=0;
        for(int key:trees.keySet()){
            sum=(sum+trees.get(key))%mod;
        }
        
        return (int)sum;
    }
}