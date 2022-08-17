class Solution {
    String[] morseCode=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                            "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        
        HashMap<String,Integer> map=new HashMap();
        for(String word:words){
            String code="";
            for(char ch:word.toCharArray())
                code+=morseCode[ch-'a'];
            map.put(code,map.getOrDefault(code,0)+1);
        }
        return map.size();
    }
}