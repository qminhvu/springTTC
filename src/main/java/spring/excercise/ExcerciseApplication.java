package spring.excercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExcerciseApplication {

    private static Logger log = LogManager.getLogger(ExcerciseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExcerciseApplication.class, args);
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
    }

}
