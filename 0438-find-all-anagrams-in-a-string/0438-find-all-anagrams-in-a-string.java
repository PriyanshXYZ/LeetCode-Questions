class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length())return new ArrayList();
        List<Integer> res = new ArrayList();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char ch : p.toCharArray()){
            freq1[ch-'a']++;
        }
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq2[ch-'a']++;
            
            if(i >= p.length()-1){
                if(i-p.length()>=0){
                    char ch1 = s.charAt(i-p.length());    
                    freq2[ch1-'a']--;
                }
                
                boolean flag = true;
                for(int j=0;j<26;j++){
                    if(freq1[j]!=freq2[j]){
                        flag=false;
                        break;
                    }
                }  
                if(flag)res.add(i-p.length()+1);
            }
        }
        
        return res;
    }
}