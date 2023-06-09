class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for(char ch : letters){
            if(target!=ch)
            set.add(ch-'a');
        }
        
        Integer ch = set.ceiling(target-'a');
        
        if(ch!=null){
            return (char)(ch + 'a');
        }else{
            return letters[0];
        }
    }
}