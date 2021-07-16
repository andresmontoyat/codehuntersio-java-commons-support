package io.codehunters.commons.integration.batch;

import io.codehunters.commons.integration.batch.job.FileMessageJobRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.integration.launch.JobLaunchingMessageHandler;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;

import java.io.File;

@Getter
@Setter
public abstract class AbstractIntegrationBatchSupport {

    public static final String DEFAULT_FILE_PATH_PARAM = "file_path";

    protected final JobLauncher jobLauncher;

    protected final JobBuilderFactory jobBuilderFactory;

    protected final StepBuilderFactory stepBuilderFactory;

    protected String filePathParam;

    protected AbstractIntegrationBatchSupport(JobLauncher jobLauncher, JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobLauncher = jobLauncher;
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.filePathParam = DEFAULT_FILE_PATH_PARAM;
    }

    protected AbstractIntegrationBatchSupport(String filePathParam, JobLauncher jobLauncher, JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobLauncher = jobLauncher;
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.filePathParam = filePathParam;
    }

    protected MessageSource<File> fileReadingMessageSource(String directory, String filter, FileReadingMessageSource.WatchEventType... events) {
        return fileReadingMessageSource(directory, filter, Boolean.TRUE, Boolean.TRUE, events);
    }

    protected MessageSource<File> fileReadingMessageSource(String directory, String filter, Boolean useWatchService, Boolean autoCreateDirectory, FileReadingMessageSource.WatchEventType... events) {
        FileReadingMessageSource source = new FileReadingMessageSource();
        source.setDirectory(new File(directory));
        source.setFilter(new SimplePatternFileListFilter(filter));
        source.setUseWatchService(useWatchService);
        source.setAutoCreateDirectory(autoCreateDirectory);
        source.setWatchEvents(events);
        return source;
    }

    protected JobLaunchingMessageHandler jobLaunchingMessageHandler() {
        return new JobLaunchingMessageHandler(jobLauncher);
    }

    protected FileMessageJobRequest fileMessageJobRequest(Job job) {
        return new FileMessageJobRequest(job, filePathParam);
    }

}
