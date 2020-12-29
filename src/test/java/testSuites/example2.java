package testSuites;

import conexion.DriverContext;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.Test_Carrusel;

import static conexion.DriverContext.setUP;
import static reports.Report.addStep;

public class example2 {
    @BeforeMethod
    public void iniciarSesion() {

        setUP("emulator-5554","Android","/Users/sebastiancandia/Downloads/registroDeUsuarios.apk","emulator-5554",true);
    }
    @AfterMethod
    public void cerrarSesion(){
        DriverContext.quitDriver();
    }

    public void  Test1(){
        MobileElement botonNext = (MobileElement) DriverContext.getdriver().findElementById("com.rodrigo.registro:id/next");
        botonNext.click();
        botonNext.click();
        addStep("Validar Tercera Vista del Carrusel",true, Status.PASSED,false);
    }
    @Test(description = "Validacion Carrusel")
    public void Test_Carrusel(){
        Test_Carrusel test = new Test_Carrusel();
        test.validaciones();

    }

}
