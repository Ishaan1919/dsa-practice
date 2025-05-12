public class DesignParkingSystem {
    class ParkingSystem {

        int[] arr = new int[3];
    
        public ParkingSystem(int big, int medium, int small) {
            arr[0] = big;
            arr[1] = medium;
            arr[2] = small;
        }
        
        public boolean addCar(int carType) {
            for(int i=1;i<=3;i++){
                if(i==carType && arr[i-1]>0){
                    arr[i-1]--;
                    return true;
                }
            }
            return false;
        }
    }
}
