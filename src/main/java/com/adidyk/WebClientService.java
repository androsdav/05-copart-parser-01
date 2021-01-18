package com.adidyk;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Class WebScraper.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 16.01.2021.
 * @version 1.0.
 */
@Service
public class WebClientService {

    /**
     * @param webClientHelper - web client helper.
     */
    private WebClientHelper webClientHelper;

    private String sortBy = "&sortby=";

    private String start = "&start=";

    private String yelp = "https://www.yelp.com";

    private List<String> links = new ArrayList<>();

    /**
     * WebClientService- constructor.
     * @param webClientHelper - web client helper.
     */
    @Autowired
    WebClientService(WebClientHelper webClientHelper) {
        this.webClientHelper = webClientHelper;
    }

    /**
     * counter - counter.
     * @param document - document.
     * @return - returns number page.
     */
    private int counter(Document document) {
        return Integer.parseInt(document.select("div.text-align--center__09f24__31irQ")
                .first()
                .text()
                .substring(5));
    }

    /**
     * scraper - scraper.
     * @param url - url.
     */
    void scraper(String url) {
        int counter = this.counter(this.webClientHelper.getDocument(url));
        for (int count = 0; count < counter * 10; count = count + 10) {
            Document document = this.webClientHelper.getDocument(url + this.sortBy + "rating" + this.start + count);
            Elements elements = document.select("div.container__09f24__21w3G");
            for (Element element : elements) {
                if (element.select("a.link-size--inherit__09f24__2Uj95").first().attr("href").startsWith("/biz")) {
                    links.add(this.yelp + element.select("a.link-size--inherit__09f24__2Uj95").first().attr("href"));
                }
            }
        }
        for (String link : links) {
            System.out.println(link);

        }
        test();
    }

    void test() {
        String url = this.yelp + "/biz/otis-brooklyn-2?osq=Restaurants";
        Document document = this.webClientHelper.getDocument1(url);
        System.out.println(document.select("div.page-header").first());


    }

}