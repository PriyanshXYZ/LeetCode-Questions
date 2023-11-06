class SeatManager {
    PriorityQueue<Integer> availableSeats;
    int table;
    public SeatManager(int n) {
        table = 1;
        availableSeats = new PriorityQueue<>();
    }
    
    public int reserve() {
        if(availableSeats.size()!=0){
            return availableSeats.remove();
        }
        int seatNumber = table;
        table++;
        return seatNumber;
    }
    
    public void unreserve(int seatNumber) {
        availableSeats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */