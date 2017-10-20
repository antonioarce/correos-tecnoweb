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

/**
 *
 * @author Antonio Arce
 */
public class Estadistica {
    
    private boolean ok;
    private int id;
    private int vistos;
    private int publicaciones;
    private int comentarios;
    private int sugerencias;
    private int imagenes;
    private int videos;

    public Estadistica(int idcliente) {
        id = idcliente;
        String consulta = "select * from reportesporcliente where id = " + id;
        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement st = conn.prepareStatement(consulta);    
            ResultSet rs = st.executeQuery();
            ok = true;
            if (rs.next()) {       
                this.vistos = rs.getInt("vistos");
                this.publicaciones = rs.getInt("publicaciones");
                this.comentarios = rs.getInt("comentarios");
                this.sugerencias = rs.getInt("sugerencias");
                this.imagenes = rs.getInt("imagenes");
                this.videos = rs.getInt("videos");
            }else{
                System.out.println(consulta + " - NO SE REALIZO CORRECTAMENTE");
                ok = false;
            }              
            st.close();
            
        } catch (SQLException e) {
            ok = false;
            
        }
    }

    public boolean isOk() {
        return ok;
    }

    public int getIdCliente() {
        return id;
    }

    public int getVistos() {
        return vistos;
    }

    public int getPublicaciones() {
        return publicaciones;
    }

    public int getComentarios() {
        return comentarios;
    }

    public int getSugerencias() {
        return sugerencias;
    }

    public int getImagenes() {
        return imagenes;
    }

    public int getVideos() {
        return videos;
    }

    @Override
    public String toString() {
        String s = "Visitas Realilzadas: " + vistos + "\n\r";
        s += "Publicaciones Realizadas: " + publicaciones + "\n\r";
        s += "Comentarios en mis publicaciones: " + comentarios + "\n\r";
        s += "Sugerencias a mis publicaciones: " + sugerencias + "\n\r";
        s += "Imagenes Publicadas: " + imagenes + "\n\r";
        s += "Videos Publicados: " + videos + "\n\r";
        return s;
    }
    
    
    
    
    
    
}
