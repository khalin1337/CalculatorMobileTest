import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest {
    @Test(dependsOnMethods = {"SubscriptionTest.subscriptionTest"})
    public void multiplicationTest() throws InterruptedException {
        CalculatorPage calculatorPage = new CalculatorPage();
        calculatorPage.clickClearButton();

        calculatorPage.multiplicationOperation("2","3");

        Assert.assertEquals(calculatorPage.getResult(),"6.0");
    }
}
