/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Antonio Arce
 */
public class Conexion {
    private static final String URL = "jdbc:postgresql://mail.ficct.uagrm.edu.bo:5432/db_grupo08sa";
    private static final String CLASE_CONEXION = "org.postgresql.Driver";
    private static final String USERNAME = "grupo08sa";
    private static final String PASSWORD = "grupo08grupo08";
    
    private static Connection conexion = null; 
    
    private static void realizaConexion(){                    
            try {
                Class.forName(CLASE_CONEXION);
                conexion = DriverManager.getConnection(URL,  USERNAME, PASSWORD);
                System.out.println("Conexion exitosa!!!");
            } catch (Exception e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
            }
    }
    
    public static Connection getConnection(){
        if (conexion == null) {
            realizaConexion();
        }
        return conexion;    
    }
    
    public static void cerrarConexion(){
        try {
            conexion.close();
            System.out.println("Conexion cerrada con exitosa!!!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
 
}
