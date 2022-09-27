class Solution {
    class Pair{
        char ch;
        int idx;
        Pair(char ch,int idx){
            this.ch=ch;
            this.idx=idx;
        }
    }
    public String pushDominoes(String dominoes) {
        StringBuilder sb=new StringBuilder();
        
        sb.append('L');
        for(char ch: dominoes.toCharArray())sb.append(ch);
        sb.append('R');
        Pair prev=new Pair('L',0);
        for(int i=1;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch=='L'){
                if(prev.ch=='L'){
                    // l l
                    int idx=prev.idx+1;
                    while(idx<i){
                        sb.setCharAt(idx,'L');
                        idx++;
                    }
                }else{
                    int dist=i-prev.idx-1;
                    int j=prev.idx+1;
                    int idx=dist/2+j;
                    if(dist%2==0){
                        while(j<i){
                            if(j<idx)
                                sb.setCharAt(j,'R');
                            else
                                sb.setCharAt(j,'L');
                            j++;
                        }
                    }else{
                        while(j<i){
                            if(j<idx)
                                sb.setCharAt(j,'R');
                            else if(j>idx)
                                sb.setCharAt(j,'L');
                            j++;
                        }
                    }
                }
                prev=new Pair(ch,i);
            }else if(ch=='R'){
                if(prev.ch=='R'){
                    int idx=prev.idx;
                    while(idx<i){
                        sb.setCharAt(idx,'R');
                        idx++;
                    }
                }
                prev=new Pair(ch,i);
            }
        }
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}