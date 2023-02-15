class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> stk = new Stack<>();
        
        for(int i=0;i<words.length;i++){
            if(stk.isEmpty()){
                stk.push(words[i]);
            }else{
                while(i<words.length && isAnagram(stk.peek(),words[i])){
                    i++;
                }
                if(i<words.length)
                    stk.push(words[i]);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        while(stk.size()>0){
            res.add(stk.pop());
        }
        Collections.reverse(res);
        return res;
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