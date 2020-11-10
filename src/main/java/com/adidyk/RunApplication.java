package com.adidyk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.io.IOException;

/**
 * Class RunApplication used to start run application.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.11.2020.
 * @version 1.0.
 */
@SpringBootApplication
public class RunApplication {

    /**
     * @param parser - parser.
     */
    private Parser parser;

    /**
     * RunApplication - constructor.
     * @param parser - parser.
     */
    @Autowired
    public RunApplication(Parser parser) {
        this.parser = parser;
    }

    /**
     * main - main.
     * @param arg - arg.
     */
    public  static void main(String[] arg) {
        SpringApplication.run(RunApplication.class, arg);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void testJpaMethods() throws IOException {
        this.parser.parserCopart();
    }

}