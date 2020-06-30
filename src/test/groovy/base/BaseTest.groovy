package base

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.BeforeAll
import steps.CellListSteps

class BaseTest {

    @BeforeAll
    static void BaseSetup(){
        SetUp()
        SelenideLogger.addListener("allure", new AllureSelenide()) //шаги для селенидовских методов + скриншоты для упавших тестов
    }

    public static def steps = new CellListSteps()

    static void SetUp(){
        Configuration.browser = "chrome"
        Configuration.headless = false
        Configuration.baseUrl = "http://samples.gwtproject.org"
        setDefaultSize()
    }

    static void setDefaultSize() {
        Configuration.startMaximized = false
        Configuration.browserSize = "1680x1024"
    }
}
