package com.crest.assement;

public interface IConfig {
    public final String LOOKUP_KEYWORD = "CDS";
    public final String fileName1 = "..\\fms.log.1";
    public final String fileName2 = "..\\fms.log.2";
    public static final String TRIGGER_NAME = "FileWriteTrigger";
    public static final String GROUP = "FileWriterGroup";
    public static final String JOB_NAME = "writeToFileRandomString";
    public static final int INTERVAL_SECONDS = 10;
}
