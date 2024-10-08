package pizza;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestPizzaFactory {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	PizzaFactory pizzaFactory;

	@Before
	public void setUp() throws Exception {
		pizzaFactory  = new PizzaFactory();
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
    }

	@After
	public void reset() {
		System.setOut(originalOut);
		System.setErr(originalErr);
    }

	@Test
	public void SysOutTest() {
		String testStr = "Hello world";
		System.out.print(testStr);
		assertEquals(outContent.toString(), testStr);
	}

	@Test
	public void PizzaTest() {
		Pizza pizzaObj = new CheesePizza();
		assertTrue(pizzaObj instanceof CheesePizza);
	}

	@Test
	public void PizzaFactoryCreateCheeseTest() {
		Pizza pizzaObj = pizzaFactory.createPizza("CHEESE");
		assertTrue(pizzaObj instanceof CheesePizza);
	}

	@Test
	public void PizzaFactoryCreateGreekTest() {
		Pizza pizzaObj = pizzaFactory.createPizza("GREEK");
		assertTrue(pizzaObj instanceof GreekPizza);
	}

	@Test
	public void PizzaFactoryCreateGlutenFreeTest() {
		Pizza pizzaObj = pizzaFactory.createPizza("GLUTENFREE");
		assertTrue(pizzaObj instanceof GlutenFreePizza);
	}

	@Test
	public void PizzaFactoryCreatePepperoniTest() {
		Pizza pizzaObj = pizzaFactory.createPizza("PEPPERONI");
		assertTrue(pizzaObj instanceof PepperoniPizza);
	}

	@Test
	public void PizzaTestCheesePrepare() {
		Pizza pizzaObj = pizzaFactory.createPizza("CHEESE");
		pizzaObj.prepare();
		assertEquals(outContent.toString(), "Preparing Cheese pizza.\n");
	}

	@Test
	public void PizzaTestCheeseBake() {
		Pizza pizzaObj = pizzaFactory.createPizza("CHEESE");
		pizzaObj.bake();
		assertEquals(outContent.toString(), "Baking Cheese pizza.\n");
	}

	@Test
	public void PizzaTestCheeseCut() {
		Pizza pizzaObj = pizzaFactory.createPizza("CHEESE");
		pizzaObj.cut();
		assertEquals(outContent.toString(), "Cutting Cheese pizza.\n");
	}

	@Test
	public void PizzaTestCheeseBox() {
		Pizza pizzaObj = pizzaFactory.createPizza("CHEESE");
		pizzaObj.box();
		assertEquals(outContent.toString(), "Boxing Cheese pizza.\n");
	}

	@Test
	public void PizzaTestGreekPrepare() {
		Pizza pizzaObj = pizzaFactory.createPizza("GREEK");
		pizzaObj.prepare();
		assertEquals(outContent.toString(), "Preparing Greek pizza.\n");
	}

	@Test
	public void PizzaTestGreekBake() {
		Pizza pizzaObj = pizzaFactory.createPizza("GREEK");
		pizzaObj.bake();
		assertEquals(outContent.toString(), "Baking Greek pizza.\n");
	}

	@Test
	public void PizzaTestGreekCut() {
		Pizza pizzaObj = pizzaFactory.createPizza("GREEK");
		pizzaObj.cut();
		assertEquals(outContent.toString(), "Cutting Greek pizza.\n");
	}

	@Test
	public void PizzaTestGreekBox() {
		Pizza pizzaObj = pizzaFactory.createPizza("GREEK");
		pizzaObj.box();
		assertEquals(outContent.toString(), "Boxing Greek pizza.\n");
	}

	@Test
	public void PizzaTestGFPrepare() {
		Pizza pizzaObj = pizzaFactory.createPizza("GLUTENFREE");
		pizzaObj.prepare();
		assertEquals(outContent.toString(), "Preparing GlutenFree pizza.\n");
	}

	@Test
	public void PizzaTestGFBake() {
		Pizza pizzaObj = pizzaFactory.createPizza("GLUTENFREE");
		pizzaObj.bake();
		assertEquals(outContent.toString(), "Baking GlutenFree pizza.\n");
	}

	@Test
	public void PizzaTestGFCut() {
		Pizza pizzaObj = pizzaFactory.createPizza("GLUTENFREE");
		pizzaObj.cut();
		assertEquals(outContent.toString(), "Cutting GlutenFree pizza.\n");
	}

	@Test
	public void PizzaTestGFBox() {
		Pizza pizzaObj = pizzaFactory.createPizza("GLUTENFREE");
		pizzaObj.box();
		assertEquals(outContent.toString(), "Boxing GlutenFree pizza.\n");
	}

	@Test
	public void PizzaTestPepperoniPrepare() {
		Pizza pizzaObj = pizzaFactory.createPizza("PEPPERONI");
		pizzaObj.prepare();
		assertEquals(outContent.toString(), "Preparing Pepperoni pizza.\n");
	}

	@Test
	public void PizzaTestPepperoniBake() {
		Pizza pizzaObj = pizzaFactory.createPizza("PEPPERONI");
		pizzaObj.bake();
		assertEquals(outContent.toString(), "Baking Pepperoni pizza.\n");
	}

	@Test
	public void PizzaTestPepperoniCut() {
		Pizza pizzaObj = pizzaFactory.createPizza("PEPPERONI");
		pizzaObj.cut();
		assertEquals(outContent.toString(), "Cutting Pepperoni pizza.\n");
	}

	@Test
	public void PizzaTestPepperoniBox() {
		Pizza pizzaObj = pizzaFactory.createPizza("PEPPERONI");
		pizzaObj.box();
		assertEquals(outContent.toString(), "Boxing Pepperoni pizza.\n");
	}
}
