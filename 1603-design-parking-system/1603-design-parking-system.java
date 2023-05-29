class ParkingSystem {
    int cb;
    int cs;
    int cm;
    int big;
    int small;
    int medium;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.small = small;
        this.medium = medium;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
            if(cb<big){
                cb++;
                return true;
            }
            return false;
        }else if(carType == 2){
            if(cm<medium){
                cm++;
                return true;
            }
            return false;
        }else{
            if(cs<small){
                cs++;
                return true;
            }
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */