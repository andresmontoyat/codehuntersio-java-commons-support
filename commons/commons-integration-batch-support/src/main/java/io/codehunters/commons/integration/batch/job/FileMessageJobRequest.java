package io.codehunters.commons.integration.batch.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;

import java.io.File;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class FileMessageJobRequest {

    private Job job;

    private String parameterName;

    @Transformer
    public JobLaunchRequest toRequest(Message<File> message) {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString(parameterName, message.getPayload().getAbsolutePath());
        jobParametersBuilder.addDate("currentDate", new Date());
        return new JobLaunchRequest(job, jobParametersBuilder.toJobParameters());
    }

}
