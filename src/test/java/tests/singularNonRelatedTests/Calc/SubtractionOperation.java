package tests.singularNonRelatedTests.Calc;

public class SubtractionOperation implements MathOperation{
    @Override
    public int performOperation(int a, int b) {
        return a-b;
    }
}
