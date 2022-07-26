class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] end=new int[26];
        Arrays.fill(end,-1);
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            end[ch-'a']=i;
        }
        List<Integer> ans=new ArrayList();
        int strtPt=0,endPt=0;
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            endPt=Math.max(end[ch-'a'],endPt);
            
            if(endPt==i){
                ans.add(endPt-strtPt+1);
                strtPt=i+1;
            }
        }
        return ans;
    }
}