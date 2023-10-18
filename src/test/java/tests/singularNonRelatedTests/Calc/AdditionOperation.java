package tests.singularNonRelatedTests.Calc;

public class AdditionOperation implements MathOperation{
    @Override
    public int performOperation(int a, int b) {
        return a+b;
    }
}
