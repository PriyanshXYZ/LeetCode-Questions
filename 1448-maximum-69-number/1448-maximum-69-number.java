class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb=new StringBuilder(Integer.toString(num));
        int idx=0;
        while(idx<sb.length()){
            if(sb.charAt(idx)=='6'){
                sb.setCharAt(idx,'9');
                break;
            }
            idx++;
        }
        return Integer.parseInt(sb.toString());
    }
}