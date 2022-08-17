class Solution {
    String[] morseCode=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                            "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        
        HashSet<String> map=new HashSet();
        for(String word:words){
            String code="";
            for(char ch:word.toCharArray())
                code+=morseCode[ch-'a'];
            map.add(code);
        }
        return map.size();
    }
}