/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package cap_presentacion;

import cap_logica.ProductDAO;
import cap_logica.TProducto;
import cap_logica.TCliente;
import static cap_presentacion.FromCliente.mostrarConfirmacion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class FromProducto extends javax.swing.JInternalFrame {
    
    private int id;
    TProducto tproduct = new TProducto();
    private DefaultTableModel tableModel;
    
    ProductDAO productoDAO = new ProductDAO();
    
    public FromProducto() {
        initComponents();
        tableModel = new DefaultTableModel(new String[]{"id", "Nombre", "Precio", "Stock"}, 0);
        
        tbproductos.setModel(tableModel);
        productoDAO.cargarDatosTabla(tableModel);
    }
    
    void limpiarForm() {
        txtidproducto.setText("");
        txtnombreproducto.setText("");
        txtprecioproducto.setText("");
        txtstockproducto.setText("");
    }
    
    private void llenarDatosProductos() {
        int filaseleccionado = tbproductos.getSelectedRow();
        if (filaseleccionado == -1) {
            JOptionPane.showMessageDialog(null, "Cliente no seleccionado");
        } else {
            
            txtidproducto.setText(String.valueOf(tproduct.getIdProducto()));
            txtnombreproducto.setText(tproduct.getNombre());
            txtprecioproducto.setText(tproduct.getPrecioProducto().toString());
            txtstockproducto.setText(String.valueOf(tproduct.getStock()));
            
        }
        
    }
    
    public static boolean mostrarConfirmacion(String mensaje, String titulo) {
        int opcion = JOptionPane.showConfirmDialog(
                null,
                mensaje,
                titulo,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        return opcion == JOptionPane.YES_OPTION;
    }
    
    private void eliminarProducto() {
        int filaseleccionado = tbproductos.getSelectedRow();
        if (filaseleccionado == -1 && filaseleccionado == 0) {
            JOptionPane.showMessageDialog(null, "Cliente no seleccionado");
        } else {
            if (mostrarConfirmacion("¿Estás seguro de eliminar cliente id : " + tproduct.getIdProducto() + "?", "Confirmar Eliminación")) {
                productoDAO.Eliminar(id);
            }
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtidproducto = new javax.swing.JTextField();
        txtnombreproducto = new javax.swing.JTextField();
        txtprecioproducto = new javax.swing.JTextField();
        txtstockproducto = new javax.swing.JTextField();
        btnlimpiarcampos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbproductos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Productos"));

        jLabel1.setText("ID:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        jLabel4.setText("Stock:");

        txtidproducto.setEnabled(false);
        txtidproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidproductoActionPerformed(evt);
            }
        });

        txtnombreproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreproductoActionPerformed(evt);
            }
        });

        btnlimpiarcampos.setText("Limpiar campo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtprecioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlimpiarcampos)
                    .addComponent(txtstockproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtstockproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnlimpiarcampos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbproductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbproductos);

        jLabel5.setText("Click para Seleccionar");

        btnguardar.setText("Guardad");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidproductoActionPerformed

    private void txtnombreproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreproductoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String nombre = txtnombreproducto.getText();
        double precioProducto = Double.parseDouble(txtprecioproducto.getText());
        int stock = Integer.parseInt(txtstockproducto.getText());
        
        TProducto product = new TProducto();
        product.setNombre(nombre);
        product.setPrecioProducto(precioProducto);
        product.setStock(stock);
        
        productoDAO.registrar(product);
        productoDAO.cargarDatosTabla(tableModel);
        limpiarForm();
        

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        int id = Integer.parseInt(txtidproducto.getText());
        String nombre = txtnombreproducto.getText();
        double precioProducto = Double.parseDouble(txtprecioproducto.getText());
        int stock = Integer.parseInt(txtstockproducto.getText());
        
        TProducto product = new TProducto();
        product.setIdProducto(id);
        product.setNombre(nombre);
        product.setPrecioProducto(precioProducto);
        product.setStock(stock);
        
        productoDAO.Actualizar(product);
        productoDAO.cargarDatosTabla(tableModel);
         limpiarForm();
        
        

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        
        eliminarProducto();
        productoDAO.cargarDatosTabla(tableModel);
        limpiarForm();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tbproductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproductosMousePressed
        int fila = tbproductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "cliente no seleccionado");
        } else {
            id = (Integer) tbproductos.getValueAt(fila, 0);
            tproduct = productoDAO.consultarPorId(id);
            llenarDatosProductos();
        }
    }//GEN-LAST:event_tbproductosMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnlimpiarcampos;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbproductos;
    private javax.swing.JTextField txtidproducto;
    private javax.swing.JTextField txtnombreproducto;
    private javax.swing.JTextField txtprecioproducto;
    private javax.swing.JTextField txtstockproducto;
    // End of variables declaration//GEN-END:variables

}
