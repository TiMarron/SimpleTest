import base.BaseTest
import org.junit.jupiter.api.Test

import static com.codeborne.selenide.Selenide.open

class simpleTest extends BaseTest {

	@Test
	void contactsCanBeGenerated(){
		open("/samples/Showcase/Showcase.html#!CwCellList") //открываем страницу с нужной формой

		steps.scrollToEndOfTheList() //проматываем список до конца - чтобы подгрузились все элементы
		def oldListSize = steps.getLoadedList().size() //получаем список, смотрим какой он длинны
		steps.generateContacts()
		steps.scrollToEndOfTheList()  //ещё раз проматываем список - без этого может не подгрузиться
		def newListSize = steps.getLoadedList().size()	//получаем список, смотрим какой он длинны

		assert oldListSize + 50 == newListSize //проверяем что новый список контактов стал длиннее на 50
	}
}
