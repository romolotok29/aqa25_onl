package tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;


@Listeners({ SoftAsserts.class})
public class SelenideExampleTest {

    @BeforeSuite
    public void setupSuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = ReadProperties.url();
        Configuration.browser = Browsers.CHROME;
        //Configuration.browserSize = "1920x1080";
        //Configuration.headless = false;
        //Configuration.pageLoadTimeout = ReadProperties.pageLoadTimeout() * 1000;
        //Configuration.timeout = ReadProperties.timeout() * 1000;
        //Configuration.fastSetValue = true;
        //Configuration.assertionMode = AssertionMode.SOFT;
    }

    @BeforeMethod
    public void setupBrowser() {
        open("/");
        //WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    public void selenideTest() {

        SelenideElement username = $(By.id("name")).setValue(ReadProperties.email());
        SelenideElement password = $("#password").val(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title")
                .shouldBe(visible)
                .shouldHave(text("All Projects"));

        open("/index.php?/admin/projects/overview");

        ElementsCollection list = $$(".hoverSensitive");

        $$(".hoverSensitive")
                .shouldHave(size(4))
                .find(text("Test Project"))
                .find(By.tagName("a"))
                .click();

        $("#announcement_display")
                .shouldHave(exist, Duration.ofSeconds(20))
                .shouldBe(visible)
                .shouldNotHave(text("Country"));

    }

    //Почему-то не работает
    //@Test
    public void selenideSoftAssertErrorTest() {

        SelenideElement username = $(By.id("name")).setValue(ReadProperties.email());
        SelenideElement password = $("#password").val(ReadProperties.password());
        $("#button_primary").click();

        $(".page_title")
                .shouldNotBe(visible)
                .shouldHave(text("All Projects 1"));

        open("/index.php?/admin/projects/overview");

        ElementsCollection list = $$(".hoverSensitive");

        $$(".hoverSensitive")
                .shouldHave(size(147))
                .find(text("Some_Name"))
                .find(By.tagName("a"))
                .click();

        $("#announcement_display")
                .shouldHave(exist, Duration.ofSeconds(20))
                .shouldBe(visible)
                .shouldHave(text("Country"));

    }

    @Test
    public void fileUploadTest() {
        open("https://the-internet.herokuapp.com/upload");

        String filePath = SelenideExampleTest.class.getClassLoader().getResource("stunning-scaled.jpeg").getPath();

        $(By.id("file-upload")).uploadFile(new File(filePath));
        $(By.id("file-submit")).submit();
    }

    @Test
    public void fileDownloadTest() {
        open("https://the-internet.herokuapp.com/download");

        $("#content a").download();

        SelenideElement element = $(byText("demo.txt")); // проверка с учётом верхнего регистра
        SelenideElement element1 = $(byTextCaseInsensitive("Demo.txt")); // проверка без учёта верхнего регистра
        SelenideElement element2 = $(byText("Demo.txt"));

        // Два данных метода нужны, когда не можем получить значение элемента стандарными способами
        element.innerHtml();
        element.innerText();

        //SelenideElement parentElement = element1.parent();
    }
}
