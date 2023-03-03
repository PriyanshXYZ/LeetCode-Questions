class Solution {
    public int[] xorQueries(int[] A, int[][] queries) {
        int[] prefixXor = new int[A.length+1];
		 int ans =0;
		 for(int i=0;i<A.length;i++){
			 ans^=A[i];
			 prefixXor[i+1]=ans;
		 }
		 
		 int[] res = new int[queries.length];
		 int idx=0;
		 for(int[] q : queries){
			 res[idx]=prefixXor[q[0]]^prefixXor[q[1]+1];
			 idx++;
		 }
		 return res;
    }
}