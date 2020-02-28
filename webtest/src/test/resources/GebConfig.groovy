import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

// points to local driver, maybe not needed
System.setProperty('webdriver.chrome.driver', 'src/test/resources/drivers/chromedriver-mac-64bit')

//baseUrl = "http://localhost:4200/"
baseUrl = "http://34.77.210.16/"
reportsDir = "${System.getenv('HOME')}/webtest-reporting"

hubUrl = "http://localhost:4444/wd/hub"
driver = {new ChromeDriver()}

// for non-local use TODO: control by environment
//driver = {new RemoteWebDriver(new URL("${hubUrl}"), DesiredCapabilities.chrome())}
