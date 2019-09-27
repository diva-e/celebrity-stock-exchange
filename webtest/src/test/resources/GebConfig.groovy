import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

// points to local driver, maybe not needed
System.setProperty('webdriver.chrome.driver', 'src/test/resources/drivers')

baseUrl = "https://www.diva-e.com/"
reportsDir = "${System.getenv('HOME')}/webtest-reporting"

hubUrl = "http://34.77.204.251:4444/wd/hub"
driver = {new RemoteWebDriver(new URL("${hubUrl}"), DesiredCapabilities.chrome())}
