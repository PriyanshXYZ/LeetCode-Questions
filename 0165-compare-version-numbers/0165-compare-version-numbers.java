class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        
        int idx1 = 0;
        int idx2 = 0;
        
        while(idx1<str1.length || idx2<str2.length){
            Integer res1 = Integer.parseInt(idx1<str1.length?str1[idx1]:"0");
            Integer res2 = Integer.parseInt (idx2<str2.length?str2[idx2]:"0");
            
            int val = res1.compareTo(res2);
            if(val!=0)return val;
            idx1++;
            idx2++;
        }
        return 0;
    }
    
}