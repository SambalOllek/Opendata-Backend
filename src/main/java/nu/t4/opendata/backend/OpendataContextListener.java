package nu.t4.opendata.backend;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import nu.t4.opendata.backend.beans.CarBean;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Erik
 */
public class OpendataContextListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarBean.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    //Run this before web application is started
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        JobDetail cronJob = JobBuilder.newJob(cronWebScrapeJob.class).build();
        Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("CronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/5 * 1/1 * ? *"))
                .build();
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.scheduleJob(cronJob, cronTrigger);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
