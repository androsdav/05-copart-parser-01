package com.adidyk;

import com.gargoylesoftware.htmlunit.Page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumDriver {

    public void test() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/home/andrey/C/Program files/geckodriver/geckodriver");

        WebDriver driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.copart.com/vehicleFinderSearch/?displayStr=%5B2010%20TO%202021%5D&from=%2FvehicleFinder%2F&searchStr=%7B%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D,%22sortByZip%22:false,%22buyerEnteredZip%22:null,%22milesAway%22:null%7D&searchCriteria=%7B%22query%22:%5B%22*%22%5D,%22filter%22:%7B%22FETI%22:%5B%22buy_it_now_code:B1%22%5D,%22MISC%22:%5B%22%23VehicleTypeCode:VEHTYPE_V%22,%22%23LotYear:%5B2010%20TO%202021%5D%22%5D%7D,%22sort%22:%5B%22auction_date_type%20desc%22,%22auction_date_utc%20asc%22%5D,%22watchListOnly%22:false,%22searchName%22:%22%22,%22freeFormSearch%22:false%7D");
        WebElement table = new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.id("serverSideDataTable")));
        Thread.sleep(1000);
        System.out.println("!!!!! TABLE !!!! : " + table.getText());
        System.out.println("Thread sleep 5 sec");
        Thread.sleep(5000);
        driver.quit();

        //WebElement table = new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.id("serverSideDataTable")));
        //WebElement table = driver.findElement(By.id("serverSideDataTable"));
        //System.out.println(table);
        //System.out.println("Thread sleep 2 sec");
        //Thread.sleep(2000);
        //String pageSource = driver.getPageSource();
        //Document document = Jsoup.parse(pageSource);
    }
}
