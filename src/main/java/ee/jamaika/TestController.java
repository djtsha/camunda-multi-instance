package ee.jamaika;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final RuntimeService runtimeService;

    @GetMapping("/start")
    public void startProcess() {
        runtimeService.startProcessInstanceByKey("multi-instance-process");
    }
}
