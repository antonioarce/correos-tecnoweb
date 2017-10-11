package datos;
/**
 * @author Antonio Arce
 * @version 1.0
 * @created 07-oct.-2017 6:09:42
 */
public class Datosprincipales extends Plantilla {

    private int id;
    private String titulo;
    private String descripcion;
    private int idcliente;

    public Datosprincipales() {

    }

    public Datosprincipales(int id, String titulo, String descripcion, int idcliente) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.idcliente = idcliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public String insertar() {
        return "insert into datosprincipales(titulo, descripcion, idcliente) values('"+titulo + "', '" + descripcion + "', " + idcliente+")";
    }

    @Override
    public String actualizar() {
        return "update datosprincipales set titulo = '"+titulo+"', descripcion = '"+descripcion+"', idcliente =" +idcliente+" where id ="+id;
    }

    @Override
    public String eliminar() {
        return "delete from datosprincipales where id = "+id;
    }

    @Override
    public String listar() {
        return "select * from datosprincipales";
    }

    @Override
    public int cantidadAtributos() {
        return 4;
    }
    
    

}
