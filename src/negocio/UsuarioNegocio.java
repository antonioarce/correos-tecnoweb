/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Persona;
import datos.Usuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio Arce
 */
public class UsuarioNegocio {
    
    private Persona persona;
    private Usuario usuario;

    public UsuarioNegocio() {
        persona = new Persona();
        usuario = new Usuario();
    }

    public UsuarioNegocio(String nombre, String email,String password, int celular,int tipo,int genero,String empresa) {
        this.persona = new Persona(0, nombre, email, password, "alsiduhfsdf5g489er7g9re87", "asd95g+9sadg+9weg9+weq4hb+whyj65", "", celular, tipo, genero);
        this.usuario = new Usuario(empresa, 0);
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public boolean guardar(){
        if (persona.guardar()) {
            usuario.setId(persona.getId());
            if (usuario.guardar()) {
                return true;
            }else{
                persona.eliminar();
            }
        }
        return false;
    }
    
    public boolean modificar(){
        return persona.modificar() && usuario.modificar();
    }
    
    public boolean eliminar(){
        return usuario.borrar()&& persona.borrar();
    }
    
    public DefaultTableModel listar(){
        return persona.listarTodos();
    }
}
