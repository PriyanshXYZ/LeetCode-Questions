
class MyCalendar {
    List<Pair> event;
    public MyCalendar() {
        event=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(event.size()==0){
            event.add(new Pair(start,end));
            return true;
        }
        
        for(int i=0;i<event.size();i++){
            if(event.get(i).start<end && event.get(i).end>start){
                return false;
            }
        }
        event.add(new Pair(start,end));
        return true;
    }
    class Pair{
        int start;
        int end;
        
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */