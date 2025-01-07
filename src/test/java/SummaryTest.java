import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SummaryTest {

    @Test
    public void summaryTest() throws Exception {
        CalculatorPage calculatorPage = new CalculatorPage();
        Configuration.browser =  CalculatorPage.class.getName();
        SelenideAppium.launchApp();
        //calculatorPage.setUp();
        calculatorPage.clickStartInfoButton();
        calculatorPage.summaryOperation("2","2");
        Assert.assertEquals(calculatorPage.getResult(),"4.0");
    }

}
