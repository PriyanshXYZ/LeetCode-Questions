class Solution {
    public String reverseVowels(String s) {
        List<Character> list=new ArrayList();
        for(char ch:s.toCharArray()){
            char temp=(ch+"").toLowerCase().charAt(0);
            if(temp=='a'|| temp=='e' || temp=='i' || temp=='o' || temp=='u'){
                list.add(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            char temp=(ch+"").toLowerCase().charAt(0);
            if(temp=='a'|| temp=='e' || temp=='i' || temp=='o' || temp=='u'){
               sb.append(list.remove(list.size()-1));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
}