package testSuites;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static conexion.DriverContext.setUP;

public class ExampleDriver {

@BeforeMethod
    public void iniciarSesion() {
        /*
        AppiumDriver driver;

        URL server = null;
        try {
            server = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platforName","Android");
        cap.setCapability("app", "/Users/sebastiancandia/Downloads/registroDeUsuarios.apk");
        cap.setCapability("udid","emulator-5554");

        driver= new AndroidDriver(server,cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
*/
    setUP("emulator-5554","Android","/Users/sebastiancandia/Downloads/registroDeUsuarios.apk","emulator-5554",true);
    }
    @Test
public void test1(){
    System.out.println("Prueba");
}
}
