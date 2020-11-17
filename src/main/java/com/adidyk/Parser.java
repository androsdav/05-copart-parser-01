package com.adidyk;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * Class RunApplication used to start run application.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.11.2020.
 * @version 1.0.
 */
@Component
public class Parser {

    /**
     *
     * @throws IOException - exeption.
     */
    public void parserCopart() throws IOException {
        /**
         * @param URL - url copart.
         */
        String URL1 = "https://www.copart.com/vehicleFinderSearch/?displayStr=%5B2010%20TO%202021%5D&from=%2FvehicleFinder%2F&searchStr=%7B%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D,%22sortByZip%22:false,%22buyerEnteredZip%22:null,%22milesAway%22:null%7D&searchCriteria=%7B%22query%22:%5B%22*%22%5D,%22filter%22:%7B%22FETI%22:%5B%22buy_it_now_code:B1%22%5D,%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D%7D,%22sort%22:%5B%22auction_date_type%20desc%22,%22auction_date_utc%20asc%22%5D,%22watchListOnly%22:false,%22searchName%22:%22%22,%22freeFormSearch%22:false%7D";
        String URL2 = "https://www.pravda.com.ua";
        Connection.Response response = Jsoup
                .connect(URL2)
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
                .timeout(5000)
                .referrer("http://www.google.com")
                .execute();
        String sessionId = response.cookie("sessionId");
        Document document = response.parse();
        System.out.println("testtt: " + document);

        /*
        Document document = Jsoup
                .connect("https://www.pravda.com.ua")
                .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:82.0) Gecko/20100101 Firefox/82.0")
                .cookie("sessionId", sessionId)
                .timeout(5000)
                .referrer("http://www.google.com")
                .get();
        System.out.println(document);
        */


    }
}
