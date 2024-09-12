class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(char ch : allowed.toCharArray())set.add(ch);
        
        for(int i=0;i<words.length;i++){
            boolean flag = true;
            for(char ch : words[i].toCharArray()){
                if(!set.contains(ch)){
                    flag = false;
                    break;
                }
            }
            count += (flag?1:0);
        }
        return count;
    }
}