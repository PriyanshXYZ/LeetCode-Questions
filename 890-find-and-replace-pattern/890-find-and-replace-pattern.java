class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res=new ArrayList();
        int n=words.length;
        for(int i=0;i<n;i++){
            if(match(pattern,words[i]))res.add(words[i]);
        }
        return res;
    }
    
    public boolean match(String s,String p){
        if(s.length()!=p.length())return false;
        HashMap<Character,Character> s1=new HashMap();
        HashMap<Character,Character> p1=new HashMap();
        int n=s.length();
        for(int i=0;i<n;i++){
            char chs=s.charAt(i);
            char chp=p.charAt(i);
            if(!s1.containsKey(chs))s1.put(chs,chp);
            if(!p1.containsKey(chp))p1.put(chp,chs);
            
            if(s1.get(chs)!=chp || p1.get(chp)!=chs){
                return false;
            }
        }
        return true;
    }
}