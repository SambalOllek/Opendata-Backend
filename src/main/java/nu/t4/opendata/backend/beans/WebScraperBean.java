package nu.t4.opendata.backend.beans;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import nu.t4.opendata.backend.entities.Car;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import nu.t4.opendata.backend.entities.CarBuilder;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Erik
 */
@Stateless
public class WebScraperBean {

    @EJB
    CarBean carBean;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebScraperBean.class);

    /**
     * Scrape data of cars from a site currently only supports
     * https://bytbil.com/bil
     *
     * @return Returns int of number of cars added to db
     */
    public int scrape() {
        List<Car> cars = scrapeLinks("https://bytbil.com/bil");
        int carsAdded = 0;
        for (Car car : cars) {
            if (carBean.addCar(car) != 0) {
                carsAdded++;
            }
        }
        System.out.println("Scraping Done!");
        return carsAdded;
    }

    /**
     * Scrape data of cars from a site currently only supports
     * https://bytbil.com/bil
     *
     * @param url The URL of said site to scrape data from
     * @return Returns list of cars scraped from site.
     */
    private List<Car> scrapeLinks(String url) {
        String baseUrl = "https://bytbil.com";
        LOGGER.info("Webscraping has begun!");
        List<Car> cars = new ArrayList();
        List<String> links = new ArrayList();
        try (final WebClient client = new WebClient(BrowserVersion.FIREFOX_60)) {
            client.getOptions().setUseInsecureSSL(true);
            client.getOptions().setThrowExceptionOnScriptError(false);
            client.getOptions().setCssEnabled(false);
            HtmlPage mainPage = client.getPage(url);
            client.waitForBackgroundJavaScript(1000);
            Document mainDoc = Document.createShell(mainPage.getBaseURI());
            mainDoc.getElementsByTag("body").append(mainPage.asXml());
            List<Element> articles = mainDoc.getElementsByClass("result-list-item");

            articles.forEach((element) -> {
                links.add(element.getElementsByTag("a").get(0).attr("href"));
            });
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        links.forEach((link -> {
            cars.add(scrapeCarInfo(baseUrl + link));
        }));
        return cars;
    }

    /**
     * Only called from scrape function Scrape info from link and builds a car
     * object from said info
     *
     * @param link Link to page with cars info/data
     * @return Returns a Car object
     */
    private Car scrapeCarInfo(String link) {
        try (final WebClient client = new WebClient(BrowserVersion.FIREFOX_60)) {
            LOGGER.info("Begun scraping from car articles!");
            client.getOptions().setUseInsecureSSL(true);
            client.getOptions().setThrowExceptionOnScriptError(false);
            client.getOptions().setCssEnabled(false);
            HtmlPage page = client.getPage(link);
            client.waitForBackgroundJavaScript(1000);
            Document doc = Document.createShell(page.getBaseURI());
            doc.getElementsByTag("body").append(page.asXml());

            String priceTag = doc.getElementsByClass("car-price-details").get(0).text().replace(" ", "");
            int price = Integer.parseInt(priceTag.substring(0, priceTag.indexOf("k")));

            CarBuilder carBuilder = new CarBuilder();
            carBuilder
                    .address(doc.getElementsByClass("uk-width-1-1 vehicle-detail-section-dealer-address").get(0).text())
                    .brand(doc.getElementsByTag("dd").get(0).text())
                    .model(doc.getElementsByTag("dd").get(1).text())
                    .year(Integer.parseInt(doc.getElementsByTag("dd").get(2).text().replace(" ", "")))
                    .milage(Integer.parseInt(doc.getElementsByTag("dd").get(3).text().replace(" ", "")))
                    .fuel(doc.getElementsByTag("dd").get(4).text())
                    .gearbox(doc.getElementsByTag("dd").get(5).text())
                    .drivewheel(doc.getElementsByTag("dd").get(6).text())
                    .regnum(doc.getElementsByTag("dd").get(7).text())
                    .link(link)
                    .price(price)
                    .build();
            return new Car(carBuilder);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }
}
