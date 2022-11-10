class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int n=brackets.length;
        double tax=0;
        long sum=0;
        long prev=0;
        for(int i=0;i<brackets.length;i++){
            long diff=brackets[i][0]-prev;
            sum+=diff;
            if(sum>income){
                tax+=(income-prev)*(0.01*brackets[i][1]);
                break;
            }
            tax+=diff*(0.01*brackets[i][1]);
            prev=brackets[i][0];
        }
        return tax;
    }
}