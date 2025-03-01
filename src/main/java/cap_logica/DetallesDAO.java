package cap_logica;

import cap_bd.CConexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DetallesDAO implements CRUD<TDetalle> {

    private VentasDAO ventaDAO= new VentasDAO();
    
    @Override
    public Integer registrar(TDetalle data) {
        PreparedStatement ps = null;

        String sql = "INSERT INTO detalle (fkboleta, fkproducto,cantidad,precioVenta) VALUES (?, ?,?,?)";

        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql);
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
    public void Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TDetalle consultarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cargarDatosTabla(DefaultTableModel tableModel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Actualizar(TDetalle data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   /*public Integer generarIdVenta() {
        // Obtener la cantidad de órdenes ya registradas hoy
       List<TVenta> ventas = ventaDAO.listar();
        int contador =    ventas.get(ventas.size() - 1).getIdboleta() + 1 ; // Incrementar el número de orden
        
       
        // Formar el código de orden único
        return contador;
    }*/


}
