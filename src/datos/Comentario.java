package datos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean buscar(){
        String consulta = "select * from comentario where id = "+id;
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta);    
            ResultSet rs = st.executeQuery();
            boolean sw = true;
            if (rs.next()) {
                System.out.println(consulta + " - REALIZADA CON EXITO");
                this.id = rs.getInt("id");
                this.descripcion = rs.getString("descripcion");
                this.fecha = rs.getDate("fecha");
                this.hora=rs.getTime("hora");
                this.idpersona = rs.getInt("idpersona");
                this.idmultimedia = rs.getInt("idmultimedia");
            }else{
                System.out.println(consulta + " - NO SE REALIZO CORRECTAMENTE");
                sw = false;
            }              
            st.close();
            return sw;
        } catch (SQLException e) {
            System.out.println(consulta + " - ERROR - "+e.getMessage());
            return false;
        }
    }
    
    @Override
    public String insertar() {
        return "insert into comentario(descripcion,fecha,hora,idpersona,idmultimedia) values('"+descripcion+"','"+fecha.toString()+"','"+hora.toString()+"',"+idpersona+","+idmultimedia+")";
    }

    @Override
    public String actualizar() {
        return "update comentario set descripcion='"+descripcion+"',idpersona="+idpersona+",idmultimedia="+idmultimedia+"  where id="+id;
    }

    @Override
    public String eliminar() {
        return "delete from comentario where id="+id;
    }

    @Override
    public String listar() {
        return "select * from comentario where idmultimedia = " + idmultimedia;
    }

    @Override
    public int cantidadAtributos() {
        return 6;
    }

    @Override
    public Object[] columnas() {
        return new Object[]{"Id","Descripcion","Fecha","Hora","Idmultimedia","Idpersona"};
    }

    
}
