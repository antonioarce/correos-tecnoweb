/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.procesador;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author mauriballes
 */
public class LCC {

    private static final LinkedList<String> comandos = new LinkedList<>(Arrays.asList(
            "HELP",
            "TRUE",
            "FALSE",
            
            "INSERTARCLIENTE",
            "MODIFICARCLIENTE",
            "ELIMINARCLIENTE",
            "LISTARCLIENTE",
            
            "INSERTARCOMENTARIO",
            "MODIFICARCOMENTARIO",
            "ELIMINARCOMENTARIO",
            "LISTARCOMENTARIO",
            
            "INSERTARCONTACTO",
            "MODIFICARCONTACTO",
            "ELIMINARCONTACTO",
            "LISTARCONTACTO",
            
            "INSERTARDATOSPRINCIPALES",
            "MODIFICARDATOSPRINCIPALES",
            "ELIMINARDATOSPRINCIPALES",
            "LISTARDATOSPRINCIPALES",
            
            "INSERTARMULTIMEDIA",
            "MODIFICARMULTIMEDIA",
            "ELIMINARMULTIMEDIA",
            "LISTARMULTIMEDIA",
            
            "INSERTARPERSONA",
            "MODIFICARPERSONA",
            "ELIMINARPERSONA",
            "LISTARPERSONA",
            
            "INSERTARSUGERENCIA",
            "MODIFICARSUGERENCIA",
            "ELIMINARSUGERENCIA",
            "LISTARSUGERENCIA",
            
            "INSERTARUSUARIO",
            "MODIFICARUSUARIO",
            "ELIMINARUSUARIO",
            "LISTARUSUARIO"
    ));

    private static final LinkedList<Token> tokens = new LinkedList<>(Arrays.asList(
            new Token(Token.HELP, -1, "HELP"),
            new Token(Token.TRUE, -1, "TRUE"),
            new Token(Token.FALSE, -1, "FALSE"),
            
            new Token(Token.FUNC, Token.INSERTARCLIENTE, "INSERTARCLIENTE"),
            new Token(Token.FUNC, Token.MODIFICARCLIENTE, "MODIFICARCLIENTE"),
            new Token(Token.FUNC, Token.ELIMINARCLIENTE, "ELIMINARCLIENTE"),
            new Token(Token.FUNC, Token.LISTARCLIENTE, "LISTARCLIENTE"),
            
            new Token(Token.FUNC, Token.INSERTARCOMENTARIO, "INSERTARCOMENTARIO"),
            new Token(Token.FUNC, Token.MODIFICARCOMENTARIO, "MODIFICARCOMENTARIO"),
            new Token(Token.FUNC, Token.ELIMINARCOMENTARIO, "ELIMINARCOMENTARIO"),
            new Token(Token.FUNC, Token.LISTARCOMENTARIO, "LISTARCOMENTARIO"),
            
            new Token(Token.FUNC, Token.INSERTARCONTACTO, "INSERTARCONTACTO"),
            new Token(Token.FUNC, Token.MODIFICARCONTACTO, "MODIFICARCONTACTO"),
            new Token(Token.FUNC, Token.ELIMINARCONTACTO, "ELIMINARCONTACTO"),
            new Token(Token.FUNC, Token.LISTARCONTACTO, "LISTARCONTACTO"),
            
            new Token(Token.FUNC, Token.INSERTARDATOSPRINCIPALES, "INSERTARDATOSPRINCIPALES"),
            new Token(Token.FUNC, Token.MODIFICARDATOSPRINCIPALES, "MODIFICARDATOSPRINCIPALES"),
            new Token(Token.FUNC, Token.ELIMINARDATOSPRINCIPALES, "ELIMINARDATOSPRINCIPALES"),
            new Token(Token.FUNC, Token.LISTARDATOSPRINCIPALES, "LISTARDATOSPRINCIPALES"),
            
            new Token(Token.FUNC, Token.INSERTARMULTIMEDIA, "INSERTARMULTIMEDIA"),
            new Token(Token.FUNC, Token.MODIFICARMULTIMEDIA, "MODIFICARMULTIMEDIA"),
            new Token(Token.FUNC, Token.ELIMINARMULTIMEDIA, "ELIMINARMULTIMEDIA"),
            new Token(Token.FUNC, Token.LISTARMULTIMEDIA, "LISTARMULTIMEDIA"),
            
            new Token(Token.FUNC, Token.INSERTARPERSONA, "INSERTARPERSONA"),
            new Token(Token.FUNC, Token.MODIFICARPERSONA, "MODIFICARPERSONA"),
            new Token(Token.FUNC, Token.ELIMINARPERSONA, "ELIMINARPERSONA"),
            new Token(Token.FUNC, Token.LISTARPERSONA, "LISTARPERSONA"),
            
            new Token(Token.FUNC, Token.INSERTARSUGERENCIA, "INSERTARSUGERENCIA"),
            new Token(Token.FUNC, Token.MODIFICARSUGERENCIA, "MODIFICARSUGERENCIA"),
            new Token(Token.FUNC, Token.ELIMINARSUGERENCIA, "ELIMINARSUGERENCIA"),
            new Token(Token.FUNC, Token.LISTARSUGERENCIA, "LISTARSUGERENCIA"),
            
            new Token(Token.FUNC, Token.INSERTARUSUARIO, "INSERTARUSUARIO"),
            new Token(Token.FUNC, Token.MODIFICARUSUARIO, "MODIFICARUSUARIO"),
            new Token(Token.FUNC, Token.ELIMINARUSUARIO, "ELIMINARUSUARIO"),
            new Token(Token.FUNC, Token.LISTARUSUARIO, "LISTARUSUARIO")
    ));
//cambiar estaEnTCP por estaEnLCC
    public static Token estaEnLCC(String lexema) {
        lexema = lexema.toUpperCase();
        for (int i = 0; i < comandos.size(); i++) {
            if (comandos.get(i).toUpperCase().equals(lexema)) {
                Token token = new Token();
                token.setNombre(tokens.get(i).getNombre());
                token.setAtributo(tokens.get(i).getAtributo());
                token.setToStr(tokens.get(i).getToStr());
                return token;
            }
        }
        return null;
    }
}
