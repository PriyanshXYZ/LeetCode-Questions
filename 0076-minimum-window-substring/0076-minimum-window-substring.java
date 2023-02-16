class Solution {
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