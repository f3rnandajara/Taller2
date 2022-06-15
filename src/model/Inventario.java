package model;

/**
 *
 * @author Bito
 */
public class Inventario {
     
    //Atributos Inventario (Variables Globales)
    
    private int codigo;
    private String nombre;
    private int precio;
    private String descripcion;

    //Constructor Vacio
    public Inventario() {
    }

    //Constructor Ingresar
    public Inventario(String nombre, int precio, String descripcion) {

        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;

    }

    //Constructor Actualizar
    public Inventario(int codigo, String nombre, int precio, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
    //getter y setter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
}
