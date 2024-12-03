class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        int prevIdx = 0;
        for(int space : spaces){
            ans.append(s.substring(prevIdx,space));
            ans.append(" ");
            prevIdx = space;
        }
        ans.append(s.substring(prevIdx));
        return ans.toString();
    }
}