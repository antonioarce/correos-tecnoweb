/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;
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
        //software sof=new software();
        //sof.processMessage("SUBJECT:[FUNC][INSERTARMULTIMEDIA]['hola','www.facebooc.com',1,1]");
        //sof.processMessage("subject:INSERTARMULTIMEDIA[\"hola\",\"www.facebooc.com\",2,1]");
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
        ContactoNegocio mn = new ContactoNegocio();
        mn.getContacto().setIdusuario(3);
        DefaultTableModel lista = mn.listar();
        System.out.println(core.utilidades.Herramientas.dibujarTabla(lista));
    }
}
