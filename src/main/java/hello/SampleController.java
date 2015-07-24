package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        long startTime = System.nanoTime();
        double loopCount = 10000000;

        for (double i = 0; i < loopCount; i++)
        {
            double percentComplete = i / loopCount * 100;
            System.out.println("Useless code that consumes CPU --- " + percentComplete + "% Complete");
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000000;
        return "<h1>CPU Intensive function complete in " + duration + " seconds!</h1>";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
