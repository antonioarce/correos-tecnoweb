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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio Arce
 */
public abstract class Plantilla {
    
    private Conexion conexion;
    
    protected abstract String insertar();
    protected abstract String actualizar();
    protected abstract String eliminar();
    protected abstract String listar();
    protected abstract int cantidadAtributos();
    protected abstract Object[] columnas();
    
    
    private boolean consultar(String consulta){
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta);         
            boolean resultado = !st.execute();
            if (resultado) {
                System.out.println(consulta + " - REALIZADA CON EXITO");
            }else{
                System.out.println(consulta + " - NO SE REALIZO CORRECTAMENTE");
            }
            st.close();
            return resultado;
        } catch (SQLException e) {
            System.out.println(consulta + " - ERROR - "+e.getMessage());
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
    
    public DefaultTableModel listarTodos(){
        List<Object> lista = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnas());
        try {
            Connection con = Conexion.getConnection();
            Statement consulta = con.createStatement();
            ResultSet resultado = consulta.executeQuery(listar());
            while (resultado.next()) {                
                Object[] obj = new Object[cantidadAtributos()];
                for (int i = 1; i <= cantidadAtributos(); i++) {
                    obj[i-1] = resultado.getObject(i);
                }
                model.addRow(obj);
            }
            return model;
            
        } catch (SQLException e) {
            return null;
        }
    }
    
    
}
