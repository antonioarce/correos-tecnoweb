/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;
import negocio.ClienteNegocio;

/**
 *
 * @author Saulo
 */
public class main {
    public static void main(String[] args) {
        software sof=new software();
        //sof.processMessage("SUBJECT:[FUNC][INSERTARMULTIMEDIA]['hola','www.facebooc.com',1,1]");
        sof.processMessage("subject:INSERTARMULTIMEDIA[\"hola\",\"www.facebooc.com\",2,1]");
        
        /*ClienteNegocio cliente = new ClienteNegocio("CLiente1", "jlst.arce@gmail.com", "1234456", 77813724, 1, 1, "Av heroes del chaco", "");
        cliente.getCliente().setId(2);
        cliente.insertar();*/
    }
}
