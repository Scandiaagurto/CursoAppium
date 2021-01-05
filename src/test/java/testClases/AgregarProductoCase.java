package testClases;

import pages.CarruselPage;
import pages.CrearProductoPage;
import pages.RegistroPage;

public class AgregarProductoCase {
    CarruselPage carruselPage =new CarruselPage();
    RegistroPage registroPage =new RegistroPage();
    CrearProductoPage crearProductoPage =new CrearProductoPage();

    /**
     * Datos para Crear Productos
     */

    String Producto= "palta";
    String PrecioList="4530.00";

    public void flujo(){
        carruselPage.ValidarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();
        registroPage.tapBtnCrearProducto();

        crearProductoPage.validarVistaDesplegada();
        crearProductoPage.CompletarFormulario(Producto,PrecioList);
        crearProductoPage.tapConfirmar();

        registroPage.validarPestañaProductos();
        registroPage.validarProducto(Producto);
        registroPage.validarPrecio(PrecioList);

    }
}
