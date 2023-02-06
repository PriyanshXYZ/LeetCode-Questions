class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length())return new ArrayList();
        List<Integer> res = new ArrayList();
        char[] arr =p.toCharArray();
        Arrays.sort(arr);
        p = String.valueOf(arr);
        // System.out.println(p);
        for(int i=p.length();i<=s.length();i++){
            String substr = s.substring(i-p.length(),i);
            arr = substr.toCharArray();
            Arrays.sort(arr);
            String a = String.valueOf(arr);
            // System.out.println(a);
            if(a.equals(p))res.add(i-p.length());
        }
        return res;
    }
}