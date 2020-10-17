import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class QuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String randomString = RandomStringGenUtils.randomStringGenerator();
        System.out.println(randomString);
        try (FileWriter writer = new FileWriter("..\\fms.log.1", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
             bw.write(randomString);
             bw.write("\n");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
