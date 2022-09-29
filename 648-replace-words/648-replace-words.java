class Solution {
    class Node{
        boolean end;
        String word;
        Node[] children=new Node[26];
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root=new Node();
        
        //creating a trie
        for(String val:dictionary){
            Node temp=root;
            for(char ch:val.toCharArray()){
                if(temp.children[ch-'a']==null){
                    temp.children[ch-'a']=new Node();
                }
                temp=temp.children[ch-'a'];
            }
            temp.end=true;
            temp.word=val;
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(String str:sentence.split(" ")){
            if(sb.length()>0){
                sb.append(" ");
            }
            
            Node temp=root;
            for(char ch:str.toCharArray()){
                if(temp.children[ch-'a']==null || temp.word!=null){
            
                    break;
                }
                temp=temp.children[ch-'a'];
            }
            sb.append(temp.word!=null?temp.word:str);
        }
        return sb.toString();
    }
}