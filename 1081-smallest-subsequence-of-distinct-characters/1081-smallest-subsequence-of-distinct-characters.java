class Solution {
    public String smallestSubsequence(String s) {
        //make a freq array
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        //make a visited array which gets true if we add to stack
        //make a stack
        boolean[] visited=new boolean[26];
        Stack<Integer> stk=new Stack();
        
        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i)-'a';
            //skip if character is already inserted in the stack
            freq[curr]--;
            if(visited[curr]) continue;
            //pop the element when stack (not empty) when
            //1) curr element is smaller than stack's top (lexicograpically smaller)
            //2) there is element present in string after curr idx
            
            while(!stk.isEmpty() && curr<stk.peek() && freq[stk.peek()]>0){
                int popped=stk.pop();
                visited[popped]=false;
            }
            //if element cannot be popped then add to stack and do visited[curr]=true;
            stk.push(curr);
            visited[curr]=true;
        }
        StringBuilder sb=new StringBuilder();
        while(stk.size()>0){
            sb.append((char)(stk.pop()+'a'));
        }   
        return sb.reverse().toString(); 
    }
}