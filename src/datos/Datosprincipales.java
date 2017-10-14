package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public boolean buscar(){
        String consulta = "select * from datosprincipales where id = "+id;
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta);    
            ResultSet rs = st.executeQuery();
            boolean sw = true;
            if (rs.next()) {
                System.out.println(consulta + " - REALIZADA CON EXITO");
                this.id = rs.getInt("id");
                this.titulo = rs.getString("titulo");
                this.descripcion = rs.getString("descripcion");
                this.idcliente = rs.getInt("idcliente");
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
        return "select * from datosprincipales where idcliente = " + idcliente;
    }

    @Override
    public int cantidadAtributos() {
        return 4;
    }

    @Override
    public Object[] columnas() {
        return new Object[]{"Id","Titulo","Descripcion","Idcliente"};
        
    }
    
    

}
