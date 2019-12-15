package nu.t4.opendata.backend.beans;

import nu.t4.opendata.backend.entities.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class WebScraperBean {
    private WebDriver webDriver;

    public void scrape(String url) {
        System.out.println("In WebScraperBean.scrape");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Erik\\Documents\\Programmering\\Opendata-Backend\\chromedriver.exe");
        webDriver = new ChromeDriver();
        try {
            webDriver.get("https://images.google.se");
            webDriver.findElement(By.className("gLFyf gsfi")).sendKeys("Teknikum");
            webDriver.findElement(By.className("Tg7LZd")).click();
        } catch (Exception e) {
            System.out.println("Error in WebScraperBean.scrape: " + e.getMessage());
        }
    }

    private Car buildCar() {
        return null;
    }
}
