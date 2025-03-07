/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap_logica.model;

/**
 *
 * @author eramos This is a clear example of persistence classes. TProducto is like Productos in the Database
 */
public class TProducto {

    private Integer idproducto;
    private Double precioProducto;
    private String nombre;
    private Integer stock;

    public TProducto() {
    }

    public TProducto(Integer idProducto, String nombre, Double precioProducto, Integer stock) {
        this.idproducto = idProducto;
        this.precioProducto = precioProducto;
        this.nombre = nombre;
        this.stock = stock;
    }

    public Integer getIdProducto() {
        return idproducto;
    }

    public void setIdProducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
