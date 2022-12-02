class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())return false;
        Integer[] f1=new Integer[26];
        Arrays.fill(f1,0);
        Integer[] f2=new Integer[26];
        Arrays.fill(f2,0);
        
        for(char ch:word1.toCharArray()){
            f1[ch-'a']++;
        }
        
        for(char ch:word2.toCharArray()){
            f2[ch-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(f1[i].equals(f2[i]))continue;
            if(f1[i]==0 || f2[i]==0)return false;
        }
        Arrays.sort(f1,Collections.reverseOrder());
        Arrays.sort(f2,Collections.reverseOrder());
        
        for(int i=0;i<26;i++){
            if(!f1[i].equals(f2[i])){
                // System.out.println(f1[i]+" "+f2[i]);
                // System.out.println("Freq k karan");
                return false;
            }
        }
        return true;
    }
}