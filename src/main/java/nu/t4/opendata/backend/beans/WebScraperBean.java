package nu.t4.opendata.backend.beans;

<<<<<<< Updated upstream
=======
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
>>>>>>> Stashed changes
import nu.t4.opendata.backend.entities.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
<<<<<<< Updated upstream
import javax.ejb.Singleton;
=======
import javax.ejb.Stateless;
import nu.t4.opendata.backend.entities.CarBuilder;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
>>>>>>> Stashed changes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class WebScraperBean {
<<<<<<< Updated upstream
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

    private Car buildCar() {
        return null;
=======

    private static final Logger LOGGER = LoggerFactory.getLogger(CarBean.class);

    public List<Car> scrape(String url) {
        List<Car> cars = new ArrayList();
        List<String> links = new ArrayList();
        try (final WebClient client = new WebClient(BrowserVersion.FIREFOX_60)) {

            client.getOptions().setUseInsecureSSL(true);
            client.getOptions().setThrowExceptionOnScriptError(false);
            client.getOptions().setCssEnabled(false);
            HtmlPage mainPage = client.getPage(url);

            Document mainDoc = Document.createShell(mainPage.getBaseURI());
            mainDoc.getElementsByTag("body").append(mainPage.asXml());
            List<Element> articles = mainDoc.getElementsByClass("result-list-item");
            System.out.println("---Articles---: " + articles.size());

            articles.forEach((element) -> {
                System.out.println("---LINK---: " + element.getElementsByTag("a").get(0).attr("href"));
                links.add(element.getElementsByTag("a").get(0).attr("href"));
            });
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        String baseUrl = url.substring(0, url.lastIndexOf("/"));
        System.out.println("---BAS URL---: " + baseUrl);
        links.forEach((link -> {
            try (final WebClient client = new WebClient(BrowserVersion.FIREFOX_60)) {
                client.getOptions().setUseInsecureSSL(true);
                client.getOptions().setThrowExceptionOnScriptError(false);
                client.getOptions().setCssEnabled(false);
                HtmlPage page = client.getPage(baseUrl + link);
                client.waitForBackgroundJavaScriptStartingBefore(200);
                client.waitForBackgroundJavaScript(200);
                Document doc = Document.createShell(page.getBaseURI());
                doc.getElementsByTag("body").append(page.asXml());

                CarBuilder carBuilder = new CarBuilder();
                carBuilder
                        .address(doc.getElementsByClass("uk-width-1-1 vehicle-detail-section-dealer-address").get(0).text())
                        .brand(doc.getElementsByTag("dd").get(0).text())
                        .model(doc.getElementsByTag("dd").get(1).text())
                        .year(Integer.parseInt(doc.getElementsByTag("dd").get(2).text()))
                        .milage(Integer.parseInt(doc.getElementsByTag("dd").get(3).text()))
                        .fuel(doc.getElementsByTag("dd").get(4).text())
                        .gearbox(doc.getElementsByTag("dd").get(5).text())
                        .drivewheel(doc.getElementsByTag("dd").get(6).text())
                        .regnum(doc.getElementsByTag("dd").get(7).text())
                        .link(link).build();

                cars.add(new Car(carBuilder));
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }));
        return cars;
>>>>>>> Stashed changes
    }
}
