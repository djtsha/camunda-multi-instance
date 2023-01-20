package ee.jamaika;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final RuntimeService runtimeService;

    @GetMapping("/start")
    public void startProcess() {
        Random rand = new Random();
        int size = rand.nextInt(191) + 10;
        var ints = IntStream.range(10, 201)
                .limit(size)
                .boxed()
                .collect(Collectors.toList());

        runtimeService.startProcessInstanceByKey("multi-instance-process", Map.of("ids", ints));
    }
}
