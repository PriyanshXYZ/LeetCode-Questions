class MyCalendarThree {
    
    TreeMap<Integer,Integer> line;
    public MyCalendarThree() {
        line=new TreeMap();
    }
    
    public int book(int start, int end) {
        line.put(start,line.getOrDefault(start,0)+1);
        line.put(end,line.getOrDefault(end,0)-1);
        int mx = 0, cnt = 0;
        for (int x : line.values()) {
            // here we calculate the prefix sum
            cnt += x;
            // and record the maximum overlapping intervals
            mx = Math.max(mx, cnt);
        }
        return mx;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */