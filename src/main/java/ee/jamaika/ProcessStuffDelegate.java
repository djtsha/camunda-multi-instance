package ee.jamaika;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class ProcessStuffDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        int count = (Integer)delegateExecution.getVariable("loopCounter");
        log.info("processing:{}|", count);

/*
        if (isRandomTrue()) {
            throw new RuntimeException(String.format("exception: %s|", count));
        }
*/
    }

    public static boolean isRandomTrue() {
        return new Random().nextInt(10) == 0;
    }
}
