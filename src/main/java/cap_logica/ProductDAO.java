/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cap_logica;

import cap_bd.CConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lee_j
 */
public class ProductDAO implements CRUD<TProducto>  {
    
    
    @Override
    public Integer registrar(TProducto data) {

        PreparedStatement ps = null;

        String sql = "INSERT INTO producto (nombre, precioProducto, stock) VALUES (?, ?, ?)";

        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql);
            ps.setString(1, data.getNombre());
            ps.setDouble(2, data.getPrecioProducto());
            ps.setInt(3, data.getStock());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Producto registrado exitosamente: " + data.getNombre());
            } else {
                System.out.println("Error al registrar el producto.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el producto: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<TProducto> listar() {
        List<TProducto> datos = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try ( PreparedStatement ps = CConexion.getInstancia().getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TProducto c = new TProducto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4)
                );
                datos.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error al listar los productos: " + e.getMessage());
        }
        return datos;
    }

    @Override
    public void Eliminar() {

    }

    @Override
    public TProducto consultarPorId(int id) {
        TProducto p = null; 
        String sql = "select * from producto where idproducto=?";

        PreparedStatement ps = null;

        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new TProducto();
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecioProducto(rs.getDouble(3));
                p.setStock(rs.getInt(4));
            } else {
                System.out.println("No se encontró un producto con ID: " + id);
            }

        } catch (Exception e) {
            System.out.println("Error al consultarid del producto: " + e.getMessage());
        }
        return p;

    }

    @Override
    public void cargarDatosTabla(DefaultTableModel tableModel) {
        List<TProducto> productos = listar();

        tableModel.setRowCount(0);

        for (TProducto producto : productos) {
            tableModel.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getPrecioProducto(),
                producto.getStock(),
            });

        }

    }

    @Override
    public void Actualizar(TProducto data) {
        String sql = "UPDATE producto SET precioProducto = ?, stock = ?, nombre = ? WHERE idproducto = ?";

        PreparedStatement ps = null;
        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql);
            // Asignar los valores del producto al PreparedStatement
            ps.setDouble(1, data.getPrecioProducto());
            ps.setInt(2, data.getStock());
            ps.setString(3, data.getNombre());
            ps.setInt(4, data.getIdProducto());
            // Ejecutar la inserción
            int rowsAffected = ps.executeUpdate();

            // Confirmación en consola
            if (rowsAffected > 0) {
                System.out.println("Producto Actualido exitosamente: ");
            } else {
                System.out.println("Error al Actualizar el producto.");
            }
        } catch (Exception e) {
            System.out.println("Error al Actualizar el producto: " + e.getMessage());
        }
    }

    @Override
    public void Eliminar(int id) {
        String sql = "DELETE FROM producto where idproducto=?";

        PreparedStatement ps = null;

        try {
            ps = CConexion.getInstancia().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            // Ejecutar la inserción
            int rowsAffected = ps.executeUpdate();

            // Confirmación en consola
            if (rowsAffected > 0) {
                System.out.println("Producto eliminado exitosamente: " + id);
            } else {
                System.out.println("Error al eliminado el producto.");
            }

        } catch (Exception e) {
            System.out.println("Error al consultarid del producto: " + e.getMessage());
        }

    }
    
}
