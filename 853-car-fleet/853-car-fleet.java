class Solution {
    //question similar to merge interval...
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] c=new Car[speed.length];
        
        for(int i=0;i<speed.length;i++){
            c[i]=new Car(position[i],speed[i]);
        }
        Arrays.sort(c);
        
        
        double timeToReach=0;
        int group=0;
        for(int i=0;i<speed.length;i++){
            double curTime=(double)(target-c[i].pos) / c[i].speed;
            
            if(curTime>timeToReach){
                timeToReach=curTime;
                group++;
            }
        }
        return group;
    }
    class Car implements Comparable<Car>{
        int pos;
        int speed;
        
        Car(int pos,int speed){
            this.pos=pos;
            this.speed=speed;
        }
        @Override
        public int compareTo(Car o){
            return o.pos-this.pos;
        }
    }
}