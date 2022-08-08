class ParkingSystem {
    // enum VehicleType {
    //     int SMALL;
    //     int MEDIUM;
    //     int BIG;
    // }
    private static int BIG;
    private static int MEDIUM;
    private static int SMALL;
    public ParkingSystem(int big, int medium, int small) {
        this.BIG = big;
        this.MEDIUM = medium;
        this.SMALL = small;
    }
    
    public boolean addCar(int carType) {
        switch(carType) {
            case 1:
                return addBigCar();
            case 2:
                return addMediumCar();
            case 3:
                return addSmallCar();
            default:
                throw new IllegalArgumentException();
        }
    }
    private boolean addBigCar() {
        if (BIG > 0) {
            BIG--;
            return true;
        }
        return false;
    }
    private boolean addMediumCar() {
        if (MEDIUM > 0) {
            MEDIUM--;
            return true;
        }
        return false;
    }
    private boolean addSmallCar() {
        if (SMALL > 0) {
            SMALL--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */