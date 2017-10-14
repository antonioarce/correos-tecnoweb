package datos;
import java.sql.Date;

/**
 * @author Antonio Arce
 * @version 1.0
 * @created 07-oct.-2017 6:09:35
 */
public class Contacto extends Plantilla{

    public Date fecha;
    private int idcliente;
    private int idusuario;

    public Contacto() {
    }

    public Contacto(Date fecha, int idcliente, int idusuario) {
        this.fecha = fecha;
        this.idcliente = idcliente;
        this.idusuario = idusuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public String insertar() {
        return "insert into contacto (idcliente, idusuario, fecha) values (" +idcliente + ", " + idusuario + ", '" + fecha.toString() +"')";
    }

    @Override
    public String actualizar() {
        return null;
    }

    @Override
    public String eliminar() {
        return "delete from contacto where idcliente = "+idcliente+" and idusuario = " + idusuario;
    }

    @Override
    public String listar() {
        return "select * from contacto where idusuario = " + idusuario;
    }

    @Override
    public int cantidadAtributos() {
        return 3;
    }

    @Override
    public Object[] columnas() {
        return new Object[]{"Idcliente","Idusuario","Fecha"};
    }
    
    

}
