package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Report.addStep;

public class CarruselPage {

private AppiumDriver driver;
    public CarruselPage(){
        this.driver= DriverContext.getdriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy(id ="com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVista1;

    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement tituloVista;
    @AndroidFindBy(id ="com.rodrigo.registro:id/textView")
    private MobileElement descripcion;
    @AndroidFindBy(id ="com.rodrigo.registro:id/next")
    private MobileElement btnFlecha;

    public void ValidarVistaDesplegada(){
        if(iconoVista1.isDisplayed()){
            addStep("Validar Vista 1 del Carrusel Desplegado", true, Status.PASSED,false);

        }else   {
            addStep("Validar Vista 1 del Carrusel Desplegado", true, Status.FAILED,true);
        }
    }

    public void ValidarTextoPrimeraVista1Carrusel() {
        String textodescripcionVista1 = descripcion.getText();
        if (textodescripcionVista1.equals("Con Registro podrás guardar de forma fácil y segura todo lo relacionado a la venta de productos o servicios."))
        {
            addStep("Validar Vista 1 de Carrusel - Descripcion", true, Status.PASSED,false);
    }else{
            addStep("Validar Vista 1 de Carrusel - Descripcion", true, Status.FAILED,true);

    }

}


}

