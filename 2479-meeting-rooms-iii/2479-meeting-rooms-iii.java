class Solution {
    /**
        [[0,10],[1,5],[2,7],[3,4]]
        0 -> 0,10
        1 -> 1,5

        if rooms are empty then we can just add meeting to that room
        use array for count of no of meeting in each room!
        but check that any occupied room doesnt become empty  
                => if i use array here i would have to lookup again and again for my answer which is not optimal
                  using a heap
        if room aren't available 
            => i will have to fill it to room whose meeting will be finished first
             using a heap
        problem  -> 2,7 has to wait until any room is not empty..

        merge start and end time => then 
     */
    public int mostBooked(int n, int[][] meetings) {
        long[] meetingCount = new long[n];
        Arrays.sort(meetings, (a, b) -> a[0]==b[0]?(a[1]-b[1]):(a[0]-b[0]));
        
        // sort on basis of which room will get empty first
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>(
                                                (a,b) -> a[0]==b[0]?Long.compare(a[1],b[1]):Long.compare(a[0],b[0]));//(endTime,idx) 
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();

        for(int i=0;i<n;i++) unusedRooms.add(i);
        
        for(int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
    
            //remove from queue all finished meeting
            while(!usedRooms.isEmpty() && usedRooms.peek()[0]<= start){
                int room = (int) usedRooms.remove()[1];
                unusedRooms.add(room);
            }

            // add current meeting into a room or wait
            if(!unusedRooms.isEmpty()){
                int room = unusedRooms.remove();
                usedRooms.add(new long[]{end, room});
                meetingCount[room]++;
            }else{
                long roomAvailabilityTime = usedRooms.peek()[0];
                int room = (int) usedRooms.remove()[1];
                usedRooms.add(new long[]{roomAvailabilityTime + end - start, room});
                meetingCount[room]++;
            }
        }

        int maxMeetingCount = 0;
        int maxMeetingCountRoom = 0;
        for(int i = 0;i < n; i++){
            
            if(meetingCount[i] > maxMeetingCount){
                maxMeetingCount =(int)meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }
        System.out.println();
        return maxMeetingCountRoom;

    }
}