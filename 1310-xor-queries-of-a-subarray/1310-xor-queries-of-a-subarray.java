class Solution {
    public int[] xorQueries(int[] A, int[][] q) {
        int[] prefixXor = new int[A.length+1];
		 int ans =0;
		 for(int i=0;i<A.length;i++){
			 ans^=A[i];
			 prefixXor[i+1]=ans;
		 }
		 
		 int[] res = new int[q.length];
		 int idx=0;
		 for(;idx<q.length;idx++){
             int left = q[idx][0];
             int right = q[idx][1];
             if(left == 0)res[idx]=prefixXor[right+1];
             else
                 res[idx]=prefixXor[left]^prefixXor[right+1];
			 
		 }
		 return res;
    }
}