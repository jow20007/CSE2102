package pizza;

public class PizzaStore {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();

        Pizza pizza = pizzaFactory.createPizza("CHEESE");

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        System.out.println("The Pizza Store is closed!");
    }
}
