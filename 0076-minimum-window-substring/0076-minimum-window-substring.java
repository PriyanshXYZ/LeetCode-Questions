class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())return "";
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        for(int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right))>=0){
                    count++; // increase count if there is a character from t string
                }
                //when we reach a point where there is count=length of t
                while(count==t.length()){
                    if(right-left+1<minLen){
                        minLeft=left;
                        minLen=right-left+1;
                    }
                    
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left))>0){//valid character which affects the ans
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minLen>s.length())return "";
        return s.substring(minLeft,minLeft+minLen);
    }
}