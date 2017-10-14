package datos;
import java.sql.Date;
import java.sql.Time;

/**
 * @author Antonio Arce
 * @version 1.0
 * @created 07-oct.-2017 6:09:49
 */
public class Comentario extends Plantilla{

    private int id;
    private String descripcion;
    private Date fecha;
    private Time hora;
    private int idpersona;
    private int idmultimedia;

    public Comentario() {

    }

    public Comentario(int id, String descripcion, Date fecha, Time hora, int idpersona, int idmultimedia) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.idpersona = idpersona;
        this.idmultimedia = idmultimedia;
    }
    
    public void setAutoincrement(){
        id = autoincrement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getIdmultimedia() {
        return idmultimedia;
    }

    public void setIdmultimedia(int idmultimedia) {
        this.idmultimedia = idmultimedia;
    }

    @Override
    public String insertar() {
        return "insert into comentario(descripcion,fecha,hora,idpersona,idmultimedia) values('"+descripcion+"','"+fecha.toString()+"','"+hora.toString()+"',"+idpersona+","+idmultimedia+")";
    }

    @Override
    public String actualizar() {
        return "update comentario set descripcion='"+descripcion+"',fecha='"+fecha.toString()+"',hora='"+hora.toString()+"',idpersona="+idpersona+",idmultimedia="+idmultimedia+"  where id="+id;
    }

    @Override
    public String eliminar() {
        return "delete from multimedia where id="+id;
    }

    @Override
    public String listar() {
        return "select * from multimedia";
    }

    @Override
    public int cantidadAtributos() {
        return 6;
    }

    @Override
    public Object[] columnas() {
        return new Object[]{"Id","Descripcion","Fecha","Hora","Idpersona","Idmultimedia"};
    }

    
}
