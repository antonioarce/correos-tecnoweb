package datos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.table.DefaultTableModel;

/**
 * @author Antonio Arce
 * @version 1.0
 * @created 07-oct.-2017 6:09:46
 */
public class Multimedia extends Plantilla{

    private int id;
    private String titulo;
    private int contador;
    private int comentarios;
    private int sugerencias;
    private String url;
    private int tipo;
    private Date fecha;
    private Time hora;
    private int idcliente;

    public Multimedia() {

    }

    public Multimedia(int id, String titulo, int contador, int comentarios, int sugerencias, String url, int tipo, Date fecha,Time hora, int idcliente) {
        this.id = id;
        this.titulo = titulo;
        this.contador = contador;
        this.comentarios = comentarios;
        this.sugerencias = sugerencias;
        this.url = url;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.idcliente = idcliente;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getComentarios() {
        return comentarios;
    }

    public void setComentarios(int comentarios) {
        this.comentarios = comentarios;
    }

    public int getSugerencias() {
        return sugerencias;
    }

    public void setSugerencias(int sugerencias) {
        this.sugerencias = sugerencias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public boolean buscar(){
        String consulta = "select * from multimedia where id = "+id;
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta);    
            ResultSet rs = st.executeQuery();
            boolean sw = true;
            if (rs.next()) {
                System.out.println(consulta + " - REALIZADA CON EXITO");
                this.id = rs.getInt("id");
                this.titulo = rs.getString("direccion");
                this.url = rs.getString("web");
                this.contador = rs.getInt("vistos");
                this.comentarios = rs.getInt("publicaciones");
                this.sugerencias = rs.getInt("publicaciones");
                this.fecha = rs.getDate("fecha");
                this.hora=rs.getTime("hora");
                this.idcliente = rs.getInt("idcliente");
                this.tipo = rs.getInt("tipo");
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
        return "insert into multimedia(titulo, contador, comentarios, sugerencias, url, tipo, fecha,hora, idcliente) values('"+titulo+"',"+contador+","+comentarios+","+sugerencias+",'"+url+"',"+tipo+",'"+fecha.toString()+"','"+hora.toString()+"',"+idcliente+")";
    }

    @Override
    public String actualizar() {
        return "update multimedia set titulo = '"+titulo+"', contador="+contador+", comentarios= "+comentarios+",sugerencias="+sugerencias+", url='"+url+"',fecha='"+fecha.toString()+"',"+"hora='"+hora.toString()+"',idcliente= "+idcliente+" where id="+id;
    }

    @Override
    public String eliminar() {
        return "delete from multimedia where id = " + id;
    }

    @Override
    public String listar() {
        return "select * from multimedia where idcliente = "+idcliente;
    }

    @Override
    public int cantidadAtributos() {
        return 10;
    }

    @Override
    public Object[] columnas() {
        return new Object[]{"Id","Titulo","Contador","Comentarios","Sugerencias","Url","Tipo","Fecha","Hora","Idcliente"};
    }
    
}
