/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Datosprincipales;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio Arce
 */
public class DatosprincipalesNegocio {
    private Datosprincipales datos;

    public DatosprincipalesNegocio() {
        datos = new Datosprincipales();
    }

    public DatosprincipalesNegocio(String titulo, String descripcion, int idcliente) {
        this.datos = new Datosprincipales(0, titulo, descripcion, idcliente);
    }

    public Datosprincipales getDatos() {
        return datos;
    }

    public void setDatos(Datosprincipales datos) {
        this.datos = datos;
    }
    
    public boolean guardar(){
        return datos.guardar();
    }
    
    public boolean modificar(){
        return datos.modificar();
    }
    
    public boolean eliminar(){
        return datos.borrar();
    }
    
    public DefaultTableModel listar(){
        return datos.listarTodos();
    }
}
