class Solution {
    class Node{
        boolean end;
        Node[] children=new Node[26];
    }
    Node root;
    String ans;
    public String longestWord(String[] words) {
        
        root=new Node();
        construct(words);
        
        ans="";
        dfs(root,new StringBuilder());
        return ans;
    }
    
    public void dfs(Node node,StringBuilder sb){
        if(sb.length()>ans.length()){
            ans=sb.toString();
        }
        for(int i=0;i<26;i++){
            Node child=node.children[i];
            if(child!=null && child.end==true){
                char ch=(char)(i+'a');
                sb.append(ch);
                dfs(child,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public void construct(String[] words){
        
        for(String word:words){
            Node temp=root;
            for(char ch:word.toCharArray()){
                if(temp.children[ch-'a']==null){
                    temp.children[ch-'a']=new Node();
                }
                temp=temp.children[ch-'a'];
            }
            temp.end=true;
        }
    }
}