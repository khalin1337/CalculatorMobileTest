import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ComplexTest {
    public  static String expression = System.getProperty("Expression","1 + 45 + 3 * 10 / 3 - 6 * 5");
    @DataProvider(name = "Expression")
    public Object[] expressions() {
        return new Object[]{expression};
    }
    @Test(dependsOnMethods = {"DivideTest.divideTest"},dataProvider = "Expression")
    public void complexTest(String exp) throws InterruptedException {
        CalculatorPage calculatorPage = new CalculatorPage();
        calculatorPage.clickClearButton();

        String result = calculatorPage.complexOperation(exp);

        Assert.assertEquals(result,"26.0");
    }
}
