package testClases;

import pages.CarruselPage;

public class Test_Carrusel {

    CarruselPage carruselPage=new CarruselPage();


    public void validaciones(){
        carruselPage.ValidarVistaDesplegada();
        carruselPage.ValidarTextoPrimeraVista1Carrusel();
    }
}
