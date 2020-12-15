package com.adidyk;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.Map;

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
    private ParserYelp parser;

    /**
     * RunApplication - constructor.
     *
     * @param parser - parser.
     */
    @Autowired
    public RunApplication(ParserYelp parser) {
        this.parser = parser;
    }

    /**
     * main - main.
     *
     * @param arg - arg.
     */
    public static void main(String[] arg) {
        SpringApplication.run(RunApplication.class, arg);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void testJpaMethods() {
        Map<String, String> cookies = this.parser.getCookies("https://www.yelp.com/search?find_desc=Restaurants&find_loc=Brooklyn%2C%20NY");
        for (Map.Entry<String, String> item : cookies.entrySet()) {
            System.out.println("returns :  " + item.getKey() + "    " + item.getValue());
        }

        Document document = this.parser.getDocument(cookies, "https://www.yelp.com/search?find_desc=Restaurants&find_loc=Brooklyn%2C%20NY");
        System.out.println();
        System.out.println(document.body());
        System.out.println();

    }
}