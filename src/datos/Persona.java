package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Persona extends Plantilla{

    private int id;
    private String nombrecompleto;
    private String email;
    private String password;

    private int celular;
    private int tipo;
    private int genero;

    public Persona() {

    }

    public Persona(int id, String nombrecompleto, String email, String password,int celular, int tipo, int genero) {
        this.id = id;
        this.nombrecompleto = nombrecompleto;
        this.email = email;
        this.password = password;

        this.celular = celular;
        this.tipo = tipo;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
    
    public boolean buscar(){
        String consulta = "select * from persona where id = " + id;
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta);    
            ResultSet rs = st.executeQuery();
            boolean sw = true;
            if (rs.next()) {
                System.out.println(consulta + " - REALIZADA CON EXITO");
                this.id = rs.getInt("id");
                this.nombrecompleto = rs.getString("nombrecompleto");
                this.email = rs.getString("email");
                this.password = rs.getString("password");
                this.celular = rs.getInt("celular");
                this.tipo = rs.getInt("tipo");
                this.genero = rs.getInt("genero");
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
    
    public boolean buscarPorCorreo(){
        String consulta = "select * from persona where email = '"+email+"'";
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta);    
            ResultSet rs = st.executeQuery();
            boolean sw = true;
            if (rs.next()) {
                System.out.println(consulta + " - REALIZADA CON EXITO");
                this.id = rs.getInt("id");
                this.nombrecompleto = rs.getString("nombrecompleto");
                this.email = rs.getString("email");
                this.password = rs.getString("password");
                this.celular = rs.getInt("celular");
                this.tipo = rs.getInt("tipo");
                this.genero = rs.getInt("genero");
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

    public void setAutoincrement(){
        id = autoincrement;
    }
    @Override
    public String insertar() {
        return "insert into persona(nombrecompleto,email,password,celular,tipo,genero) values('"+nombrecompleto+"','"
                +email+"','"+
                password+"',"              
                +celular+","
                +tipo+","
                +genero
                +")";
    }

    @Override
    public String actualizar() {
        return "update persona set "
                +"nombrecompleto='"+nombrecompleto+"',"
                +"email='"+email+"',"
                +"password='"+password+"',"
                +"celular="+celular+","
                +"tipo="+tipo+","
                +"genero="+genero+" "
                +" where id="+id;
    }

    @Override
    public String eliminar() {
        return "delete from persona where id="+id;
    }

    @Override
    public String listar() {
        return "select * from persona";
    }

    @Override
    public int cantidadAtributos() {
        return 7;
    }

    @Override
    public Object[] columnas() {
        return new Object[]{"Id","NombreCompleto","Email","Password","Celular","Tipo","Genero"};
    }
    
    

}
