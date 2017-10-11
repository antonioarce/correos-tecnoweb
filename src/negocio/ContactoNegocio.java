/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Contacto;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio Arce
 */
public class ContactoNegocio {
    private Contacto contacto;

    public ContactoNegocio() {
        contacto = new Contacto();
    }

    public ContactoNegocio(int idcliente, int idusuario) {
        this.contacto = new Contacto(new Date(System.currentTimeMillis()), idcliente, idusuario);
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
    
    public boolean guardar(){
        return contacto.guardar();
    }
    
    public boolean modificar(){
        return contacto.modificar();
    }
    
    public boolean eliminar(){
        return contacto.borrar();
    }
    
    public DefaultTableModel listar(){
        return contacto.listarTodos();
    }
}
