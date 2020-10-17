package com.crest.assement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
public class Main {

    private static Scheduler scheduler;
    public static void main(String[] args) throws Exception {
        System.out.println(" QuartzSchedulerApp main thread: " + Thread.currentThread().getName());

        scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        Trigger trigger =  buildSimpleSchedulerTrigger();
        // buildCronSchedulerTrigger();// for cron job trigger
        scheduleJob(trigger);
    }


    private static Trigger buildSimpleSchedulerTrigger() {
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(IConfig.TRIGGER_NAME, IConfig.GROUP)
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(IConfig.INTERVAL_SECONDS).repeatForever())
                .build();
        return trigger;
    }

    private static void scheduleJob(Trigger trigger) throws Exception {

        JobDetail fmsJob = JobBuilder.newJob(QuartzJob.class).withIdentity(IConfig.JOB_NAME,IConfig.GROUP).build();

        scheduler.scheduleJob(fmsJob, trigger);

    }


}
