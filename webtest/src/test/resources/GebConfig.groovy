import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

// points to local driver, maybe not needed
System.setProperty('webdriver.chrome.driver', 'src/test/resources/drivers/chromedriver-linux-64bit')

baseUrl = "http://localhost:4200"
reportsDir = "${System.getenv('HOME')}/webtest-reporting"

hubUrl = "http://localhost:4444/wd/hub"
//driver = {new ChromeDriver()}

// for non-local use TODO: control by environment
//chromeOptions.setBinary("/usr/bin/chromium-browser");
final ChromeOptions chromeOptions = new ChromeOptions()
chromeOptions.addArguments("--headless")
DesiredCapabilities des = DesiredCapabilities.chrome()
des.setCapability(ChromeOptions.CAPABILITY, chromeOptions)
driver = {new RemoteWebDriver(new URL("${hubUrl}"), des)}
