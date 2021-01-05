package utilis;

import conexion.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilis {

    public static boolean esperarObjeto(MobileElement elemento,int seguntdos    ){
        try{
            System.out.println("Buscamos elemento: "+ elemento+" esperamos "+ seguntdos +" segundos, hasta que aparezca ");
            WebDriverWait wait =new WebDriverWait(DriverContext.getdriver(),seguntdos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            System.out.println("Se encontro el elemento ("+elemento+"), se retorna true");
            return true;
        }catch (Exception e){
            System.out.println("No se encontro el elemento ("+elemento+") se retorna false");
            return false;
        }
    }
    public static void swipeAbajo() {
        int ancho = (int) (DriverContext.getdriver().manage().window().getSize().width * 0.08D);
        int startPoint = (int) (DriverContext.getdriver().manage().window().getSize().height * 0.9D);
        int endPoint = (int) (DriverContext.getdriver().manage().window().getSize().height * 0.65D);

        TouchAction touchAction = new TouchAction(DriverContext.getdriver());
        touchAction.press(PointOption.point(ancho,startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500L))).moveTo(PointOption.point(ancho, endPoint)).release().perform();
        System.out.println("[Utils] Swipe hacia Abajo");
    }
}
