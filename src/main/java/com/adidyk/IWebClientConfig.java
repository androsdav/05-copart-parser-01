package com.adidyk;

import com.gargoylesoftware.htmlunit.WebClient;
/**
 * Class WebClientConfig.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 16.01.2021.
 * @version 1.0.
 */
public interface IWebClientConfig {

    /**
     * initialization - initialization.
     */
    void configuration();

    /**
     * getWebClient - gets web client.
     * @return - return web client.
     */
    WebClient getWebClient();

}
