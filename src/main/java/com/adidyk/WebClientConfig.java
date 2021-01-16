package com.adidyk;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.javascript.SilentJavaScriptErrorListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Class WebClientConfig.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 16.01.2021.
 * @version 1.0.
 */
@Component
public class WebClientConfig implements IWebClientConfig {

    /**
     * @param webClient - wev client.
     */
    private WebClient webClient = new WebClient(BrowserVersion.CHROME);

    /**
     * HtmlWebClientConnect - constructor.
     */
    public WebClientConfig() {
        this.configuration();
    }

    /**
     * initialization - initialization.
     */
    @Override
    public void configuration() {
        this.webClient.getOptions().setJavaScriptEnabled(true);
        this.webClient.getOptions().setCssEnabled(false);
        this.webClient.getOptions().setUseInsecureSSL(true);
        this.webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        this.webClient.getCookieManager().setCookiesEnabled(true);
        this.webClient.getOptions().setThrowExceptionOnScriptError(false);
        this.webClient.setJavaScriptErrorListener(new SilentJavaScriptErrorListener());
        this.webClient.setCssErrorHandler(new SilentCssErrorHandler());
    }

    /**
     * getWebClient - gets web client.
     * @return - return web client.
     */
    @Override
    public WebClient getWebClient() {
        return this.webClient;
    }

}