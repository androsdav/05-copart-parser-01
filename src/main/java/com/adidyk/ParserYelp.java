package com.adidyk;

import lombok.SneakyThrows;
import org.aspectj.apache.bcel.generic.FieldOrMethod;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * Class RunApplication used to start run application.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.11.2020.
 * @version 1.0.
 */
@Component
public class ParserYelp {

    /**
     *
     * @param url - url.
     * @return - map.
     */
    public Map<String, String> getCookies(String url) {
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:83.0) Gecko/20100101 Firefox/83.0")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .header("Accept-Language", "en-US,en;q=0.5")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Connection", "keep-alive")
                    .header("upgrade-insecure-requests", "1")
                    .method(Connection.Method.GET)
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .followRedirects(true)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response != null ? response.cookies() : null;
    }

    /**
     *
     * @param cookies - cppkies.
     * @param url - url.
     * @return - document.
     */
    @SneakyThrows
    public Document getDocument(Map<String, String> cookies, String url) {
        System.out.println("Second connect start");
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:83.0) Gecko/20100101 Firefox/83.0")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .header("Accept-Language", "en-US,en;q=0.5")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Connection", "keep-alive")
                    .header("upgrade-insecure-requests", "1")
                    .method(Connection.Method.GET)
                    .cookies(cookies)
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .followRedirects(true)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Second connect finish");
        return response != null ? (response).parse() : null;
    }


    /**
     *
     * @param document - document.
     */
    public void parser(Document document) {
        Elements elements = document.select("div.leftRailSearchResultsContainer__09f24__3vlwA > div:nth-child(1) > ul:nth-child(1)");
        System.out.println();
        //System.out.println(elements.text());
        System.out.println();
        Elements elements1 = elements.select("div.container__09f24__21w3G");
        for (Element element : elements1) {
            String link = element.select("a.link-size--inherit__09f24__2Uj95").text();
            if (!link.equals("more")) {
                System.out.println(link);
            }
        }
        System.out.println();
        //System.out.println(elements1.text());
        System.out.println();


        /*
        for (Element element : elements) {
            if (element.select("div.container__09f24__21w3G") != null) {
                System.out.println(element.text());
            }

        }*/

    }

}


    /*
    Connection.Response response = Jsoup.connect(URL4)
            .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
            .method(Connection.Method.GET)
            .referrer("http://www.google.com")
            .timeout(5000)
            .execute();

    Map<String, String> map = response.cookies();
        System.out.println("Cookies");
        for (Map.Entry<String, String> item : map.entrySet()) {
        System.out.println("returns :  " + item.getKey() + "    " + item.getValue());


    /**
     * @throws IOException - exeption.
     */
    /*
    public void parserCopart() throws IOException, InterruptedException {
        /**
         * @param URL - url copart.
         */
    /*
        String URL1 = "https://www.copart.com/vehicleFinderSearch/?displayStr=%5B2010%20TO%202021%5D&from=%2FvehicleFinder%2F&searchStr=%7B%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D,%22sortByZip%22:false,%22buyerEnteredZip%22:null,%22milesAway%22:null%7D&searchCriteria=%7B%22query%22:%5B%22*%22%5D,%22filter%22:%7B%22FETI%22:%5B%22buy_it_now_code:B1%22%5D,%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D%7D,%22sort%22:%5B%22auction_date_type%20desc%22,%22auction_date_utc%20asc%22%5D,%22watchListOnly%22:false,%22searchName%22:%22%22,%22freeFormSearch%22:false%7D";
        String URL2 = "https://www.pravda.com.ua";
        String URL3 = "https://www.copart.de";
        //String URL4 = "https://www.avito.ru/rossiya/avtomobili/sedan/avtomat-ASgCAQICAkDmtg0Uyrco8LYNFO63KA";
        String URL4 = "https://www.yelp.com";
        String URL5 = "https://www.yelp.com/search?find_desc=Restaurants&find_loc=Brooklyn%2C%20NY";


        System.out.println();
        Connection.Response response = Jsoup.connect(URL5)
                .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*//*;q=0.8")
                .header("accept-encoding", "gzip, deflate, sdch, br")
                .header("accept-language", "en-US,en;q=0.8")
                .header("cache-control", "max-age=0")
                .header("user-agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
                .header("upgrade-insecure-requests", "1")
                .ignoreHttpErrors(true)
                .followRedirects(true)
                .method(Connection.Method.GET)
                .timeout(30000)
                .execute();
        //Thread.sleep(5000);
        Document document = response.parse();
        System.out.println(document);
        Map<String, String> map = response.cookies();
        System.out.println("Cookies");
        for (Map.Entry<String, String> item : map.entrySet()) {
            System.out.println("returns :  " + item.getKey() + "    " + item.getValue());
        System.out.println();
        Connection.Response response1 = Jsoup.connect(URL1)
                //.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*//*;q=0.8")
                .header("accept-encoding", "gzip, deflate, sdch, br")
                .header("accept-language", "en-US,en;q=0.8")
                .header("cache-control", "max-age=0")
                .header("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")
                .header("upgrade-insecure-requests", "1")
                .ignoreHttpErrors(true)
                .followRedirects(true)
                .cookies(response.cookies())
                .method(Connection.Method.GET)
                .timeout(30000)
                .execute();
        Document document1 = response1.parse();
        System.out.println(document1);

        /*
        Connection.Response response = Jsoup
                .connect(URL3)
                .method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
                .timeout(5000)
                //.referrer("http://www.google.com")
                .execute();
        String visid_incap_242121 = response.cookie("visid_incap_242121");
        String copartmember = response.cookie("copartmember");
        String incap_ses_765_242121 = response.cookie("incap_ses_765_242121");

        System.out.println();
        System.out.println("visid_incap_242121 : " + visid_incap_242121);
        System.out.println("copartmember : " + copartmember);
        System.out.println("String incap_ses_765_242121 : " + incap_ses_765_242121);
        Document document = response.parse();
        System.out.println("document head : " + document);
        //System.out.println("testtt: " + document);
        */

        /*
        Document document = Jsoup
                .connect(URL4)
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
//                .cookie("sessionId", sessionId)
                .timeout(5000)
                .referrer("http://www.google.com")
                .get();
        System.out.println(document);
        */
