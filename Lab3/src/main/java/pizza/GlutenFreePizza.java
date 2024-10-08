package pizza;

public class GlutenFreePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing GlutenFree pizza.");
    }
    public void bake() {
        System.out.println("Baking GlutenFree pizza.");
    }
    public void cut() {
        System.out.println("Cutting GlutenFree pizza.");
    }
    public void box() {
        System.out.println("Boxing GlutenFree pizza.");
    }
}