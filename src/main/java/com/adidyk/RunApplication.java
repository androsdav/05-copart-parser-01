package com.adidyk;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
    public void testJpaMethods() throws IOException {
        //Document document = this.parser.getDocument1("https://www.yelp.com/search?find_desc=Restaurants&find_loc=Brooklyn%2C%20NY");
        //System.out.println(document.body());
        Map<String, String> cookies = this.parser.getCookies("https://www.yelp.com/search?find_desc=Restaurants&find_loc=Brooklyn%2C%20NY");
        for (Map.Entry<String, String> item : cookies.entrySet()) {
            System.out.println("returns :  " + item.getKey() + "    " + item.getValue());
        }
        Document document = this.parser.getDocument(cookies, "https://www.yelp.com/search?find_desc=Restaurants&find_loc=Brooklyn%2C%20NY");
        this.parser.parser(document);
        //Elements elements = document.select("div.border-color--default_leftRailSearchResultsContainer__09f24__3vlwA > div:nth-child(2)");
        //System.out.println("Test start");
        //Element element = document.select("div.leftRailSearchResultsContainer__09f24__3vlwA > div:nth-child(1) > ul:nth-child(1) > li:nth-child(7) > div:nth-child(1) > h3:nth-child(1)").first();
        //System.out.println("Test finish");
        /*
        for (Element element : elements) {
            System.out.println(element);
        }*/
    }
}