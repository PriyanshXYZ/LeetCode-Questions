class Solution {
    //faster code 
    public String minWindow(String a, String b) {
        if(b.length()>a.length())return "";
		
		int[] freqB = new int[256];
		int[] freqA = new int[256];
		
		for(char ch : b.toCharArray()){
			freqB[ch]++;
		}
		
		int minLen = Integer.MAX_VALUE;
		int strtIdx = -1;
		int cnt=0;
		for(int ei=0,si=0;ei<a.length();ei++){
			int ch1 =a.charAt(ei);
			freqA[ch1]++;
			if(freqA[ch1]<=freqB[ch1]){
				cnt++;
			}
			if(cnt==b.length()){
                //continue to shrink the subarray until we dont delete crucial element
				while(freqA[a.charAt(si)] > freqB[a.charAt(si)] || freqB[a.charAt(si)]==0){
					
					if(freqA[a.charAt(si)] > freqB[a.charAt(si)]){
						freqA[a.charAt(si)]--;
					}
					si++;
				}
				if(minLen > ei - si + 1){
					minLen = ei - si + 1;
					strtIdx = si;
				}
			}
		}
		if(strtIdx==-1)return "";
		else return a.substring(strtIdx,strtIdx+minLen);
    }
}
class Solution1 {
    //clean code...
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

class Solution2 {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())return "";
        
        Map<Character,Integer> mapT = new HashMap<>();
        for(char ch : t.toCharArray()){
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        
        Map<Character, Integer> mapS = new HashMap<>();
        int strtIdx=-1;
        int minLen = s.length()+1;
        int count = 0;
        
        for(int right = 0, left = 0; right <s.length(); right++){
            char ch = s.charAt(right);
            mapS.put(ch , mapS.getOrDefault(ch,0)+1);
            
            if(mapT.containsKey(ch) && mapS.get(ch) <= mapT.get(ch)){
                count++;
            }
            
            if(count == t.length()){//we got a subarray which has String t in it
                //try to reduce the size of subarray
                while(mapS.get(s.charAt(left))>mapT.getOrDefault(s.charAt(left),0) || mapT.getOrDefault(s.charAt(left),0)==0){
                    if(mapS.get(s.charAt(left))>mapT.getOrDefault(s.charAt(left),0)){
                        mapS.put(s.charAt(left),mapS.get(s.charAt(left))-1);
                    }
                    left++;
                }
                int windowLen = right - left + 1;
                if(minLen > windowLen){
                    minLen = windowLen;
                    strtIdx = left;
                }
            }
        }
        
        if(strtIdx==-1)return "";
        return s.substring(strtIdx,strtIdx+minLen);
    }
}