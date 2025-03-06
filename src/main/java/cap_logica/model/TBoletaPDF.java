/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap_logica.model;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author lee_j
 */
public class TBoletaPDF {

    private TCliente cliente;
    private List<TDetalle> detalles;
    private Timestamp fechaDeVenta;

    public TBoletaPDF(TCliente cliente, List<TDetalle> detalles, Timestamp fechaDeVenta) {
        this.cliente = cliente;
        this.detalles = detalles;
        this.fechaDeVenta = fechaDeVenta;
    }

    public TCliente getCliente() {
        return cliente;
    }

    public void setCliente(TCliente cliente) {
        this.cliente = cliente;
    }

    public List<TDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<TDetalle> detalles) {
        this.detalles = detalles;
    }

    public Timestamp getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(Timestamp fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public Double calcularTotalVenta() {
        //this function uses a lambda expression to sum prices :D
        //TDetalle::getIdProducto or (detalle -> detalle.getPrecioVenta())
        return detalles.stream().mapToDouble(detalle -> detalle.getPrecioVenta())
                .sum();
    }

}
