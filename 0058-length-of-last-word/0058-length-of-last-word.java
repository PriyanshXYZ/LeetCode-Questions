class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        // for(String ss : split){
        //     System.out.print(ss+" ");
        // }
        // System.out.println();
        return split[split.length-1].length();
    }
}