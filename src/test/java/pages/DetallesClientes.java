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
import static utilis.Utilis.swipeAbajo;

public class DetallesClientes {


    private AppiumDriver driver;

    public DetallesClientes(){
        this.driver= DriverContext.getdriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.rodrigo.registro:id/title")
    private MobileElement titleDetalleCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private MobileElement btnEliminarCliente;

    @AndroidFindBy(id="com.rodrigo.registro:id/lista_tarjetas")
    private MobileElement textCompleto;

    @AndroidFindBy(id= "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement textEliminarCliente;

    @AndroidFindBy(id="android:id/button1")
    private MobileElement btnOK;

    public void validarVistaDesplegada(){
        if (esperarObjeto(titleDetalleCliente, 2)){
            addStep("Validar Detalle Cliente Desplegada", true, Status.PASSED, false);
        }
        else {
            addStep("Error en Vista Detalle Cliente", true, Status.FAILED , true);
        }

    }

    public void tapEliminarCliente(){
       swipeAbajo();
       if (esperarObjeto(btnEliminarCliente,2)){
           btnEliminarCliente.click();
           addStep("Click al Boton 'Eliminar Cliente' ", true, Status.PASSED,false);
       }
       else {
           addStep("Boton 'Eliminar Cliente' No se encuentra.", true, Status.FAILED,true);

       }
    }
    public void CompletarFormularioEliminarCliente(String Motivo){
        System.out.println("[EliminarCliente Page] Completar Formulario para eliminar Cliente");
        textEliminarCliente.setValue(Motivo);
        this.driver.hideKeyboard();

        addStep("Completar Formulario de Eliminacion de Cliente.", true, Status.PASSED,false);
    }
    public void tapEliminarClienteOK(){
        if(esperarObjeto(btnOK,2)){
            addStep("Tap al Boton 'OK' ", true, Status.PASSED,false);
            btnOK.click();
        }else{
            addStep("Boton 'OK' no se encuentra.", true, Status.FAILED,true);
        }
    }
}
