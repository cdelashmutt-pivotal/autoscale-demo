package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
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
