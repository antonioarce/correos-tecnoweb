/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.procesador;

/**
 *
 * @author mauriballes
 */
public class Token {

    // Constantes
    public static final int NUM = 0; // Numero Valor
    public static final int STRING = 1; // String Constante
    public static final int FUNC = 2; // Alguna Funcion
    public static final int GB = 3; //Guion Bajo
    public static final int CA = 4; // Corchete Abierto
    public static final int CC = 5; // Corchete Cerrado
    public static final int COMA = 6; // Coma ,
    public static final int FIN = 7;
    public static final int ERROR = 8;
    public static final int TRUE = 9;
    public static final int FALSE = 10;
    public static final int HELP = 11;
    public static final int HELPGLOBAL = 12;

    // Funciones
    public static final int INSERTARCLIENTE = 100;
    public static final int MODIFICARCLIENTE = 101;
    public static final int ELIMINARCLIENTE = 102;
    public static final int LISTARCLIENTE = 103;
    
    public static final int INSERTARCOMENTARIO = 104;
    public static final int MODIFICARCOMENTARIO = 105;
    public static final int ELIMINARCOMENTARIO = 106;
    public static final int LISTARCOMENTARIO = 107;
    
    public static final int INSERTARCONTACTO = 108;
    public static final int MODIFICARCONTACTO = 109;
    public static final int ELIMINARCONTACTO = 110;
    public static final int LISTARCONTACTO = 111;
    
    public static final int INSERTARDATOSPRINCIPALES = 112;
    public static final int MODIFICARDATOSPRINCIPALES = 113;
    public static final int ELIMINARDATOSPRINCIPALES = 114;
    public static final int LISTARDATOSPRINCIPALES = 115;
    
    public static final int INSERTARMULTIMEDIA = 116;
    public static final int MODIFICARMULTIMEDIA = 117;
    public static final int ELIMINARMULTIMEDIA = 118;
    public static final int LISTARMULTIMEDIA = 119;
    public static final int VERMULTIMEDIA = 133;
    
    public static final int INSERTARPERSONA = 120;
    public static final int MODIFICARPERSONA = 121;
    public static final int ELIMINARPERSONA = 122;
    public static final int LISTARPERSONA = 123;
    
    public static final int INSERTARSUGERENCIA = 124;
    public static final int MODIFICARSUGERENCIA = 125;
    public static final int ELIMINARSUGERENCIA = 126;
    public static final int LISTARSUGERENCIA = 127;
    
    public static final int INSERTARUSUARIO = 128;
    public static final int MODIFICARUSUARIO = 129;
    public static final int ELIMINARUSUARIO = 130;
    public static final int LISTARUSUARIO = 131;
    
    public static final int MOSTRARESTADISTICA = 132;
    

    private int nombre;
    private int atributo;
    private String toStr;

    public Token() {
    }

    public Token(int nombre, int atributo, String toStr) {
        this.nombre = nombre;
        this.atributo = atributo;
        this.toStr = toStr;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int atributo) {
        this.atributo = atributo;
    }

    public String getToStr() {
        return toStr;
    }

    public void setToStr(String toStr) {
        this.toStr = toStr;
    }

}
