package io.codehunters.commons.integration.tasklet;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Getter
@Setter
public class FileMoveTasklet implements Tasklet {

    private final String filePathParameter;

    private final String newFilePath;

    public FileMoveTasklet(String filePathParameter, String newFilePath) {
        this.filePathParameter = filePathParameter;
        this.newFilePath = newFilePath;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) {
        log.info("MOVE FILE");
        File file = new File((String) chunkContext.getStepContext().getJobParameters().get(filePathParameter));
        try {
            Files.move(Paths.get(file.toURI()), Paths.get(URI.create("file://" + (newFilePath + "/" + file.getName()).replaceAll("\\s", "%20"))), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new UnexpectedJobExecutionException("Could not move file");
        }

        return RepeatStatus.FINISHED;
    }

}
