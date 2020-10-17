package com.crest.assement;

import java.io.*;

/**
 * Purpose : This class is used to read regex and write the count on search_result.log file
 */
public class FileMonitoring {
    /**
     * Purpose: method will be use to read content from fms.log.1
     */
    public void readRGSFile(){
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(IConfig.fileName1));
            String line = reader.readLine();
            while(line !=null)
            {
                count+=IConfig.LOOKUP_KEYWORD.equals(line)?1:0;
                line=reader.readLine();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        writeCountToLog(IConfig.fileName1+"-"+count);
        //System.out.println(count);
    }

    public void writeCountToLog(String writeContent){
        try (FileWriter writer = new FileWriter("..\\search_results.log”", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(writeContent);
            bw.write("\n");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
