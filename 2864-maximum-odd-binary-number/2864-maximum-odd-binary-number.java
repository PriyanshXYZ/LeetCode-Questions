class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt = bitCount(s);
        int size = s.length();
        StringBuilder res = new StringBuilder();
        // System.out.println(cnt);
        while(cnt>1){
            res.append('1');
            size--;
            cnt--;
        }
        while(size>1){
            res.append('0');
            size--;
        }
        res.append('1');
        return res.toString();
    }
    public int bitCount(String s){
        int cnt = 0;
        int idx = -1;
        while(idx++<s.length()-1){
            if(s.charAt(idx)=='1')cnt++;
        }
        return cnt;
    }
}