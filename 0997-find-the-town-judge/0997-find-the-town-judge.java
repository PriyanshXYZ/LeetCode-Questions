class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n+1];
        
        for(int[] t : trust){
            int a = t[0];
            int b = t[1];
            
            score[a]--;
            score[b]++;
        }
        
        for(int i = 1 ;i<=n;i++){
            if(score[i]==n-1)return i;
        }
        return -1;
    }
}
class Solution1 {
    public int findJudge(int n, int[][] trust) {
        if(n==1)return 1;
        HashMap<Integer,Integer> trustedBy = new HashMap<>();
        HashMap<Integer,Integer> trusts = new HashMap<>();
        int person = 0;
        int maxTrusted = 0;
        for(int[] t : trust){
            int a = t[0];
            int b = t[1];
            trusts.put(a,trusts.getOrDefault(a,0)+1);
            trustedBy.put(b,trustedBy.getOrDefault(b,0)+1);
            if(maxTrusted < trustedBy.get(b)){
                maxTrusted = trustedBy.get(b);
                person = b;
            }
                
        }
        if(maxTrusted == n-1 && trusts.getOrDefault(person,0)==0)return person;
        return -1;
    }
}