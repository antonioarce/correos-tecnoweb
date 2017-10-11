package datos;
/**
 * @author Antonio Arce
 * @version 1.0
 * @created 07-oct.-2017 6:09:31
 */
public class Usuario extends Plantilla{

    private String empresa;
    private int id;

    public Usuario() {

    }

    public Usuario(String empresa, int id) {
        this.empresa = empresa;
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String insertar() {
        return "insert into usuario(id, empresa) values("+id+",'"+empresa+"')";
    }

    @Override
    public String actualizar() {
        return "update usuario set empresa= '"+empresa+"' where id="+id;
    }

    @Override
    public String eliminar() {
        return "delete from usuario where id="+id;
    }

    @Override
    public String listar() {
        return "select * from usuario";
    }

    @Override
    public int cantidadAtributos() {
        return 2;
    }

    
}
