package cap_logica.model;

import java.sql.Timestamp;

public class TVenta {
    private int idboleta;
    private Timestamp fechaBoleta;
    private int idCliente;

    public TVenta(int idboleta, Timestamp fechaBoleta, int idCliente) {
        this.idboleta = idboleta;
        this.fechaBoleta = fechaBoleta;
        this.idCliente = idCliente;
    }

    public TVenta() {}

    
    public int getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(int idboleta) {
        this.idboleta = idboleta;
    }

    public Timestamp getFechaBoleta() {
        return fechaBoleta;
    }

    public void setFechaBoleta(Timestamp fechaBoleta) {
        this.fechaBoleta = fechaBoleta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
