package c;

public class HybridCar {

    public static void main(String[] args) {
        Hybrid aHybrid = new Hybrid();
        double miles = 300;

        // 1.
        aHybrid.setMilesfromGas(miles);
        aHybrid.setGallonsfromGas(10);

        double MPG = aHybrid.calcGasMPG();
        System.out.println(MPG);


        // 2.
        aHybrid.setElectricMiles(miles);
        aHybrid.setTotalkWh(70.0);
        
        double MPGe = aHybrid.calcMPGe();
        System.out.println(MPGe);

        // 3.
        double avgMPG = (MPG + MPGe) / 2;
        System.out.println(avgMPG);
    }

}