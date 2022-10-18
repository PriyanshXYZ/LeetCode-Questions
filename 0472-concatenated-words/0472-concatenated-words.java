class Solution {
    class Trie{
        boolean isEnd=false;
        Trie[] children=new Trie[26];
    }
    Trie root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root=new Trie();
        
        //create a trie node
        for(String str:words){
            Trie curr=root;
            for(char ch:str.toCharArray()){
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a']=new Trie();
                }
                curr=curr.children[ch-'a'];
            }
            curr.isEnd=true;
        }
        List<String> res=new ArrayList();
        for(String word:words){
            flag=false;
            wordCount(word,0,0);
            if(flag)res.add(word);
        }
        return res;
    }
    boolean flag;
    private void wordCount(String word,int idx,int count){
        if(idx==word.length()){
            if(count>=2){
                flag=true;
            }
            return;
        }
        Trie curr=root;
        for(int i=idx;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children[ch-'a']!=null){
                curr=curr.children[ch-'a'];
                if(curr.isEnd){
                    wordCount(word,i+1,count+1);
                }
            }else{
                return;
            }
            
        }
    }
}