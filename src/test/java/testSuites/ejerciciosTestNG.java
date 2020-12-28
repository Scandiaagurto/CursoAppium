package testSuites;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ejerciciosTestNG {

    @BeforeSuite
    public void  metodo1(){
        System.out.println("Inicio de Suite");
    }
    @AfterSuite
   public void  metodo2() {
        System.out.println("Termino de Suite");
}
    @Test(priority = 1)
    public void  metodo3() {
        System.out.println("Test 1");
    }
    @Test(priority = 2)
    public void  metodo4() {
        System.out.println("Test 2");

    }
    @AfterTest
    public void  metodo5() {
        System.out.println("Termino test");

    }



}
