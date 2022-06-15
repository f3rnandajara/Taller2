package controller;

import model.Inventario;
import model.inventarioDAO;
import view.RegistroProducto;

/**
 *
 * @author Bito
 */
public class Main {
    public static void main(String[] args) {
        
    Inventario inventario = new Inventario();
    inventarioDAO inventariodao = new inventarioDAO();
    RegistroProducto view = new RegistroProducto();
    ControllerRegistroInventario controlador = new ControllerRegistroInventario(view);

    }
    
}
