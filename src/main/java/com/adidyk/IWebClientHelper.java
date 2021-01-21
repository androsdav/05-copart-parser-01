package com.adidyk;

import org.jsoup.nodes.Document;

/**
 * Class WebClientConfig.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 16.01.2021.
 * @version 1.0.
 */
public interface IWebClientHelper {

    /**
     * getDocument - gets document.
     * @param url - url.
     * @return - get document.
     */
    Document getDocument(String url, int delay);

}