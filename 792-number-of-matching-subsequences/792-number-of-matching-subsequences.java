class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,Queue<String>> map=new HashMap();
        
        for(int i=0;i<s.length();i++){
            map.putIfAbsent(s.charAt(i),new ArrayDeque());
        }
        
        //filling the word in queue 
        for(String word: words){
            char ch=word.charAt(0);
            if(map.containsKey(ch)){
                map.get(ch).add(word);
            }
        }
        
        int count=0;
        for(char startChar:s.toCharArray()){
            Queue<String> q=map.get(startChar);
            int size=q.size();
            for(int k=0;k<size;k++){
                String str=q.remove();
                if(str.length()!=1){
                    if(map.containsKey(str.charAt(1)))
                        map.get(str.charAt(1)).add(str.substring(1));
                }else{
                    count++;
                }
            }
            
        }
        return count;
    }
}