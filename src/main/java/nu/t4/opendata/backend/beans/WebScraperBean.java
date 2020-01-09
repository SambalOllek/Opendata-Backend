package nu.t4.opendata.backend.beans;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import nu.t4.opendata.backend.entities.Car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import nu.t4.opendata.backend.entities.CarBuilder;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class WebScraperBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarBean.class);

    /*private WebDriver webDriver;
    
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
     */
    public String scrape2(String url) {
        List links = new ArrayList();
        try ( WebClient client = new WebClient()) {
            client.getOptions().setThrowExceptionOnScriptError(false);
            client.getOptions().setCssEnabled(false);
            client.getOptions().setUseInsecureSSL(true);

            client.waitForBackgroundJavaScriptStartingBefore(2000);
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
        
        //TODO FIXA SÅ ATT DEN SKRAPRA DATA FRÅN VARJE BIL SIDA
        String baseUrl = url.substring(0, url.lastIndexOf("/"));
        links.forEach((link -> {
            try (WebClient client = new WebClient()){
                HtmlPage page = client.getPage(baseUrl + link);
                Document doc = Document.createShell(page.getBaseURI());
                System.out.println("---PRIS---: " + doc.getElementsByClass("car-price-details").get(0).val());
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }));
        return "";
    }
}
