package tests.singularNonRelatedTests;

public class Pike extends Animal implements Fish {
    @Override
    public void swim() {
        System.out.println("Swimming");
    }
}
