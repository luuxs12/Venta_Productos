
package cap_logica;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public interface CRUD<O> {
    public void registrar(O data);
    public List<O> listar();
    public void Eliminar();
    public O consultarPorId(int id);
    public void cargarDatosTabla(DefaultTableModel tableModel);
    public void Actualizar(O data);
    public void Eliminar(int id);
}
