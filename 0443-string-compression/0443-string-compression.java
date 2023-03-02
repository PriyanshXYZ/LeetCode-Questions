class Solution {
    public int compress(char[] chars) {
        if(chars.length==1)return 1;
        List<StringBuilder> list = new ArrayList<>();
        int i=0;
        for(;i<chars.length-1;i++){
            int len = 1;
            while(i<chars.length-1 && chars[i+1]==chars[i]){
                i++;
                len++;
            }
            if(len>1)
                list.add(new StringBuilder(chars[i]+""+len));
            else
                list.add(new StringBuilder(chars[i]+""));
        }
        
        if(i<chars.length && chars[i]!=chars[i-1]){
            list.add(new StringBuilder(chars[i]+""));
        }
        
        int len = 0;
        int idx=0;
        for(StringBuilder s : list){
            len += s.length();
            for(char ch : s.toString().toCharArray()){
                chars[idx]=ch;
                idx++;    
            }
            
        }
        return len;
    }
}