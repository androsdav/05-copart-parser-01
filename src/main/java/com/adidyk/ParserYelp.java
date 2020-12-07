package com.adidyk;

import org.aspectj.apache.bcel.generic.FieldOrMethod;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Class RunApplication used to start run application.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.11.2020.
 * @version 1.0.
 */
@Component
public class ParserYelp {

    private String userAgent = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0";

    /**
     * getCookies - get cookies.
     * @param url - url.
     * @return - returns cookies.
     */
    public Map<String, String> getCookies(String url) {
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url)
                    .userAgent(this.userAgent)
                    .method(Connection.Method.GET)
                    .referrer("http://www.google.com")
                    .timeout(5000)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response != null ? response.cookies() : null;
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
    public void parserCopart() throws IOException {
        /**
         * @param URL - url copart.
         */
        String URL1 = "https://www.copart.com/vehicleFinderSearch/?displayStr=%5B2010%20TO%202021%5D&from=%2FvehicleFinder%2F&searchStr=%7B%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D,%22sortByZip%22:false,%22buyerEnteredZip%22:null,%22milesAway%22:null%7D&searchCriteria=%7B%22query%22:%5B%22*%22%5D,%22filter%22:%7B%22FETI%22:%5B%22buy_it_now_code:B1%22%5D,%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D%7D,%22sort%22:%5B%22auction_date_type%20desc%22,%22auction_date_utc%20asc%22%5D,%22watchListOnly%22:false,%22searchName%22:%22%22,%22freeFormSearch%22:false%7D";
        String URL2 = "https://www.pravda.com.ua";
        String URL3 = "https://www.copart.de";
        //String URL4 = "https://www.avito.ru/rossiya/avtomobili/sedan/avtomat-ASgCAQICAkDmtg0Uyrco8LYNFO63KA";
        String URL4 = "https://www.yelp.com";
        String URL5 = "https://www.yelp.com/search?find_desc=Restaurants&find_loc=Brooklyn%2C%20NY";

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

        /**
         * Connect to url and get cookies
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
*/
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


        }
    }

