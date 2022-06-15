package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Inventario;
import model.inventarioDAO;
import view.RegistroProducto;

/**
 *
 * @author Bito
 */
public class ControllerRegistroInventario implements ActionListener{
    //Llamamos a las clases(Variables Globales)
    Inventario inventario = new Inventario();
    inventarioDAO inventariodao = new inventarioDAO();
    RegistroProducto view = new RegistroProducto();
    DefaultTableModel productoTabla = new DefaultTableModel();

    //Constructor Interfaz
    public ControllerRegistroInventario(RegistroProducto view) {
        this.view = view;
        view.setVisible(true);//hacemos view visible 
        agregarEventos();
        listarTabla();
        
    }


    //Agtegamos Eventos para lectura de botones: Declaramos ActionListener para cada botón (Los llamamos mediante la view)
    private void agregarEventos(){
        this.view.BtnActualizar.addActionListener(this);
        this.view.BtnIngresar.addActionListener(this);
        this.view.BtnEliminar.addActionListener(this);
        this.view.BtnLimpiar.addActionListener(this);
        this.view.BtnSalir.addActionListener(this);
        this.view.TableInventario.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                llenarCampos(e);
                
            }
            
        });
 }
    //TABLA
    private void listarTabla(){
        String[] titulos = new String[]{"Código", "Nombre", "Precio", "Descripcion"}; //Arreglo
        productoTabla = new DefaultTableModel(titulos, 0);
        List<Inventario> listaProducto = inventariodao.listar();//ArrayList
        for (Inventario inventario : listaProducto){
            productoTabla.addRow(new Object[]{inventario.getCodigo(), inventario.getNombre(), inventario.getPrecio(), inventario.getDescripcion()});//Array unidimensional
        }
        this.view.TableInventario.setModel(productoTabla);
        this.view.TableInventario.setPreferredSize(new Dimension(800, productoTabla.getRowCount() * 16));
    }
    
    //Llenar campos
    private void llenarCampos(MouseEvent e){
        JTable target = (JTable) e.getSource();
        
        view.TxtNombre.setText(view.TableInventario.getModel().getValueAt(target.getSelectedRow(),1).toString());
        view.TxtPrecio.setText(view.TableInventario.getModel().getValueAt(target.getSelectedRow(),2).toString());
        view.TxtDescripcion.setText(view.TableInventario.getModel().getValueAt(target.getSelectedRow(),3).toString());
    }
    
    //_______________________________________________________________________________________________
    
    private boolean validarDatos(){
        if("", equals(view.TxtNombre().getText()))
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void iniciar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
