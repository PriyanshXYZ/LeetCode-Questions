class Solution1{
    //nlogn tc and n sc
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int total = 0;
        for (int[] course : courses) {
            int dur = course[0], end = course[1];
            if (dur + total <= end) {
                total += dur;
                
                pq.add(dur);
            } else if (pq.size() > 0 && pq.peek() > dur) {
                
                total += dur - pq.poll();
                pq.add(dur);
            }
        }
        return pq.size();
    }
}
class Solution{
    public int scheduleCourse(int[][] courses) {
        int n=courses.length;
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        int time=0;
        int count=0;
        for(int i=0;i<n;i++){
            int dur=courses[i][0],last=courses[i][1];
            if(dur+time<=last){
                time+=dur;
                count++;
            }else{
                int prev_max=i;
                for(int j=0;j<i;j++){
                    if(courses[j][0]>courses[prev_max][0]){
                        prev_max=j;
                    }
                }
                if(courses[prev_max][0]>courses[i][0]){
                    time+=courses[i][0]-courses[prev_max][0];
                }
                courses[prev_max][0]=-1;
            }
        }
        return count;
    }
}
class Solution2 {
    //tle memory also exceeded
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->(a[1]-b[1]));
        int maxSize=courses[courses.length-1][1];
        Integer[][] dp=new Integer[courses.length][maxSize+1];
        return memo(courses,0,0,dp);
    }
    
    public int memo(int[][] courses,int idx,int time,Integer[][] dp){
        //base case
        if(idx==courses.length)return 0;
        if(dp[idx][time]!=null)return dp[idx][time];
        int taken=0;
        if(time+courses[idx][0]<=courses[idx][1]){
            taken=1+memo(courses,idx+1,time+courses[idx][0],dp);
        }
        int not_taken=memo(courses,idx+1,time,dp);
        
        int max=Math.max(taken,not_taken);
        return dp[idx][time]=max;
    }
}