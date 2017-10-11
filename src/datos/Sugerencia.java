package datos;
import java.sql.Date;
import java.sql.Time;

/**
 * @author Antonio Arce
 * @version 1.0
 * @created 07-oct.-2017 6:09:52
 */
public class Sugerencia extends Plantilla{
    private int id;
    private int idsugeridor;
    private int idreceptor;
    private String descripcion;
    private Date fecha;
    private Time hora;
    private int idmultimedia;

    public Sugerencia() {

    }

    public Sugerencia(int id, int idsugeridor, int idreceptor, String descripcion, Date fecha, Time hora, int idmultimedia) {
        this.id=id;
        this.idsugeridor = idsugeridor;
        this.idreceptor = idreceptor;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.idmultimedia = idmultimedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdsugeridor() {
        return idsugeridor;
    }

    public void setIdsugeridor(int idsugeridor) {
        this.idsugeridor = idsugeridor;
    }

    public int getIdreceptor() {
        return idreceptor;
    }

    public void setIdreceptor(int idreceptor) {
        this.idreceptor = idreceptor;
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

    public int getIdmultimedia() {
        return idmultimedia;
    }

    public void setIdmultimedia(int idmultimedia) {
        this.idmultimedia = idmultimedia;
    }

    @Override
    public String insertar() {
        return "insert into sugerencia(idsugeridor,idreceptor, descripcion,fecha,hora,idmultimedia) values("+idsugeridor+","+idreceptor+",'"+descripcion+"','"+fecha.toString()+"','"+hora.toString()+"',"+idmultimedia+")";
    }

    @Override
    public String actualizar() {
        return "update sugerencia set idsugeridor = "+idsugeridor+",idreceptor="+idreceptor+",descripcion= '"+descripcion+"',fecha='"+fecha.toString()+"',hora='"+hora.toString()+"',idmultimedia="+idmultimedia+"  where id="+id;
    }

    @Override
    public String eliminar() {
        return "delete from sugerencia where id="+id;
    }

    @Override
    public String listar() {
        return "select * from sugerencia";
    }

    @Override
    public int cantidadAtributos() {
        return 7;
    }

    @Override
    public Object[] columnas() {
        return new Object[]{"Id","Idsugeridor","Idreceptor","Descripcion","Fecha","Hora","Idmultimedia"};
    }
    
    

}
