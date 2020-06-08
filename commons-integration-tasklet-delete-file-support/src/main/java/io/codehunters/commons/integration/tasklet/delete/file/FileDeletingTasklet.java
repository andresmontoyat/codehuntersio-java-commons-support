package io.codehunters.commons.integration.tasklet.delete.file;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.File;

public class FileDeletingTasklet implements Tasklet {

    private String filePath;

    public FileDeletingTasklet(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        System.out.println("DELETE FILE");
        File file = new File((String) chunkContext.getStepContext().getJobParameters().get(filePath));
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
