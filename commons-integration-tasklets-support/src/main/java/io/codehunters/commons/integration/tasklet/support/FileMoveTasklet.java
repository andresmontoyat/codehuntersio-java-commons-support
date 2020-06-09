package io.codehunters.commons.integration.tasklet.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
public class FileMoveTasklet implements Tasklet {

    private String filePath;

    private String newFilePath;

    public FileMoveTasklet(String filePath, String newFilePath) {
        this.filePath = filePath;
        this.newFilePath = newFilePath;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        log.info("MOVE FILE");
        File file = new File((String) chunkContext.getStepContext().getJobParameters().get(filePath));
        if (file.isFile()) {
            Files.move(Paths.get(file.toURI()), Paths.get(URI.create(newFilePath)), StandardCopyOption.REPLACE_EXISTING);
        }

        return RepeatStatus.FINISHED;
    }

}
