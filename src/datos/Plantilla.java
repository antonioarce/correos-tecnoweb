/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio Arce
 */
public abstract class Plantilla {
    
    public Conexion conexion;
    
    public abstract String insertar();
    public abstract String actualizar();
    public abstract String eliminar();
    public abstract String listar();
    public abstract int cantidadAtributos();
    
    
    private boolean consultar(String consulta){
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta);         
            boolean resultado = !st.execute();
            st.close();
            return resultado;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean guardar(){
        return consultar(insertar());
    }
    
    public boolean modificar(){
        return consultar(actualizar());
    }
    
    public boolean borrar(){
        return consultar(eliminar());
    }
    
    public List<Object> listarTodos(){
        List<Object> lista = new ArrayList<>();
        try {
            Connection con = Conexion.getConnection();
            Statement consulta = con.createStatement();
            ResultSet resultado = consulta.executeQuery(listar());
            while (resultado.next()) {                
                ArrayList<Object> obj = new ArrayList<>();
                for (int i = 1; i <= cantidadAtributos(); i++) {
                    obj.add(resultado.getObject(i));
                }
                lista.add(obj);
            }
            consulta.close();
            return lista;
            
        } catch (SQLException e) {
            return null;
        }
    }
    
    
}
