package conexion;

import io.appium.java_client.AppiumDriver;

public class DriverContext {
    private static DriverManager driverManager = new DriverManager();

    public static void setUP(String NombreDispositivo,String SD, String aplicacion ,String udid, boolean emulador){
        driverManager.iniciarSesion(NombreDispositivo,SD,aplicacion,udid,emulador);
    }
    public static AppiumDriver getdriver(){
        return driverManager.getDriver();
    }
    public static void quitDriver(){
        driverManager.getDriver().quit();
    }
}
