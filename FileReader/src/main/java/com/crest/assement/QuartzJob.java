package com.crest.assement;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  Scheduler Job which continuosly monitor read file
 */
public class QuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        FileMonitoring fileMonitoring = new FileMonitoring();
        fileMonitoring.readRGSFile();
    }
}
