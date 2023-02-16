class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            String s1 = i>0?words[i-1]:"";
            String s2 = words[i];
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            if(ch1.length!=ch2.length){
                list.add(words[i]);
                continue;
            }
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            
            s1=Arrays.toString(ch1);
            s2=Arrays.toString(ch2);
            if(!s1.equals(s2)){
                list.add(words[i]);
            }
        }
        return list;
    }
    public boolean isAnagram(String a, String b){
        int[] map = new int[26];
        for(char ch : a.toCharArray()){
            map[ch-'a']++;
        }
        
        for(char ch : b.toCharArray()){
            map[ch-'a']--;
        }
        
        for(int i=0;i<26;i++){
            if(map[i]!=0){
                //so they are not anagram
                return false;
            }
        }
        return true;
    }
}