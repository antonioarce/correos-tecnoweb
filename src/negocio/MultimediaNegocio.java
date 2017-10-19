/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Multimedia;
import datos.Plantilla;
import java.sql.Date;
import java.sql.Time;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio Arce
 */
public class MultimediaNegocio {
    private Multimedia multimedia;

    public MultimediaNegocio() {
        multimedia = new Multimedia();
    }

    public MultimediaNegocio(String titulo, String url, int tipo, int idcliente) {
        long tiempo = System.currentTimeMillis();
        this.multimedia = new Multimedia(0, titulo, 0, 0, 0, url, tipo, new Date(tiempo),new Time(tiempo), idcliente);
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }
    
    public boolean buscar(){
        return multimedia.buscar();
    }
    
    public boolean guardar(){
        return multimedia.guardar();
    }
    
    public boolean modificar(){
        return multimedia.modificar();
    }
    
    public boolean eliminar(){
        return multimedia.borrar();
    }
    
    public DefaultTableModel listarPorCliente(){
        return multimedia.listarTodos();
    }
    
    public DefaultTableModel listarTodos(){
        Plantilla p = new Plantilla() {
            @Override
            protected String insertar() {
                return null;
            }
            @Override
            protected String actualizar() {
                return null;
            }
            @Override
            protected String eliminar() {
                return null;
            }
            @Override
            protected String listar() {
                return  "select * from multimedia";
            }
            @Override
            protected int cantidadAtributos() {
                return 10;
            }
            @Override
            protected Object[] columnas() {
                return new Object[]{"Id","Titulo","Contador","Comentarios","Sugerencias","Url","Tipo","Fecha","Hora","Idcliente"};
            }
        };
        return p.listarTodos();
    }
}
