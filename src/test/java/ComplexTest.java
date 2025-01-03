import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexTest {
    @Test(dependsOnMethods = {"DivideTest.divideTest"})
    public void complexTest() throws InterruptedException {
        CalculatorPage calculatorPage = new CalculatorPage();
        calculatorPage.clickClearButton();

        calculatorPage.complexOperation("2","2","1","3","2");

        Assert.assertEquals(calculatorPage.getResult(),"4.5");
    }
}
