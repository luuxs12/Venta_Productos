
package cap_logica;

public class TCliente extends Persona{
    private int id;
    private int dni;

    public TCliente(String nombre, String apellido,int dni ) {
        super(nombre, apellido);
        this.dni = dni;
    }

    public TCliente(int id,String nombre, String apellido,int dni ) {
        super(nombre, apellido);
        this.id = id;
        this.dni = dni;
    }

    public TCliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
    
}
