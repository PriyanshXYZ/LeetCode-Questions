class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap();
        HashSet<Character> tused=new HashSet();
        
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            
            if(map.containsKey(ch1)==false){
                if(tused.contains(ch2)==false){
                    map.put(ch1,ch2);
                    tused.add(ch2);
                }else{
                    return false;
                }
            }else{
                if(map.get(ch1)!=ch2){
                    return false;
                }
            }
        }
        return true;
    }
}