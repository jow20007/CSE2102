package pizza;

public class PizzaFactory {
    public Pizza createPizza(String pizzaType) {
        switch (pizzaType) {
            case "GREEK":
                return new GreekPizza();
            case "PEPPERONI":
                return new PepperoniPizza();
            case "CHEESE":
                return new CheesePizza();
            case "GLUTENFREE":
                return new GlutenFreePizza();
        }
        return null;
    }
}