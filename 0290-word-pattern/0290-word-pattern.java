class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map =new HashMap();
        HashMap<String,Character> m =new HashMap();
        String[] words = s.split(" ");
        if(pattern.length() != words.length)return false;
        
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(word))return false;
            }
            if(m.containsKey(word)){
                if(!m.get(word).equals(ch))return false;
            }
            map.put(ch,word);
            m.put(word,ch);
        }
        return true;
    }
}