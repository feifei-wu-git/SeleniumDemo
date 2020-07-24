package com.testng0721;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @DataProvider(name = "data1" )
    public Object[][] dataProvider(){
        return new Object[][]{
                {"http://10.98.88.96:5551/wd/hub","chrome"},
                {"http://10.98.88.96:5551/wd/hub","firefox"}
        };

    }

    @Test(dataProvider = "data1")
    public void testCase(String url,String Browse) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities;
        if (Browse.equals("chrome")){
            desiredCapabilities = DesiredCapabilities.chrome();

        }else if(Browse.equals("firefox")){
            desiredCapabilities = DesiredCapabilities.firefox();

        }else {
            desiredCapabilities = DesiredCapabilities.internetExplorer();
        }
        WebDriver webDriver = new RemoteWebDriver(new URL(url),desiredCapabilities);
        webDriver.get("https://www.baidu.com/");

    }


}
