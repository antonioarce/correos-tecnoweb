/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;
import core.utilidades.Ayuda;
import core.utilidades.Herramientas;
import datos.Cliente;
import datos.Estadistica;
import datos.Persona;
import javax.swing.table.DefaultTableModel;
import negocio.ClienteNegocio;
import negocio.ComentarioNegocio;
import negocio.ContactoNegocio;
import negocio.DatosprincipalesNegocio;
import negocio.MultimediaNegocio;
import negocio.SugerenciaNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author Saulo
 */
public class main {
    public static void main(String[] args) {
//        Persona persona=new Persona(0, "", "pablo.jpl93@gmail.com", "", 0, 0, 0);
//        if(persona.buscarPorCorreo()){
//            System.out.println("todo ok");
//        }
        //System.out.println(Ayuda.HELP_GLOBAL);
    //software sof=new software();
        //System.out.println(Ayuda.HELP_GLOBAL);
    //prueba cliente
    /*sof.processMessage("SUBJECT:INSERTARCLIENTE"
            + "[\"Pablo Garcia Lima\",\"pablo.jpl93@gmail.com\","
            + "\"123456\",2,1,2,\"Las Lomas\",\"www.youtube.com\"]");
    sof.processMessage("SUBJECT:MODIFICARCLIENTE"
            + "[\"Pablo Garcia Lima\",\"pablo.jpl93@gmail.com\","
            + "\"123456\",76313080,1,2,\"Las Lomas\",\"www.youtube.com\"");//1tipo 2genero
    *///sof.processMessage("SUBJECT:ELIMINARCLIENTE");
    
    //prueba comentario
    //sof.processMessage("SUBJECT:INSERTARCOMENTARIO[\"No entiendo bien su labor inbox al 76313082\",1,1]");//1idperso,1idmultimedia
    /*sof.processMessage("SUBJECT:MODIFICARCOMENTARIO[1,\"No entiendo bien su labor inbox al 76313082\",1]");//1mult 2idper
    sof.processMessage("SUBJECT:ELIMINARCOMENTARIO[1]");*/
    //sof.processMessage("SUBJECT:LISTARCOMENTARIO[1]");
    
    //prueba contacto
    //sof.processMessage("SUBJECT:INSERTARCONTACTO[\"pablo.jpl93@gmail.com\"]");
    //sof.processMessage("SUBJECT:ELIMINARCONTACTO[1]");
    //sof.processMessage("SUBJECT:LISTARCONTACTO");
    
    //insertar datos principales
    //sof.processMessage("SUBJECT:INSERTARDATOSPRINCIPALES[\"Programador\",\"2años en IBM\",1]");
    //sof.processMessage("SUBJECT:MODIFICARDATOSPRINCIPALES[1,\"Programador\",\"1año en google\",1]");//1tipo 2genero
    //sof.processMessage("SUBJECT:ELIMINARDATOSPRINCIPALES[1]");
    //sof.processMessage("SUBJECT:LISTARDATOSPRINCIPALES");
    
    //multimedia
    //sof.processMessage("SUBJECT:INSERTARMULTIMEDIA[\"Instalaciones Electricas\",\"www.facebook.com/presentacion.mp4\",\"Video\",1]");
    //sof.processMessage("SUBJECT:MODIFICARMULTIMEDIA[4,\"Programador Master\",\"www.facebook.com/josuepuma\",\"Video\",1]");
    //sof.processMessage("SUBJECT:ELIMINARMULTIMEDIA[2]");
    //sof.processMessage("SUBJECT:LISTARMULTIMEDIA");
    
    //sugerencia
    //sof.processMessage("SUBJECT:INSERTARSUGERENCIA[\"pablo_jpl93@hotmail.com\",\"Lo que buscabas\",1]");
    
    //prueba usuario
    //sof.processMessage("SUBJECT:INSERTARUSUARIO[\"Josue Garcia Lima\",\"pablo_jpl93@hotmail.com\",\"123456\",70828866,1,2,\"Tu Primero\"]");
    /*sof.processMessage("SUBJECT:MODIFICARUSUARIO"
            + "[6,\"Josue Puma Lima\","
            + "\"123456\",76313081,2,\"Tu Socio\"]");//1tipo 2genero
    sof.processMessage("SUBJECT:ELIMINARUSUARIO");
    
    
    
    
    sof.processMessage("SUBJECT:INSERTARMULTIMEDIA[\"hola\",\"www.facebook.com\",1,1]");
    sof.processMessage("SUBJECT:ELIMINARCLIENTE[HELP]");
    sof.processMessage("subject:MODIFICARCLIENTE[1,\"Pablo Garcia Lima\",\"pablo.jpl93@gmail.com\",\"123456\",2,1,2,\"Las Lomas\",\"www.youtube.com\"]");        
    */    





//sof.processMessage("SUBJECT:HELPGLOBAL[]");
        //sof.processMessage("SUBJECT:INSERTARMULTIMEDIA[\"hola\",,1,1]");
        
        //ClienteNegocio cliente= new ClienteNegocio();
//        ClienteNegocio cliente = new ClienteNegocio("Juan Perez", "jlst.arce@gmail.com", "123456", 778474774, 1, 1, "", "");
//        if (cliente.insertar()) {
//            System.out.println("ok - " + cliente.getPersona().getId());
//        }
//        UsuarioNegocio user = new UsuarioNegocio("Luis Suarez", "luis@gmail.com", "123456", 78787878, 2, 1, "Terracor");
//        if (user.guardar()) {
//            System.out.println("ok - " + user.getPersona().getId());
//        }


//        MultimediaNegocio m = new MultimediaNegocio("Hola, este es mi primer video", "www.hamfdeerer.com", 1, 1);
//        m.guardar();
//        DatosprincipalesNegocio dt = new DatosprincipalesNegocio("Habilidad", "Bailarin profesional", 1);
//        dt.guardar();
//        dt = new DatosprincipalesNegocio("Experiencia", "3 años", 1);
//        dt.guardar();
//        ContactoNegocio cn = new ContactoNegocio(1, 2);
//        cn.guardar();
//        cn = new ContactoNegocio(1, 3);
//        cn.guardar();
//        SugerenciaNegocio sn = new SugerenciaNegocio(2, 3, "Mira este como baila", 1);
//        sn.guardar();
//        ComentarioNegocio cn = new ComentarioNegocio();
//        cn.getComentario().setId(1);
//        cn.buscar();
        /*ContactoNegocio mn = new ContactoNegocio();
        mn.getContacto().setIdusuario(3);
        DefaultTableModel lista = mn.listarContactos();
        System.out.println(core.utilidades.Herramientas.dibujarTabla(lista));*/
        Estadistica e = new Estadistica(1);
        System.out.println(e.toString());
    }
}
