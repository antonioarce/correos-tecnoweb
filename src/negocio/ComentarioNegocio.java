/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Comentario;
import java.sql.Date;
import java.sql.Time;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio Arce
 */
public class ComentarioNegocio {
    private Comentario comentario;

    public ComentarioNegocio() {
        comentario = new Comentario();
    }

    public ComentarioNegocio(String descripcion, int idpersona,int idmultimedia) {
        long tiempo = System.currentTimeMillis();
        this.comentario = new Comentario(0, descripcion, new Date(tiempo), new Time(tiempo), idpersona, idmultimedia);
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }
    
    public boolean guardar(){
        return comentario.guardar();
    }
    
    public boolean modificar(){
        return comentario.modificar();
    }
    
    public boolean eliminar(){
        return comentario.borrar();
    }
    
    public DefaultTableModel listar(){
        return comentario.listarTodos();
    }
    
}
