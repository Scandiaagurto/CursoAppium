package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Report.addStep;
import static utilis.Utilis.esperarObjeto;

public class CrearProductoPage {

    private AppiumDriver driver;
    public CrearProductoPage(){
        this.driver= DriverContext.getdriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy(xpath ="//*[contains(@text,'Crear Producto')]")
    private MobileElement tituloVistaCrearProducto;

    @AndroidFindBy(id ="com.rodrigo.registro:id/nombre_producto")
    private MobileElement NombreProducto;

    @AndroidFindBy(id ="com.rodrigo.registro:id/precio")
    private MobileElement PrecioDeLista;

    @AndroidFindBy(id ="com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;

    public void validarVistaDesplegada(){

        if (esperarObjeto(tituloVistaCrearProducto,2)){
            addStep("Validar Vista Crear Producto Desplegada.", true, Status.PASSED,false);
        }else{
            addStep("Error, Validar Vista Crear Producto Desplegada.  ", true, Status.FAILED,true);
        }
    }

    public void CompletarFormulario(String Producto,String PrecioList){
        System.out.println("[CrearProducto Page] Completar Formulario");
        NombreProducto.setValue(Producto);
        this.driver.hideKeyboard();
        PrecioDeLista.click();
        PrecioDeLista.setValue(PrecioList);
        this.driver.hideKeyboard();
        addStep("Completar Formulario de Creacion de Producto.", true, Status.PASSED,false);
    }
    public void tapConfirmar(){
        if(esperarObjeto(btnConfirmar,2)){
            addStep("Tap al Boton 'Confirmar' ", false, Status.PASSED,false);
            btnConfirmar.click();
        }else{
            addStep("Error, el Boton 'Confirmar' no se encuentra.", true, Status.FAILED,true);
        }
    }
}