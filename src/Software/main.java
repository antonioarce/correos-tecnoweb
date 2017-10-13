/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;

/**
 *
 * @author Saulo
 */
public class main {
    public static void main(String[] args) {
        software sof=new software();
        //sof.processMessage("SUBJECT:[FUNC][INSERTARMULTIMEDIA]['hola','www.facebooc.com',1,1]");
        sof.processMessage("INSERTARMULTIMEDIA[hola][www.facebooc.com'][1][1]");
    }
}
