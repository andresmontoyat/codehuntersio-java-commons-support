package io.codehunters.commons.integration.tasklet.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.File;

@Slf4j
public class FileDeleteTasklet implements Tasklet {

    private String filePathParameter;

    public FileDeleteTasklet(String filePathParameter) {
        this.filePathParameter = filePathParameter;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        log.info("DELETE FILE");
        File file = new File((String) chunkContext.getStepContext().getJobParameters().get(filePathParameter));
        if (file.isFile()) {
            boolean deleted = file.delete();
            if (!deleted) {
                throw new UnexpectedJobExecutionException("Could not delete file " +
                        file.getPath());
            }
        }

        return RepeatStatus.FINISHED;
    }

}