/*
        Connection.Response response = Jsoup.connect(URL4)
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
                .method(Connection.Method.GET)
                .referrer("http://www.google.com")
                .timeout(5000)
                .execute();

        Map<String, String> map = response.cookies();
        System.out.println("Cookies");
        for (Map.Entry<String, String> item : map.entrySet()) {
            System.out.println("returns :  " + item.getKey() + "    " + item.getValue());
*//*
            Document document = Jsoup.connect(URL5)
                    .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
//                    .cookies(map)
                    .referrer("http://www.google.com")
                    .timeout(5000)
                    .get();

            System.out.println(document);
            //System.out.println(document);
        /*
        Element element = document.select("script").first();
        String url = element.absUrl("src");
        System.out.println("element:  " + element);
        System.out.println("url:  " + url);

        Document document1 = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
                .cookies(map)
                .referrer("http://www.google.com")
                .get();

        /*
        document = Jsoup.connect(URL3)
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
                .cookies(map)
                .referrer("http://www.google.com")
                .get();
        System.out.println();
        System.out.println(document);
        System.out.println();
        */

        /*
        response = Jsoup.connect("http://www.mikeportnoy.com/forum/login.aspx")
                .data("ctl00$ContentPlaceHolder1$ctl00$Login1$UserName", "username")
                .data("ctl00$ContentPlaceHolder1$ctl00$Login1$Password", "password")
                .cookies(response.cookies())
                .method(Connection.Method.POST)
                .execute();
                */

        /*
        Document homePage = Jsoup.connect(URL3)
                .cookies(response.cookies())
                .get();
        System.out.println(homePage);
        */

/*
        Connection.Response response = Jsoup.connect("http://www.mikeportnoy.com/forum/login.aspx")
                .method(Connection.Method.GET)
                .execute();

        response = Jsoup.connect("http://www.mikeportnoy.com/forum/login.aspx")
                .data("ctl00$ContentPlaceHolder1$ctl00$Login1$UserName", "username")
                .data("ctl00$ContentPlaceHolder1$ctl00$Login1$Password", "password")
                .cookies(response.cookies())
                .method(Connection.Method.POST)
                .execute();

        Document homePage = Jsoup.connect("http://www.mikeportnoy.com/forum/default.aspx")
                .cookies(response.cookies())
                .get();
        */


       // }
    //}
//}