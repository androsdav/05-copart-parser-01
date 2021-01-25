package com.adidyk;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.text.Document;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumDriver {

    public void test() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/home/andrey/C/Program files/geckodriver/geckodriver");

        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(5000000, TimeUnit.MICROSECONDS);
        webDriver.manage().timeouts().setScriptTimeout(5000000, TimeUnit.MICROSECONDS);


        webDriver.get("https://www.copart.com/vehicleFinderSearch/?displayStr=%5B2010%20TO%202021%5D&from=%2FvehicleFinder%2F&searchStr=%7B%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D,%22sortByZip%22:false,%22buyerEnteredZip%22:null,%22milesAway%22:null%7D&searchCriteria=%7B%22query%22:%5B%22*%22%5D,%22filter%22:%7B%22FETI%22:%5B%22buy_it_now_code:B1%22%5D,%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D%7D,%22sort%22:%5B%22auction_date_type%20desc%22,%22auction_date_utc%20asc%22%5D,%22watchListOnly%22:false,%22searchName%22:%22%22,%22freeFormSearch%22:false%7D");
        //Thread.sleep(10000);
        String webElement = webDriver.getTitle();
        System.out.println();
        System.out.println("Output web element " + webElement);
        System.out.println();
        webDriver.quit();
    }
}
