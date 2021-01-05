package testClases;

import pages.CarruselPage;
import pages.DetallesClientes;
import pages.RegistroPage;

public class EliminarClienteCase {
    CarruselPage carruselPage =new CarruselPage();
    RegistroPage registroPage =new RegistroPage();
    DetallesClientes detallesClientes =new DetallesClientes();


    /**
     * Data para Motivo de Eliminacion
     */
    String Motivo="Borrar";
    /**
     * Nombre del Cliente a eliminar
     */
    String Cliente ="carmen";


    public void flujo2(){
        carruselPage.ValidarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapClientes(Cliente);

        detallesClientes.validarVistaDesplegada();
        detallesClientes.tapEliminarCliente();
        detallesClientes.CompletarFormularioEliminarCliente(Motivo);
        detallesClientes.tapEliminarClienteOK();

        registroPage.validarVistaDesplegada();
        registroPage.validacionClientesEliminados(Cliente);

    }
}
