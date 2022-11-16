/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long lo=0,hi=n;
        while(lo<=hi){
            long mid=(lo+hi)/2;
            int num=guess((int)mid);
            // System.out.println(num+" "+mid);
            if(num==0){
                return (int)mid;
            }else if(num==-1){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return (int)lo;
    }
}