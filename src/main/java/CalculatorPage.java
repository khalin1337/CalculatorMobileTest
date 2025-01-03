import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.qameta.allure.Step;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.appium.SelenideAppium.*;

public class CalculatorPage implements WebDriverProvider {

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setPlatformVersion("15");
        options.setApp("C:\\Users\\User\\Downloads\\app-debug.apk");
        //GitHub to .APK file https://github.com/Sourav0010/Calculator/releases/tag/v2.0.0
        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    //Locators
    SelenideElement startInfoButton = $(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
    SelenideElement plusButton = $(AppiumBy.xpath("//android.widget.Button[@text=\"+\"]"));
    SelenideElement minusButton = $(AppiumBy.xpath("//android.widget.Button[@text=\"-\"]"));
    SelenideElement multipleButton = $(AppiumBy.xpath("//android.widget.Button[@text=\"×\"]"));
    SelenideElement divideButton = $(AppiumBy.xpath("//android.widget.Button[@text=\"÷\"]"));
    SelenideElement equalButton = $(AppiumBy.xpath("//android.widget.Button[@text=\"=\"]"));
    SelenideElement clearButton = $(AppiumBy.xpath("//android.widget.Button[@text=\"AC\"]"));
    SelenideElement textField = $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.sourav.mohanty.calculator:id/result\"]"));
    SelenideElement resultField = $(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.sourav.mohanty.calculator:id/newNumber\"]"));

    //Methods
    @Step("Get the result of the operation")
    public String getResult() {
        return resultField.text();
    }
    @Step("Skip start info")
    public void clickStartInfoButton() {
        startInfoButton.click();
    }
    @Step("Clear text field")
    public void clickClearButton() {
        clearButton.click();
    }
    @Step("Get the result")
    public void clickEqualButton() {
        equalButton.click();
    }
    @Step("Fill the text field with a value: '{value}'")
    public void fillTextField(String value) {
        textField.val(value);
    }
    @Step("Perform a summary operation")
    public void clickPlusButton() {
        plusButton.click();
    }
    @Step("Perform a subtraction operation")
    public void clickMinusButton() {
        minusButton.click();
    }
    @Step("Perform a multiplication operation")
    public void clickMultipleButton() {
        multipleButton.click();
    }
    @Step("Perform a divide operation")
    public void clickDivideButton() {
        divideButton.click();
    }
    @Step("Summary operation with {value1} and {value2}")
    public void summaryOperation(String value1, String value2) {
        fillTextField(value1);
        clickPlusButton();
        fillTextField(value2);
        clickEqualButton();
    }
    @Step("Subtraction operation with {value1} and {value2}")
    public void subtractionOperation(String value1, String value2) {
        fillTextField(value1);
        clickMinusButton();
        fillTextField(value2);
        clickEqualButton();
    }
    @Step("Multiplication operation with {value1} and {value2}")
    public void multiplicationOperation(String value1, String value2) {
        fillTextField(value1);
        clickMultipleButton();
        fillTextField(value2);
        clickEqualButton();
    }
    @Step("Divide operation with {value1} and {value2}")
    public void divideOperation(String value1, String value2) {
        fillTextField(value1);
        clickDivideButton();
        fillTextField(value2);
        clickEqualButton();
    }
    @Step("Complex operation with expression: {expression}")
    public void complexOperation(String expression) {

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                fillTextField(token);
            } else {
                switch (token) {
                    case "+" -> clickPlusButton();
                    case "-" -> clickMinusButton();
                    case "*" -> clickMultipleButton();
                    case "/" -> clickDivideButton();
                    default -> throw new IllegalArgumentException("Unsupported operator: " + token);
                }
            }
        }
        clickEqualButton();
    }

}

