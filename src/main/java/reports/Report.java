package reports;


import conexion.DriverContext;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;


public class Report {

    private static SoftAssert  softAssert = new SoftAssert();

    public static void addStep(String descripcion, Boolean screenshot, Status status, Boolean fatal){
        String uddid = UUID.randomUUID().toString();
        StepResult result =new StepResult().setName(descripcion).setStatus(status);
        Allure.getLifecycle().startStep(uddid,result);
        if(screenshot){
            //Agregar Foto
            reportScreenShot();
        }
        Allure.getLifecycle().stopStep(uddid);
        softAssert.assertTrue(true ,descripcion);
        if(status.equals(Status.FAILED)){
            softAssert.fail(descripcion);
        }
        if(fatal){
            Assert.fail(descripcion);
        }
        System.out.println("[Reporte] "+descripcion);
    }
    private static void reportScreenShot() {
        File scrFile;
        scrFile =((TakesScreenshot) DriverContext.getdriver()).getScreenshotAs(OutputType.FILE);
        File foto =new File(scrFile.getPath());
        InputStream image;
        try {
            image =new FileInputStream(foto);
            Allure.addAttachment("Imagen Adjunta",image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void  finalAssert(){
        softAssert.assertAll();
    }
}
