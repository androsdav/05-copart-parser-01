package com.adidyk;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * Class WebScraper.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 16.01.2021.
 * @version 1.0.
 */
@Component
public class WebClientHelper implements IWebClientHelper {

    /**
     * @param webClientConfig - web client config.
     */
    private WebClient webClient;

    /**
     * WebClientConfig - constructor.
     * @param webClientConfig - web client config.
     */
    @Autowired
    WebClientHelper(@Qualifier("webClientConfig") WebClientConfig webClientConfig) {
        this.webClient = webClientConfig.getWebClient();
    }

    /**
     * getDocument - gets document.
     * @param url - url.
     * @return - get document.
     */
    @Override
    public Document getDocument(String url, int delay) {
        Document document = null;
        HtmlPage htmlPage;
        try {
            htmlPage = this.webClient.getPage(url);
            webClient.waitForBackgroundJavaScript(delay);
            document = Jsoup.parse(htmlPage.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        }
        webClient.close();
        return document;
    }

}