package pizza;

public class PepperoniPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Pepperoni pizza.");
    }
    public void bake() {
        System.out.println("Baking Pepperoni pizza.");
    }
    public void cut() {
        System.out.println("Cutting Pepperoni pizza.");
    }
    public void box() {
        System.out.println("Boxing Pepperoni pizza.");
    }
}