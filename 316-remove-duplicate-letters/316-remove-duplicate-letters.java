class Solution {
    public String removeDuplicateLetters(String s) {
        int[] alphabetFreq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            alphabetFreq[ch-'a']++;
        }
        boolean[] seen=new boolean[26];
        Stack<Integer> stk=new Stack();
        
       
        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i)-'a';
            alphabetFreq[curr]--;
            if(seen[curr])continue;
            while(!stk.isEmpty() && curr<stk.peek() && alphabetFreq[stk.peek()]>0){
                int popped=stk.pop();
                seen[popped]=false;
                
            }
            stk.push(curr);
            seen[curr]=true;
        }
         StringBuilder sb=new StringBuilder();
        while(stk.size()>0){
            sb.append((char)(stk.pop()+'a'));
        }
        return sb.reverse().toString();
    }
}