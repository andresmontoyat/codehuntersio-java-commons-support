package io.codehunters.commons.integration.batch;

import io.codehunters.commons.integration.batch.job.FileMessageJobRequest;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.integration.launch.JobLaunchingMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;

import java.io.File;

public abstract class AbstractIntegrationBatchSupport {

    public static final String DEFAULT_FILE_PATH = "file_path";

    @Autowired
    protected JobLauncher jobLauncher;

    @Autowired
    protected JobBuilderFactory jobBuilderFactory;

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;

    private String filePath;

    public AbstractIntegrationBatchSupport() {
        this.filePath = DEFAULT_FILE_PATH;
    }

    public AbstractIntegrationBatchSupport(String filePath) {
        this.filePath = filePath;
    }

    protected MessageSource<File> fileReadingMessageSource(String directory, String filter, FileReadingMessageSource.WatchEventType...events) {
        return fileReadingMessageSource(directory, filter, Boolean.TRUE, Boolean.TRUE, events);
    }

    protected MessageSource<File> fileReadingMessageSource(String directory, String filter, Boolean useWatchService, Boolean autoCreateDirectory, FileReadingMessageSource.WatchEventType...events) {
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
        return new FileMessageJobRequest(job,  filePath);
    }

}
