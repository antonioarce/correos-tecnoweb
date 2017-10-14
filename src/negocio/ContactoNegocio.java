/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Contacto;
import datos.Persona;
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
    
    public DefaultTableModel listarContactos(){
        DefaultTableModel listaNueva = new DefaultTableModel();
        listaNueva.setColumnIdentifiers(new Object[]{"Nombre","Correo","Celular","Direccion"});
        DefaultTableModel contactos = listar();
        for (int i = 0; i < contactos.getRowCount(); i++) {
            int idc = (int)contactos.getValueAt(i, 0);
            ClienteNegocio p = new ClienteNegocio();
            p.getPersona().setId(idc);
            if (p.buscar()) {
                listaNueva.addRow(new Object[]{p.getPersona().getNombrecompleto(),p.getPersona().getEmail(),p.getPersona().getCelular(),p.getCliente().getDireccion()});
            }
        }
        return listaNueva;
    }
}
