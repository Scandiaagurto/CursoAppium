package testSuites;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ExampleDriver {


    public void iniciarSesion(){
         AppiumDriver driver;
         URL server =null;
         try{
         server=new URL("http://127.0.0.1:4723/wd/hub");
         } catch (MalformedURLException e) {
             e.printStackTrace();
         }
    }
}
