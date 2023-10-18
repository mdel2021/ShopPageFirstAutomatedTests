package tests.singularNonRelatedTests.Calc;

public class Calculator {
    private MathOperation mathOperation;

    public Calculator(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
    }

    public int calculate(int a, int b) {
        return mathOperation.performOperation(a, b);
    }
}
