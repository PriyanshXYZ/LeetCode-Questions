class Solution {
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