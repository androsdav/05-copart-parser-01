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
     * @param startUrl - https://www.yelp.com.
     */
    private String startUrl = "https://www.yelp.com";

    /**
     * @param filterUrl - https://www.yelp.com.
     */
    private String filterUrl = "https://www.yelp.com/search?find_desc=Restaurants&find_loc=Brooklyn%2C%20NY&sortby=rating&start=0";


    /**
     * getCookies - gets cookies.
     * @param url - url.
     * @return - gets cookies.
     */
    /*
    public Map<String, String> getCookies(String url) {
        return  this.parser.getCookies(YELP);
    }*/

    /**
     * printCookies - prints cookies.
     * @param cookies - cookies.
     */
    /*
    public void printCookies(Map<String, String> cookies) {
        for (Map.Entry<String, String> item : cookies.entrySet()) {
            System.out.println("returns :  " + item.getKey() + "    " + item.getValue());
        }
    }*/

    /**
     * getFindResult - gets find result.
     * @param cookies - cookies.
     * @param url - url.
     * @return - returns document.
     */
    /*
    public Document getFindResult(Map<String, String> cookies, String url) {
        return this.parser.getDocument(cookies, url);
    }*/

    /**
     * main - main.
     * @param arg - arg.
     */
    public static void main(String[] arg) {
        SpringApplication.run(RunApplication.class, arg);
    }

    /**
     * testJpaMethod - test JPA method.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void testJpaMethods() throws IOException, InterruptedException {
        ParserYelp parserYelp = new ParserYelp(startUrl, filterUrl);
        System.out.println("point 1");
        parserYelp.work();


        //Map<String, String> cookies = this.getCookies(YELP);

        //this.printCookies(cookies);

        //Document document = this.getFindResult(cookies, YELP_GET_ALL_RESTAURANTS_BROOKLYN_NY);

        //System.out.println(document);

        //System.out.println(this.parser.getNumberPage(document));
        //this.parser.purseAllLinkFromFirstPage(document);


    }

}