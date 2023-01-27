class Solution {
    //can be solved with dp as well
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> res = new ArrayList<>();
        
        for(String word : words){
            Boolean[] dp = new Boolean[word.length()+1];
            wordSet.remove(word);
            if(memo(0, word, wordSet,dp)){
                res.add(word);
            }else wordSet.add(word);
        }
        return res;
    }
    
    public boolean memo(int strtIdx, String word, Set<String> wordSet, Boolean[] dp){
        if(wordSet.size()==0)return false;
        
        if(strtIdx ==  word.length())return true;
        
        if(dp[strtIdx] != null)return dp[strtIdx];
        
        for(int endIdx = strtIdx + 1 ; endIdx <= word.length() ; endIdx++){
            String prefix =word.substring(strtIdx,endIdx);
            String suffix = word.substring(endIdx);
            if((wordSet.contains(prefix) && wordSet.contains(suffix)) || 
              (wordSet.contains(prefix) && memo(endIdx , word , wordSet , dp))){
                dp[strtIdx]=true;
                return true;
            }
        }
        dp[strtIdx]=false;
        return false;
    }
}
class Solution1 {
    class Trie{
        boolean isEnd = false;
        Trie[] child = new Trie[26];
    }
    Trie root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Trie();
        
        for(String word : words){
            Trie node = root;
            for(char ch : word.toCharArray()){
                if(node.child[ch - 'a'] == null){
                    node.child[ch - 'a'] = new Trie();
                }
                node = node.child[ch-'a'];
            }
            node.isEnd=true;
        }
        
        List<String> res = new ArrayList();
        
        for(String word : words){
            if(dfs(0,word,0)){
                res.add(word);
            }
        }
        return res;
    }
    public boolean dfs(int idx, String word,int count){
        if(idx == word.length()){
            return count>=2;
        }
        
        //if we move at end 
        //option 1 -> explore in the node
        //option 2 -> explore at other node from start
        Trie temp = root;
        
        
        
        for(int i = idx; i < word.length(); i++){
            char ch = word.charAt(i);
            if(temp.child[ch - 'a']!=null){
                temp = temp.child[ch - 'a'];
                if(temp.isEnd){
                    if(dfs(i + 1, word, count + 1)){
                        return true;
                    }
                }
            }else break;
        }
        
        
        return false;
    }
}