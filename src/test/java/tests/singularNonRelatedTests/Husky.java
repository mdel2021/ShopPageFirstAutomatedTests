package tests.singularNonRelatedTests;

public class Husky extends Animal implements Dog{
    @Override
    public void run() {
        System.out.println("Husky run");
    }
}
