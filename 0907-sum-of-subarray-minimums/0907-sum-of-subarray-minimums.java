class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nsl=nsl(arr);
        int[] nsr=nsr(arr);
        
        int mod=(int)(1e9+7);
        
        long ans=0;
        for(int i=0;i<arr.length;i++){
            long temp=(long)((i-nsl[i])*(nsr[i]-i))%mod;
            ans=(ans%mod+(temp*arr[i])%mod)%mod;
        }
        return (int)ans;
    }
    
    public int[] nsl(int[] arr){
        int n=arr.length;
        int[] res=new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stk=new Stack();
        
        for(int i=0;i<n;i++){
            while(stk.size()>0 && arr[stk.peek()]>=arr[i]){
                stk.pop();
            }
            if(stk.size()>0){
                res[i]=stk.peek();
            }
            stk.push(i);
        }
        return res;
    }
    
    public int[] nsr(int[] arr){
        int n=arr.length;
        int[] res=new int[n];
        Arrays.fill(res,n);
        Stack<Integer> stk=new Stack();
        
        for(int i=n-1;i>=0;i--){
            while(stk.size()>0 && arr[stk.peek()]>arr[i]){
                stk.pop();
            }
            if(stk.size()>0){
                res[i]=stk.peek();
            }
            stk.push(i);
        }
        return res;
    }
}