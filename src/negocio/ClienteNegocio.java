/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Cliente;
import datos.Persona;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio Arce
 */
public class ClienteNegocio {
    private Persona persona;
    private Cliente cliente;

    public ClienteNegocio(String nombre, String email, String password, int celular, int tipo, int genero,String direccion,String web) {
        this.persona = new Persona(0, nombre, email, password, celular, tipo, genero);
        this.cliente = new Cliente(0, direccion, web, 0, 0);
    }

    public ClienteNegocio() {
        this.persona = new Persona();
        this.cliente = new Cliente();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public boolean insertar(){
        if (persona.guardar()) {
            persona.setAutoincrement();
            cliente.setId(persona.getId());
            if (cliente.guardar()) {
                return true;
            }else{
                persona.eliminar();
            }
        }
        return false;
    }
    
    public boolean buscarPorCorreo(){
        if (persona.buscarPorCorreo()) {
            cliente.setId(persona.getId());
            if (cliente.buscar()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizar(){
        return persona.modificar()&& cliente.modificar();
    }
    
    public boolean eliminar(){
        return cliente.borrar() && persona.borrar();
    }
    
    public DefaultTableModel listar(){
        return persona.listarTodos();
    }
}
