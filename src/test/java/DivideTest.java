import org.testng.Assert;
import org.testng.annotations.Test;

public class DivideTest {
    @Test(dependsOnMethods = {"MultiplicationTest.multiplicationTest"})
    public void divideTest() throws InterruptedException {
        CalculatorPage calculatorPage = new CalculatorPage();
        calculatorPage.clickClearButton();

        calculatorPage.divideOperation("2","2");

        Assert.assertEquals(calculatorPage.getResult(),"1.0");
    }
}
