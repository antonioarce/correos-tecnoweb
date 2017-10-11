/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Sugerencia;
import java.sql.Date;
import java.sql.Time;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio Arce
 */
public class SugerenciaNegocio {

    private Sugerencia sugerencia;

    public SugerenciaNegocio(int idsugeridor, int receptor,String descripcion, int idmultimedia) {
        long tiempo = System.currentTimeMillis();
        this.sugerencia = new Sugerencia(0, idsugeridor, receptor, descripcion, new Date(tiempo), new Time(tiempo), idmultimedia);
    }

    public SugerenciaNegocio() {
        sugerencia = new Sugerencia();
    }

    public Sugerencia getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(Sugerencia sugerencia) {
        this.sugerencia = sugerencia;
    }
    
    public boolean guardar(){
        return sugerencia.guardar();
    }
    
    public boolean modificar(){
        return sugerencia.modificar();
    }
    
    public boolean eliminar(){
        return sugerencia.borrar();
    }
    
    public DefaultTableModel listar(){
        return sugerencia.listarTodos();
    }
    
}
