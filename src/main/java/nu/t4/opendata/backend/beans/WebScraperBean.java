package nu.t4.opendata.backend.beans;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import nu.t4.opendata.backend.entities.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import javax.ejb.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class WebScraperBean {
    private WebDriver webDriver;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CarBean.class);

    public void scrape(String url) {
        System.out.println("In WebScraperBean.scrape");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erik\\Documents\\Programmering\\Opendata-Backend\\chromedriver.exe");
        webDriver = new ChromeDriver();
        try {
            webDriver.get("https://images.google.se");
            webDriver.findElement(By.className("gLFyf gsfi")).sendKeys("Teknikum");
            webDriver.findElement(By.className("Tg7LZd")).click();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void scrape2 (String url){
        WebClient client = new WebClient();
        client.getOptions().setJavaScriptEnabled(true);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setUseInsecureSSL(true);
        String jsonString = "";

        try {
            client.waitForBackgroundJavaScriptStartingBefore(3000);
            HtmlPage page = client.getPage(url);
            
            System.out.println(page.asXml());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private Car buildCar() {
        return null;
    }
}
