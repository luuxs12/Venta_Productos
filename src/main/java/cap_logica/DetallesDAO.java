package cap_logica;

import cap_logica.model.TDetalle;
import cap_bd.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DetallesDAO implements Crud<TDetalle> {
    
    @Override
    public Integer registrar(TDetalle data) {
        PreparedStatement ps = null;

        String sql = "INSERT INTO detalle (fkboleta, fkproducto,cantidad,precioVenta) VALUES (?, ?,?,?)";

        try {
            ps = ConexionDB.getInstancia().getConnection().prepareStatement(sql);
            ps.setInt(1, data.getIdBoleta());
            ps.setInt(2, data.getIdProducto());
            ps.setInt(3, data.getCantidad());
            ps.setDouble(4, data.getPrecioVenta());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("detalle registrado exitosamente: ");
            } else {
                System.out.println("Error al registrar detalle.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el detalle: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<TDetalle> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    public List<TDetalle> getDetallesByBoletaId(int id) {
         String sql = "SELECT * FROM detalle where fkBoleta = ? ";
        
        PreparedStatement ps = null;
        List<TDetalle>datos = new ArrayList(); 
        
        try {
            ps = ConexionDB.getInstancia().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

           while (rs.next()) {
                TDetalle c = new TDetalle();
                c.setIdDetalle(rs.getInt(1));
                c.setIdBoleta(rs.getInt(2));
                c.setIdProducto(rs.getInt(3));
                c.setCantidad(rs.getInt(4))  ;
                c.setPrecioVenta(rs.getDouble(5));
                datos.add(c);
            }

        } catch (Exception e) {
            System.out.println("Error al consultarid del cliente: " + e.getMessage());
        }
        return datos;
 
    }

    @Override
    public void cargarDatosTabla(DefaultTableModel tableModel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(TDetalle data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public TDetalle consultarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
