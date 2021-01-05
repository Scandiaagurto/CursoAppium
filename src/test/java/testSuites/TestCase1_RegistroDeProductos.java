package testSuites;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.AgregarProductoCase;

import static conexion.DriverContext.setUP;

public class TestCase1_RegistroDeProductos {
    @BeforeMethod
    public void iniciarSesion() {

        setUP("emulator-5554","Android","/Users/sebastiancandia/Downloads/registroDeUsuarios.apk","emulator-5554",true);
    }
    @AfterMethod
    public void cerrarSesion(){
        DriverContext.quitDriver();
    }

    @Test
    public void agregarProducto(){
        AgregarProductoCase test  =new AgregarProductoCase();
        test.flujo();
    }
}
