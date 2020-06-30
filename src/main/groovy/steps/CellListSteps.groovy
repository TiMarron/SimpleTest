package steps

import com.codeborne.selenide.ElementsCollection
import io.qameta.allure.Step
import org.openqa.selenium.Keys

import static com.codeborne.selenide.Selenide.*

class CellListSteps {

    //вынес пару шагов для примера. Если бы тестов было больше - это надо было бы разбивать отдельно на шаги с логикой и взаимодействие со страницей

    @Step("Получаем список загруженных контактов")
    static ElementsCollection getLoadedList() {
        $$("div[__idx]")
    }

    @Step("Кликаем по кнопке Generate 50 Contacts")
    static generateContacts() {
        $(".GNHGC04CIJ > .gwt-Button").click()
    }

    @Step("Скроллим до конца списка")
    static void scrollToEndOfTheList() {
        //суть метода - пытаемся скроллить пока счетчик под списком меняется. Если перестал меняться - значит всё.
        Boolean mustScroll = true
        while (mustScroll){
            def startCounter = $("table .gwt-HTML").text()
            $(".GNHGC04CJJ").click()  //клик нужен чтобы в видимой области был активный элемент списка - так не будет ошибок ниже
            $(".GNHGC04CFB").sendKeys(Keys.END) //нажимаем END - так скроллить немного быстрее, иначе было куча итераций.
            sleep(500) 		//скролл сделан с явным ожиданием - это нехорошо. Но в списке нет элементов, к которым можно привязать ожидание подгрузки.
            def endCounter = $("table .gwt-HTML").text()
            if (startCounter == endCounter){
                mustScroll = false
            }
        }
    }
}
