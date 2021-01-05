package testSuites;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.AgregarProductoCase;
import testClases.EliminarClienteCase;

import static conexion.DriverContext.setUP;

public class TesCase_1y3_Evaluacion_Appium {
    @BeforeMethod
    public void iniciarSesion() {

        setUP("emulator-5554","Android","/Users/sebastiancandia/Downloads/registroDeUsuarios.apk","emulator-5554",true);
    }
    @AfterMethod
    public void cerrarSesion(){
        DriverContext.quitDriver();
    }

    @Test(description = "Test para Crear un Producto y Validar su creacion")
    public void agregarProducto(){
        AgregarProductoCase test  =new AgregarProductoCase();
        test.flujo();
    }

    @Test(description = "Test para Eliminar un Cliente")
    public void eliminarCliente(){
        EliminarClienteCase test  =new EliminarClienteCase();
        test.flujo2();
    }

}
