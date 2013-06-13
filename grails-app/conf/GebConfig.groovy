import org.openqa.selenium.htmlunit.HtmlUnitDriver

driver = {
	def driver = new HtmlUnitDriver()
	driver.setJavascriptEnabled(false)
	driver
}
