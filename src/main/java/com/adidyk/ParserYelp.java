package com.adidyk;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.SilentJavaScriptErrorListener;
import lombok.SneakyThrows;
import org.apache.juli.logging.LogFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;


/**
 * Class RunApplication used to start run application.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.11.2020.
 * @version 1.0.
 */
public class ParserYelp {


    private List<String> links = new ArrayList<>();

    /**
     * @param startUrl - start url.
     */
    private String startUrl;

    /**
     * @param filterUrl - filer url.
     */
    private String filterUrl;

    /**
     * ParserYelp - constructor.
     * @param startUrl - start url.
     * @param filterUrl - filter url.
     */
    ParserYelp(String startUrl, String filterUrl) {
        this.startUrl = startUrl;
        this.filterUrl = filterUrl;
    }

    public void work() throws IOException, InterruptedException {
        Map<String, String> cookies = this.getCookies(this.startUrl);  // gets cookies
        Document document = this.getDocument(cookies, this.filterUrl); // gets document
        int number = this.getNumberPage(document);                     // gets number page
        System.out.println("point 2");
        List<String> links = this.getLinksFromOnePage(document);       // gets all link from one page

        System.out.println(links.get(0));

        this.getDocumentJavaScript(links.get(0));
        //System.out.println(document1);
        System.out.println("point 3");

        //this.getEditLinkForItem(document1);

    }

    /**
     * getCookies - gets cookies.
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
     * getDocument - gets document.
     * @param cookies - cookies.
     * @param url - url.
     * @return - document.
     */
    @SneakyThrows
    public Document getDocument(Map<String, String> cookies, String url) {
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
        return response != null ? (response).parse() : null;
    }

    public void getDocumentJavaScript(String url) throws IOException, InterruptedException {
        /*
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true); // not load java script
        webClient.getOptions().setCssEnabled(false); // clear css value warning in logs
        webClient.getOptions().setUseInsecureSSL(true); // &&
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false); // &&
        webClient.getCookieManager().setCookiesEnabled(true); // set cookies
        webClient.getOptions().setThrowExceptionOnScriptError(false); // not load script error
        webClient.setJavaScriptErrorListener(new SilentJavaScriptErrorListener()); // good clear error
        webClient.setCssErrorHandler(new SilentCssErrorHandler()); // dsd
        HtmlPage page = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(6000);
        Document document = Jsoup.parse(page.asXml());
        System.out.println(document.select("a.button__373c0__3lYgT.small__373c0__Wsszq").first().attr("href"));
        webClient.close();
        */
    }

    /**
     * getNumberPage - gets number page.
     * @param document - document.
     */
    public int getNumberPage(Document document) {
        return Integer.parseInt(document.select("div.text-align--center__09f24__31irQ")
                .first()
                .text()
                .substring(5)
        );
    }

    /**
     * purseAllLinkFromOnePage - purse all links from one page.
     * @param document - document.
     */
    public List<String> getLinksFromOnePage(Document document) {
        Elements elements = document.select("div.container__09f24__21w3G");
        for (Element element : elements) {
            if (element.select("a.link-size--inherit__09f24__2Uj95").first().attr("href").startsWith("/biz")) {
                this.links.add(element.select("a.link-size--inherit__09f24__2Uj95").first().absUrl("href"));

            }
        }
        return this.links;
    }

    /**
     * purseAllLinkFromSecondPage - purse link from second page.
     * @param document - document.
     * @return - returns string.
     */
    public void getEditLinkForItem(Document document) {
        //String link = document.select("a.lemon--a__373c0__IEZFH:nth-child(6)").attr("href");
        System.out.println();
        System.out.println(document.body());
        System.out.println();
    }

    /*
    /**
     *
     * @param document - document.
     */
    /*
    public void parser(Document document) {
        Elements elements = document.select("div.leftRailSearchResultsContainer__09f24__3vlwA > div:nth-child(1) > ul:nth-child(1)").select("div.container__09f24__21w3G");
        for (Element element : elements) {
            String name = element.select("a.link-size--inherit__09f24__2Uj95").first().text();
            if (element.select("p.text-align--right__09f24__1TIxB").first().text() != null) {

            }
            }
            //Item item = new Item();
            /*
            item.setName(element.select("a.link-size--inherit__09f24__2Uj95").first().text());
            if (element.select("p.text-align--right__09f24__1TIxB").first().text().charAt(0) == '(') {
                item.setPhone(element.select("p.text-align--right__09f24__1TIxB").first().text());
                item.setStreet(element.select("p.text-align--right__09f24__1TIxB").get(1).text());
                item.setNeighborhoods(element.select("p.text-align--right__09f24__1TIxB").get(2).text());
            } else {
                item.setStreet(element.select("p.text-align--right__09f24__1TIxB").get(0).text());
                item.setNeighborhoods(element.select("p.text-align--right__09f24__1TIxB").get(1).text());
            }
            */
            //this.itemsList.add(item);
        }
        //Set<Item> itemSet = new HashSet<>(this.itemsList);
        //this.getItems(itemSet);

    /*
    /**
     *
     */
    /*
    public void getItems(Set items) {
       // System.out.println(this.items);
        items.forEach(System.out::println);
    }

}


        //div.leftRailSearchResultsContainer__09f24__3vlwA > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > div.container__09f24__21w3G
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