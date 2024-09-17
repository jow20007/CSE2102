package c;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import c.Hybrid;

public class TestCar {

	Hybrid hybridCar;

	public void configCar(double miles, double gallons, double kWh) {
        // config gas amount & miles
        hybridCar.setMilesfromGas(miles);
        hybridCar.setGallonsfromGas(gallons);

        // config electric amount & miles
        hybridCar.setElectricMiles(miles);
        hybridCar.setTotalkWh(kWh);
	}

	@Before
	public void setUp() throws Exception {
		hybridCar  = new Hybrid();
    }

	@Test
	public void MPGTest1() {
		configCar(337.0, 10.0, 0.0);
		double expected = 33.7;
		double actual = hybridCar.calcGasMPG();
		assertTrue(actual == expected);
	}

	@Test
	public void MPGTest2() {
		configCar(300.0, 15.0, 0.0);
		double expected = 20.0;
		double actual = hybridCar.calcGasMPG();
		assertTrue(actual == expected);
	}

	@Test
	public void MPGTest3() {
		configCar(100.0, 4.0, 0.0);
		double expected = 25.0;
		double actual = hybridCar.calcGasMPG();
		assertTrue(actual == expected);
	}

	@Test
	public void MPGeTest1() {
		configCar(337.0, 0.0, 33.7);
		double expected = 337.0;
		double actual = hybridCar.calcMPGe();
		assertTrue(actual == expected);
	}

	@Test
	public void MPGeTest2() {
		configCar(300.0, 0.0, 70);
		double expected = (300.0 / 70.0) * 33.7;
		double actual = hybridCar.calcMPGe();
		assertTrue(actual == expected);
	}

	@Test
	public void MPGeTest3() {
		configCar(100.0, 0.0, 67.4);
		double expected = 50.0;
		double actual = hybridCar.calcMPGe();
		assertTrue(actual == expected);
	}

	@Test
	public void MPGavgTest1() {
		configCar(337.0, 10.0, 33.7);
		double expected = (337.0 + 33.7) / 2;
		double actual = hybridCar.calcMPGavg();
		assertTrue(actual == expected);
	}

	@Test
	public void MPGavgTest2() {
		configCar(300.0, 15.0, 70);
		double expected = ((300.0 / 70.0) * 33.7 + 20.0) / 2;
		double actual = hybridCar.calcMPGavg();
		assertTrue(actual == expected);
	}

	@Test
	public void MPGavgTest3() {
		configCar(100.0, 4.0, 67.4);
		double expected = (50.0 + 25.0) / 2;
		double actual = hybridCar.calcMPGavg();
		assertTrue(actual == expected);
	}
}
