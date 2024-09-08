package u;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import c.Hybrid;

public class TestCar {

	Hybrid hybridCar;

	@Before
	public void setUp() throws Exception {
		hybridCar  = new Hybrid();
        double miles = 337.0;
        double gasGal = 10.0;
        double kWh = 337.0;

        // config gas amount & miles
        hybridCar.setMilesfromGas(miles);
        hybridCar.setGallonsfromGas(gasGal);

        // config electric amount & miles
        hybridCar.setElectricMiles(miles);
        hybridCar.setTotalkWh(kWh);
    }

	@Test
	public void MPGTest() {
		double expected = 33.7;
		double actual = hybridCar.calcGasMPG();
		assertTrue(actual == expected);
	}

	@Test
	public void MPGeTest() {
		double expected = 33.7;
		double actual = hybridCar.calcMPGe();
		System.out.println(actual);
		assertTrue(actual == expected);
	}

	@Test
	public void MPGavgTest() {
		double expected = 33.7;
		double actual = hybridCar.calcMPGavg();
		System.out.println(actual);
		assertTrue(actual == expected);
	}
}
