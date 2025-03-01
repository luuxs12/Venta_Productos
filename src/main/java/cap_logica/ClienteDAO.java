package cap_logica;

import cap_bd.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClienteDAO implements CRUD<TCliente> {


    @Override
    public void registrar(TCliente data) {

        PreparedStatement ps = null;

        String sql = "INSERT INTO cliente (nombres, apellidos, dni) VALUES (?, ?, ?)";

        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql);
            ps.setString(1, data.getNombre());
            ps.setString(2, data.getApellido());
            ps.setInt(3, data.getDni());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente registrado exitosamente: " + data.getNombre() + " " + data.getApellido());
            } else {
                System.out.println("Error al registrar el cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el cliente: " + e.getMessage());
        }

    }

    @Override
    public List<TCliente> listar() {
        List<TCliente> datos = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try ( PreparedStatement ps = CConexion.getInstancia().getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TCliente c = new TCliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                datos.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los clientes: " + e.getMessage());
        }
        return datos;
    }

    @Override
    public void Eliminar() {

    }

    @Override
    public TCliente consultarPorId(int id) {
        TCliente c = new TCliente(null, null, 0);
        String sql = "select * from cliente where idcliente=?";

        PreparedStatement ps = null;

        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDni(rs.getInt(4));
            } else {
                System.out.println("No se encontró un cliente con ID: " + id);
            }

        } catch (Exception e) {
            System.out.println("Error al consultarid del cliente: " + e.getMessage());
        }
        return c;

    }

    @Override
    public void cargarDatosTabla(DefaultTableModel tableModel) {
        List<TCliente> clientes = listar();

        tableModel.setRowCount(0);

        for (TCliente cliente : clientes) {
            tableModel.addRow(new Object[]{
                cliente.getId(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getDni()

            });

        }

    }

    @Override
    public void Actualizar(TCliente data) {
        String sql = "UPDATE cliente SET nombres = ?, apellidos = ?, dni = ? WHERE idcliente = ?";

        PreparedStatement ps = null;
        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql);
            // Asignar los valores del cliente al PreparedStatement
            ps.setString(1, data.getNombre());
            ps.setString(2, data.getApellido());
            ps.setInt(3, data.getDni());
            ps.setInt(4, data.getId());
            // Ejecutar la inserción
            int rowsAffected = ps.executeUpdate();

            // Confirmación en consola
            if (rowsAffected > 0) {
                System.out.println("Cliente Actualido exitosamente: ");
            } else {
                System.out.println("Error al Actualizar el cliente.");
            }
        } catch (Exception e) {
            System.out.println("Error al Actualizar el cliente: " + e.getMessage());
        }
    }

    @Override
    public void Eliminar(int id) {
        String sql = "DELETE FROM cliente where idcliente=?";

        PreparedStatement ps = null;

        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            // Ejecutar la inserción
            int rowsAffected = ps.executeUpdate();

            // Confirmación en consola
            if (rowsAffected > 0) {
                System.out.println("Cliente eliminado exitosamente: " + id);
            } else {
                System.out.println("Error al eliminado el cliente.");
            }

        } catch (Exception e) {
            System.out.println("Error al consultarid del cliente: " + e.getMessage());
        }

    }

}
