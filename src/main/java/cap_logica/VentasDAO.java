package cap_logica;

import cap_bd.CConexion;

import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VentasDAO implements CRUD<TVenta> {

    @Override
    public Integer registrar(TVenta data) {
        Integer idboleta=null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO boleta (fechaBoleta, fkcliente) VALUES (?, ?)";

        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, data.getFechaBoleta());
            ps.setInt(2, data.getIdCliente());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("boleta registrado exitosamente: ");
                ResultSet llavegenerada = ps.getGeneratedKeys();
                if(llavegenerada.next()){
                    idboleta = llavegenerada.getInt(1);
                }
            } else {
                System.out.println("Error al registrar boleta.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar boleta: " + e.getMessage());
        }
        return idboleta;
    }

    @Override
    public List<TVenta> listar() {
        List<TVenta> datos = new ArrayList<>();
         String sql = "SELECT * FROM boleta";

        try ( PreparedStatement ps = CConexion.getInstancia().getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TVenta v = new TVenta(
                        rs.getInt(1),
                        rs.getTimestamp(2),
                        rs.getInt(3)
                );
                datos.add(v);
            }
        } catch (Exception e) {
            System.out.println("Error al listar las boletas: " + e.getMessage());
        }
        return datos;

    }

    @Override
    public void Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TVenta consultarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cargarDatosTabla(DefaultTableModel tableModel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Actualizar(TVenta data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
