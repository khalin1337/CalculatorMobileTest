import browserstack.shaded.org.eclipse.jgit.annotations.NonNull;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.qameta.allure.Step;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.appium.SelenideAppium.$;

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
    /*
    public RemoteWebDriver driver;
    public static String userName, accessKey;
    public static Map<String, Object> browserStackYamlMap;
    public static final String USER_DIR = "user.dir";

    public CalculatorPage() {
        File file = new File(getUserDir() + "/browserstack.yml");
        this.browserStackYamlMap = convertYamlFileToMap(file, new HashMap<>());
        userName = System.getenv("BROWSERSTACK_USERNAME") != null ? System.getenv("BROWSERSTACK_USERNAME") : (String) browserStackYamlMap.get("userName");
        accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY") != null ? System.getenv("BROWSERSTACK_ACCESS_KEY") : (String) browserStackYamlMap.get("accessKey");
    }

    //@BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("source", "selenide:sample-master:v1.2");
        System.out.println(bstackOptions);
        capabilities.setCapability("bstack:options", bstackOptions);
        driver = new RemoteWebDriver(new URL(String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", userName, accessKey)), capabilities);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverRunner.setWebDriver(driver);
    }

    //@AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    private String getUserDir() {
        return System.getProperty(USER_DIR);
    }

    private Map<String, Object> convertYamlFileToMap(File yamlFile, Map<String, Object> map) {
        try {
            InputStream inputStream = Files.newInputStream(yamlFile.toPath());
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(inputStream);
            map.putAll(config);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Malformed browserstack.yml file - %s.", e));
        }
        return map;
    }*/
    /*public RemoteWebDriver driver;
    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("deviceName","Samsung Galaxy S22 Ultra");
        caps.setCapability("os_version","12.0");
        caps.setCapability("os","android");
        caps.setCapability("app","bs://02f9aaaf677c50777c3cf08039e8d8df26890551");
        caps.setCapability("source","testng:appium-intellij:v1.1.6");
        caps.setCapability("projectName","BrowserStack Sample");
        caps.setCapability("buildName","browserstack build");
        try {
            driver = new RemoteWebDriver(new URL(String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", "yevhenkhalin_o6uJ0X", "ieXJWCsqNb2Dis6gwvUm")), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverRunner.setWebDriver(driver);
        return driver;
    }
*/

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
    public String complexOperation(String expression) {
            //Split the expressions on tokens(Operands and operators)
            List<String> tokens = new ArrayList<>(List.of(expression.split(" ")));
            String result="";

            //Do a multiplication and divide operations
            for (int i = 0; i < tokens.size(); i++) {
                String token = tokens.get(i);
                if (token.equals("*") || token.equals("/")) {
                    String leftOperand = tokens.get(i - 1);
                    String rightOperand = tokens.get(i + 1);

                    fillTextField(leftOperand);
                    if (token.equals("*")) {
                        clickMultipleButton();
                    } else {
                        clickDivideButton();
                    }
                    fillTextField(rightOperand);
                    clickEqualButton();

                    result = getResult();
                    tokens.set(i - 1, result);
                    tokens.remove(i);
                    tokens.remove(i);
                    i -= 1;
                    clickClearButton();
                }
            }

            //Do a summary and subtraction operations
            for (int i = 0; i < tokens.size(); i++) {
                String token = tokens.get(i);
                if (token.equals("+") || token.equals("-")) {
                    String leftOperand = tokens.get(i - 1);
                    String rightOperand = tokens.get(i + 1);

                    fillTextField(leftOperand);
                    if (token.equals("+")) {
                        clickPlusButton();
                    } else {
                        clickMinusButton();
                    }
                    fillTextField(rightOperand);
                    clickEqualButton();

                    result = getResult();
                    tokens.set(i - 1, result);
                    tokens.remove(i);
                    tokens.remove(i);
                    i -= 1;
                    clickClearButton();
                }
            }
            return result;
    }

}

