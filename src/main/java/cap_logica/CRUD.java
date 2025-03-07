package cap_logica;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public interface Crud<O> {

    public Integer registrar(O data);

    public List<O> listar();

    public void eliminarTodo();

    public O consultarPorId(int id);

    public void cargarDatosTabla(DefaultTableModel tableModel);

    public void actualizar(O data);

    public void eliminar(int id);
}
