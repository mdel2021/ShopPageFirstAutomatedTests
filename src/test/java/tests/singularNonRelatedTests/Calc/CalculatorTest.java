package tests.singularNonRelatedTests.Calc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void testAdditionOperation() {
        AdditionOperation additionOperation = new AdditionOperation();
        Calculator calculator = new Calculator(additionOperation);
        int result = calculator.calculate(2, 3);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void testSubtractionOperation() {
        SubtractionOperation subtractionOperation = new SubtractionOperation();
        Calculator calculator = new Calculator(subtractionOperation);
        int result = calculator.calculate(5, 2);
        Assert.assertEquals(result, 3 );
    }
}
