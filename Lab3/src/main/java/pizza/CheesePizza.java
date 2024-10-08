package pizza;

public class CheesePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Cheese pizza.");
    }
    public void bake() {
        System.out.println("Baking Cheese pizza.");
    }
    public void cut() {
        System.out.println("Cutting Cheese pizza.");
    }
    public void box() {
        System.out.println("Boxing Cheese pizza.");
    }
}