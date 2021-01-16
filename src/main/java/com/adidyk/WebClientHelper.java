package com.adidyk;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.io.IOException;

/**
 * Class WebScraper.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 16.01.2021.
 * @version 1.0.
 */
@Service
public class WebClientHelper implements IWebClientHelper {

    /**
     * @param webClientConfig - web client config.
     */
    private IWebClientConfig webClientConfig;

    /**
     * WebClientConfig - constructor.
     * @param webClientConfig - web client config.
     */
    @Autowired
    WebClientHelper(@Qualifier("webClientConfig") WebClientConfig webClientConfig) {
        this.webClientConfig = webClientConfig;
    }

    /**
     * getDocument - gets document.
     * @param url - url.
     * @return - get document.
     */
    @Override
    public Document getDocument(String url) {
        WebClient webClient = this.webClientConfig.getWebClient();
        Document document = null;
        HtmlPage htmlPage;
        try {
            htmlPage = webClient.getPage(url);
            webClient.waitForBackgroundJavaScript(10000);
            document = Jsoup.parse(htmlPage.asXml());
        } catch (IOException e) {
            e.printStackTrace();
        }
        webClient.close();
        return document;
    }

}