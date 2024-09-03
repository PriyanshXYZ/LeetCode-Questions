class Solution {
    public int getLucky(String s, int k) {
        s =  cts(s);
        while(k-->0){
            
           s = sod(s)+"";
        }
        return Integer.parseInt(s);
    }
    
    private int sod(String s){
        int n = s.length();
        int i=0;
        int sum = 0;
        while(i<n){
            sum += (s.charAt(i)-'0');
            i++;
        }
        return sum;
    }
    
    private String cts(String s){
        int n = s.length();
        int i=0;
        String sum = "";
        while(i<n){
            sum += ((s.charAt(i)-'a')+1);
            i++;
        }
        return sum;
    }
    
    private String ctss(String s){
        int n = s.length();
        int i=0;
        String sum = "";
        while(i<n){
            sum += s.charAt(i);
            i++;
        }
        return sum;
    }
}