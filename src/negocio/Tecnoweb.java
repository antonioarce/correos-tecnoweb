/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimePullMultipart;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import datos.Conexion;
import datos.Cliente;
import datos.Comentario;
import datos.Contacto;
import datos.Datosprincipales;
import datos.Multimedia;
import datos.Persona;
import datos.Sugerencia;
import datos.Usuario;
import core.utilidades.Herramientas;
/**
 *
 * @author Antonio Arce
 */
public class Tecnoweb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Connection cnn = Conexion.getConnection();
        Conexion.cerrarConexion();*/
//        try {
//            Class _class = Class.forName("model.Contacto");
//            Field properties[] = _class.getFields();
//            for (Field property : properties) {
//                //System.out.println(property.toString());
//                System.out.println(property.getName() + " " + property.getType().getSimpleName());
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
    /*Persona persona= new Persona(1, "JUPA CHUMA", "JUmA@JUANQUI", "01234560", "0123405", "102345", "123450", 763214580, 2, 2);
    persona.modificar();*/
        /*if (persona.guardar()) {
            System.out.println("ok");
        }else{
            System.out.println("no ok");
        }*/
    
        //MCliente cliente = new Cliente(1, "B/los cusis", "wwww.edudu.c0m.b0", 2, 2);
        //cliente.modificar();
       //MUsuario usuario= new Usuario("CHAOP", 3);
        //usuario.modificar();
        //cliente.guardar();
        
       // Datosprincipales datos= new Datosprincipales(1, "Carpintero 2", "Manejo de maquinas industriales 2", 1);
        //datos.modificar();
        //MContacto contacto= new Contacto(new Date(117, 2, 19), 1, 2);
        //contacto.modificar();
        //contacto.guardar();
        //datos.guardar();
        
        //MMultimedia video=new Multimedia(1, "Busco2", 2, 2, 1, "www.edudu.bo/video24.mp4", 2 , new Date(117, 2, 17),new Time(11, 0, 0), 1);
        //video.modificar();
       // Multimedia foto=new Multimedia(0, "Busco", 2, 2, 1, "www.edu.bo/publicidad2.jpg", 1 , new Date(2017, 2, 17),new Time(12, 0, 0), 1);
       // video.guardar();
        //foto.guardar();
        
        /*Comentario comen= new Comentario(1, "todo mal", new Date(117, 5, 5), new Time(11, 15, 11), 2, 1);
        comen.modificar();
        Sugerencia suge= new Sugerencia(1, 2, 3, "hola 3", new Date(117,6, 16), new Time(16, 16, 0), 2);
        suge.modificar();*/
        /*comen.guardar();
        suge.guardar();*/
        System.out.println(Herramientas.dibujarTabla((new Persona()).listarTodos()));
        //Herramientas.dibujarTabla((new Persona()).listarTodos());
    }
    
    
}
