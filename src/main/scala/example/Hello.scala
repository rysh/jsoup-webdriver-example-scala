package example
import java.util.concurrent.TimeUnit

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxDriverLogLevel, FirefoxOptions}

object Hello extends App {
  System.setProperty("webdriver.gecko.driver", "lib/geckodriver")

  private val options = new FirefoxOptions
  options.setHeadless(true)
  options.is("javascriptEnabled")
  options.setLogLevel(FirefoxDriverLogLevel.ERROR)

  val driver: WebDriver = new FirefoxDriver(options)
  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS)
  driver.get("https://www.google.co.jp/")
  By.tagName("html")


  val hoge: WebElement = driver.findElement(By.tagName("html"))

  val ret: String = driver.getPageSource
  val fuga: String = hoge.getAttribute("innerHTML")

  val piyo: Document = Jsoup.parse(fuga)
  println(piyo)

}
