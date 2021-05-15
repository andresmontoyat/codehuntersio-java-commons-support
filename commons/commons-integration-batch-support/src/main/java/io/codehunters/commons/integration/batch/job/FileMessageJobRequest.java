package io.codehunters.commons.integration.batch.job;

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
public class FileMessageJobRequest {

    public static final String JOB_PARAM_FILE_NAME = "fileName";
    public static final String JOB_PARAM = "job_param";
    public static final String JOB_PARAM_CURRENT_DATE = "currentDate";

    protected final Job job;

    protected final String parameterName;

    public FileMessageJobRequest(Job job, String parameterName) {
        this.job = job;
        this.parameterName = parameterName;
    }

    @Transformer
    public JobLaunchRequest toRequest(Message<File> message) {
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString((parameterName == null) ? JOB_PARAM : parameterName, message.getPayload().getAbsolutePath());
        jobParametersBuilder.addString(JOB_PARAM_FILE_NAME, message.getPayload().getName());
        jobParametersBuilder.addDate(JOB_PARAM_CURRENT_DATE, new Date());
        return new JobLaunchRequest(job, jobParametersBuilder.toJobParameters());
    }

}
