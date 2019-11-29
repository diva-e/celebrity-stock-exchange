import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

// points to local driver, maybe not needed
System.setProperty('webdriver.chrome.driver', 'src/test/resources/drivers')

baseUrl = "http://localhost:4200/"
reportsDir = "${System.getenv('HOME')}/webtest-reporting"

hubUrl = "http://localhost:4444/wd/hub"
driver = {new ChromeDriver(new URL("${hubUrl}"), DesiredCapabilities.chrome())}
