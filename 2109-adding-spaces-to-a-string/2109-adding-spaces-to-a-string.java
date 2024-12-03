class Solution {
    public String addSpaces(String s, int[] spaces) {
        List<String> split = new ArrayList<>();
        int prevIdx = 0;
        for(int space : spaces){
            split.add(s.substring(prevIdx,space));
            prevIdx = space;
        }
        split.add(s.substring(prevIdx));
        return String.join(" ", split);
    }
}