class Solution {
    /**
        abcabcbb
                abcabcbb
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set =  new HashSet();
        int left =0, right =0;
        int ans = 0;
        while(right < n) {
            //to find if i have a duplicate!!
            char currChar = s.charAt(right);
            while(set.contains(currChar)){
                char prevChar = s.charAt(left);
                set.remove(prevChar);
                left++;
            }
            set.add(currChar);
            // whatever we have is unique in the set
            ans = Math.max(ans, set.size());
            right++;
        }
        return ans;
    }
}