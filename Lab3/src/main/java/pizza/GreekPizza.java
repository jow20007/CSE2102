package pizza;

public class GreekPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Greek pizza.");
    }
    public void bake() {
        System.out.println("Baking Greek pizza.");
    }
    public void cut() {
        System.out.println("Cutting Greek pizza.");
    }
    public void box() {
        System.out.println("Boxing Greek pizza.");
    }
}