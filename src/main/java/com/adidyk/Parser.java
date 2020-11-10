package com.adidyk;

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
        String URL = "https://www.copart.com/vehicleFinderSearch/?displayStr=%5B2010%20TO%202021%5D&from=%2FvehicleFinder%2F&searchStr=%7B%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D,%22sortByZip%22:false,%22buyerEnteredZip%22:null,%22milesAway%22:null%7D&searchCriteria=%7B%22query%22:%5B%22*%22%5D,%22filter%22:%7B%22FETI%22:%5B%22buy_it_now_code:B1%22%5D,%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D%7D,%22sort%22:%5B%22auction_date_type%20desc%22,%22auction_date_utc%20asc%22%5D,%22watchListOnly%22:false,%22searchName%22:%22%22,%22freeFormSearch%22:false%7D";
        Document document = Jsoup
                .connect("https://www.google.com")
                //.proxy("127.0.0.1", 8080)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
        //Document document = Jsoup.parse(URL);
        System.out.println(document);


    }
}
