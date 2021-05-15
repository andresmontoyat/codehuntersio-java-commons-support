package io.codehunters.commons.integration.tasklet;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Getter
@Setter
public class FileDeleteTasklet implements Tasklet {

    private final String filePathParameter;

    public FileDeleteTasklet(String filePathParameter) {
        this.filePathParameter = filePathParameter;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) {
        log.info("DELETE FILE");
        try {
            Files.delete(Paths.get((String) chunkContext.getStepContext().getJobParameters().get(filePathParameter)));
        } catch (Exception e) {
            throw new UnexpectedJobExecutionException("Could not delete file");
        }
        return RepeatStatus.FINISHED;
    }

}
