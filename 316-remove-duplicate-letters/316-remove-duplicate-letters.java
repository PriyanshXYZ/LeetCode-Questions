class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] alphaFreq = new int[26];
        for(char ch : s.toCharArray()){
            alphaFreq[ch - 'a']++;
        }
        
        boolean[] seen = new boolean[26];
        Stack<Character> stk=new Stack();
        
        for(char ch : s.toCharArray()){
            
            alphaFreq[ch-'a']--;
            
            if(seen[ch-'a']==true)continue;
            while(stk.size()>0 && alphaFreq[stk.peek()-'a']>0 && ch<stk.peek()){
                seen[stk.peek()-'a']=false;
                stk.pop();
            }
            seen[ch-'a']=true;
            stk.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(stk.size()!=0){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}