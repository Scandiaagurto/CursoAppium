package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static reports.Report.addStep;
import static utilis.Utilis.esperarObjeto;

public class RegistroPage {

    private AppiumDriver driver;
    public RegistroPage(){
        this.driver= DriverContext.getdriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath ="//android.widget.TextView[contains(@text,\"Registro\")]")
    private MobileElement tituloVistaRegistro;

    @AndroidFindBy(id ="com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;

    @AndroidFindBy(id ="com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;

    @AndroidFindBy(xpath ="//*[contains(@text,'PRODUCTOS')]")
    private MobileElement tituloVistaProductos;

    @AndroidFindBy(xpath = "//*[@resource-id='com.rodrigo.registro:id/nombre_producto']")
    private List<MobileElement> listNombreProductos;

    @AndroidFindBy(xpath = "//*[@resource-id='com.rodrigo.registro:id/precio_producto']")
    private List<MobileElement> listPrecioProductos;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> labelCliente;

    public void validarVistaDesplegada(){

        if (esperarObjeto(tituloVistaRegistro,2)){
            addStep("Validar Vista Registro Desplegada.", true, Status.PASSED,false);
        }else{
            addStep("Error, Validar Vista Registro Desplegada.  ", true, Status.FAILED,true);
        }
    }
    public void tapBtnMas(){
        if(esperarObjeto(btnMas,2)){
            addStep("Tap al Boton '+' ", false, Status.PASSED,false);
            btnMas.click();
        }else{
            addStep("Error, el Boton '+' no se encuentra.", true, Status.FAILED,true);
        }
    }

    public void tapBtnCrearProducto(){
        if(esperarObjeto(btnCrearProducto,2)){
            addStep("Tap al Boton 'Crear Producto' ", false, Status.PASSED,false);
            btnCrearProducto.click();
        }else{
            addStep("Boton 'Crear Producto' no se encuentra.", true, Status.FAILED,true);
        }
    }
    public void validarPestañaProductos(){

        if (esperarObjeto(tituloVistaProductos,2)){
            tituloVistaProductos.click();
            addStep("Validar Vista Productos Desplegada.", true, Status.PASSED,false);
        }else{
            addStep("Error, Validar Productos Desplegada.  ", true, Status.FAILED,true);
        }
    }

    public void validarProducto(String Producto){
        System.out.println("[RegistroProducto] Validar producto");
      Boolean clienteEncontrado = false;
      for (int i=0;i<=listNombreProductos.size();i++){
          String nameProductoActual =   listNombreProductos.get(i).getText();
          if (nameProductoActual.equals(Producto)){
              clienteEncontrado =true;
              break;
          }
      }
      if (clienteEncontrado){
          addStep("Producto: "+Producto+" encontrado", true, Status.PASSED,false);
      }
      else {
          addStep("Producto: "+Producto+" NO encontrado", true, Status.PASSED,true);
      }
    }
    public void validarPrecio(String PrecioList){
        System.out.println("[RegistroPrecios] Validar precios");
        Boolean preciosEncontrados = false;
        for (int i=0;i<=listPrecioProductos.size();i++){
            String namePrecioActual =   listPrecioProductos.get(i).getText();
            if (namePrecioActual.equals(PrecioList)){
                preciosEncontrados =true;
                break;
            }
        }
        if (preciosEncontrados){
            addStep("Precio: "+PrecioList+" encontrado", true, Status.PASSED,false);
        }
        else {
            addStep("Precio: "+PrecioList+" NO encontrado", true, Status.PASSED,true);
        }
    }
    public void tapClientes(String Cliente){
        System.out.println("[Registro Page] Validar Cliente");
        boolean clienteEncontrado = false;


        for (int i =0;i<=labelCliente.size();i++){
            String nombreClienteActual = labelCliente.get(i).getText();
            if (nombreClienteActual.equals(Cliente)){
                labelCliente.get(i).click();
                clienteEncontrado = true;
                break;
            }
        }

        if (clienteEncontrado){
            addStep("Cliente: "+Cliente+" se encuentra", true, Status.PASSED, false);
        }
        else {
            addStep("Cliente: "+Cliente+" no se encuentra ", true, Status.FAILED, true);
        }
    }
    public void validacionClientesEliminados(String Cliente){
        System.out.println("[Registro Page] Validar Cliente Eliminado");
        boolean clienteEncontrado = false;


        for (int i =0;i<=labelCliente.size();i++){
            String nombreClienteActual = labelCliente.get(i).getText();
            if (!nombreClienteActual.equals(Cliente)){
                clienteEncontrado = true;
                break;
            }
        }

        if (clienteEncontrado){
            addStep("Cliente: "+Cliente+" eliminado", true, Status.PASSED, false);
        }
        else {
            addStep("Cliente: "+Cliente+" no se eliminó", true, Status.FAILED, true);
        }

    }
}
