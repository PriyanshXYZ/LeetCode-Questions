class Solution {
    public int vowelConsonantScore(String s) {
        int c = 0;
        int v = 0;

        for(char ch : s.toCharArray()) {
            if(Character.isAlphabetic(ch)) {
                if(ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o'|| ch == 'u') {
                    v++;
                }else {
                    c++;
                }
            }
        }

        if(c == 0) return 0;
        return (int)Math.floor(v/c);
    }
}