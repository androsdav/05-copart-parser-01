package com.adidyk;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

public class MayWebClient {

    @Autowired
    private WebApplicationContext wac;

    private WebClient webClient;

    @Before
    public void setup() {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(wac).build();
    }

    public void givenAMessage__whenSent__thenItShows() throws Exception {
        String text = "Hello world!";
        HtmlPage page;

        String url = "http://localhost/message/showForm";
        page = webClient.getPage(url);

    }

}
