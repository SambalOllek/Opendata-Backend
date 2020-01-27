package nu.t4.opendata.backend;

import javax.ejb.EJB;
import nu.t4.opendata.backend.beans.CarBean;
import nu.t4.opendata.backend.beans.WebScraperBean;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Erik
 */
public class cronWebScrapeJob implements Job{

    @EJB
    WebScraperBean WebScraperBean;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CarBean.class);
    
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        try {
            WebScraperBean.scrape(); 
            LOGGER.info("Jobs done!");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
           
    }
    
}
