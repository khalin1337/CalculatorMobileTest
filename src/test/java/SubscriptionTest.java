import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionTest {
    @Test(dependsOnMethods = {"SummaryTest.summaryTest"})
    public void subscriptionTest() throws InterruptedException {
        CalculatorPage calculatorPage = new CalculatorPage();
        calculatorPage.clickClearButton();

        calculatorPage.subtractionOperation("2","1");

        Assert.assertEquals(calculatorPage.getResult(),"1.0");
    }
}
