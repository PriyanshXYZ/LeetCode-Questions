class Solution {
    public boolean halvesAreAlike(String s) {
        int vowleft=0,vowright=0;
        int i=0,j=s.length()/2;
        while(i<s.length()/2){
            char ch1=s.charAt(i);
            char ch2=s.charAt(j);
            if(ch1=='a' || ch1=='e' || ch1=='i' ||ch1=='o' || ch1=='u' || ch1=='A' || ch1=='E' || ch1=='I' ||ch1=='O' || ch1=='U')vowleft++;
            if(ch2=='a' || ch2=='e' || ch2=='i' ||ch2=='o' || ch2=='u' || ch2=='A' || ch2=='E' || ch2=='I' ||ch2=='O' || ch2=='U')vowright++;
            i++;
            j++;
        }
        return vowleft==vowright;
    }
    
}