class Solution {
    public int balancedString(String s) {
        int[] map1=new int[26];
        Arrays.fill(map1,-s.length()/4);
        int extra=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map1[ch-'A']++;
            
            if(map1[ch-'A']>0){
                extra++;
            }
        }
        // System.out.println(extra);
        if(extra==0)return 0;
        //if there are extra character present we need to find min substring which contains cnt of these extra characters
        
        int[] map2=new int[26];
        int si=0;
        int count=0;
        int minLen=Integer.MAX_VALUE;
        for(int ei=0;ei<s.length();ei++){
            int idx=s.charAt(ei)-'A';
            map2[idx]++;
            if(map1[idx]>=map2[idx]){
                //element is one the extra element
                count++;
            }
            
            while(count==extra){
                int i=s.charAt(si)-'A';
                map2[i]--;
                
                if(map2[i]<map1[i]){
                    //decremented value was extra in string 
                    count--;
                }
                minLen=Math.min(minLen,ei-si+1);
                si++;
            }
            
        }
        return minLen;
        
    }
}