/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;

import core.procesador.Anacom;
import core.procesador.Checker;
import core.procesador.Cinta;
import core.procesador.Token;
import core.protocolos.ClienteSMTP;
import core.utilidades.Ayuda;
import core.utilidades.Herramientas;
import java.sql.Date;
import negocio.MultimediaNegocio;

/**
 *
 * @author Saulo
 */
public class software {
    public void processMessage(String Message) {
        // Setteando Variables
        String destinatario = Herramientas.getDestinatario(Message);
        String content = Herramientas.getSubjectOrden(Message);
        Cinta cinta = new Cinta(content);
        Anacom anacom = new Anacom(cinta);
        Checker checker = new Checker(anacom);

        // Verificar Orden
        checker.Expresion();
        if (checker.errorFlag) {
            // Enviar Correo de Error
            //ClienteSMTP.sendMail(destinatario, "Error de Comando",
            //        "El comando introducido es incorrecto, trate consultando las ayudas con el comando HELP"
            //);
            System.out.println(Ayuda.HELP_INSERTARMULTIMEDIA);
            return;
        }

        // Si todo va bien, procesar el Comando
        anacom.Init();
        Token token = anacom.Preanalisis();

        if (token.getNombre() == Token.HELP) {
            // Mostrar Ayudas
            //ClienteSMTP.sendMail(destinatario, "Ayudas - Nueva Acropolis Mail", Ayuda.HELP_GLOBAL);
            System.out.println(Ayuda.HELP_INSERTARMULTIMEDIA+" DD");
            return;
        }

        // Sino es HELP, es una funcionalidad
        switch (token.getAtributo()) {
            case Token.INSERTARMULTIMEDIA:
                registrarMultimedia(anacom, destinatario);
                break;
            case Token.MODIFICARMULTIMEDIA:
                modificarMultimedia(anacom, destinatario);
                break;
            case Token.LISTARMULTIMEDIA:
                listarMultimedia(anacom, destinatario);
                break;
            case Token.ELIMINARMULTIMEDIA:
                eliminarMultimedia(anacom, destinatario);
                break;
        }
    }

    private void registrarMultimedia(Anacom anacon, String correoDest) {
        // Obtengo el Siguiente token
        anacon.Avanzar();
        Token token = anacon.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Publicidad Personal", Ayuda.HELP_INSERTARMULTIMEDIA);
            return;
        }

        // Sino, ejecutar el comando
        anacon.Avanzar();
        // Atributos
        String titulo = Herramientas.quitarComillas(anacon.Preanalisis().getToStr());
        anacon.Avanzar();
        anacon.Avanzar();
        String url = Herramientas.quitarComillas(anacon.Preanalisis().getToStr());
        anacon.Avanzar();
        anacon.Avanzar();
        int tipo = anacon.Preanalisis().getAtributo();
        anacon.Avanzar();
        anacon.Avanzar();
        int idcliente = anacon.Preanalisis().getAtributo();
        MultimediaNegocio multimediaNegocio = new MultimediaNegocio(titulo, url, tipo, idcliente);
        multimediaNegocio.guardar();
        ClienteSMTP.sendMail(correoDest, "Registrar Alumno", "Registro realizado Correctamente");
    }

    private void modificarMultimedia(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarMultimedia(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarMultimedia(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   /* public void obtenerAlumnos(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Nueva Acropolis Mail", Helper.HELP_OBTENERALUMNOS);
            return;
        }

        // Sino, ejecutar el comando
        AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        String message = Utils.dibujarTabla(alumnoNegocio.obtenerAlumnos());
        ClienteSMTP.sendMail(correoDest, "Obtener Alumnos", message);
    }*/

    /*public void registrarAlumno(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Nueva Acropolis Mail", Helper.HELP_REGISTRARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        analex.Avanzar();
        // Atributos
        String nombres = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        String apellidos = Utils.quitarComillas(analex.Preanalisis().getToStr());
        analex.Avanzar();
        analex.Avanzar();
        int telefono = analex.Preanalisis().getAtributo();
        analex.Avanzar();
        analex.Avanzar();
        Date fecha_nacimiento = Utils.convertirFechas(Utils.quitarComillas(analex.Preanalisis().getToStr()));
        analex.Avanzar();
        analex.Avanzar();
        Date fecha_ingreso = Utils.convertirFechas(Utils.quitarComillas(analex.Preanalisis().getToStr()));
        analex.Avanzar();
        analex.Avanzar();
        boolean estado = analex.Preanalisis().getNombre() == Token.TRUE;
        alumnoNegocio.registrarAlumno(nombres, apellidos, telefono, fecha_nacimiento, fecha_ingreso, estado);
        ClienteSMTP.sendMail(correoDest, "Registrar Alumno", "Registro realizado Correctamente");

    }*/

    /*public void modificarAlumno(Analex analex, String correoDest) {
        // Obtengo el Siguiente token
        analex.Avanzar();
        Token token = analex.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Nueva Acropolis Mail", Helper.HELP_MODIFICARALUMNO);
            return;
        }

        // Sino, ejecutar el comando
        AlumnoNegocio alumnoNegocio = new AlumnoNegocio();
        analex.Avanzar();
        int id = analex.Preanalisis().getAtributo();
        DefaultTableModel alumno = alumnoNegocio.obtenerAlumno(id);

        // Revisar los GuionBajo
        analex.Avanzar();
        analex.Avanzar();
        String nombres = (analex.Preanalisis().getNombre() != Token.GB)
                ? Utils.quitarComillas(analex.Preanalisis().getToStr())
                : String.valueOf(alumno.getValueAt(0, 1));
        analex.Avanzar();
        analex.Avanzar();
        String apellidos = (analex.Preanalisis().getNombre() != Token.GB)
                ? Utils.quitarComillas(analex.Preanalisis().getToStr())
                : String.valueOf(alumno.getValueAt(0, 2));
        analex.Avanzar();
        analex.Avanzar();
        int telefono = (analex.Preanalisis().getNombre() != Token.GB)
                ? analex.Preanalisis().getAtributo()
                : Integer.parseInt(String.valueOf(alumno.getValueAt(0, 3)));
        analex.Avanzar();
        analex.Avanzar();
        Date fecha_nacimiento = (analex.Preanalisis().getNombre() != Token.GB)
                ? Utils.convertirFechas(Utils.quitarComillas(analex.Preanalisis().getToStr()))
                : ((Date) alumno.getValueAt(0, 4));
        analex.Avanzar();
        analex.Avanzar();
        Date fecha_ingreso = (analex.Preanalisis().getNombre() != Token.GB)
                ? Utils.convertirFechas(Utils.quitarComillas(analex.Preanalisis().getToStr()))
                : ((Date) alumno.getValueAt(0, 5));
        analex.Avanzar();
        analex.Avanzar();
        boolean estado = (analex.Preanalisis().getNombre() != Token.GB)
                ? (analex.Preanalisis().getNombre() == Token.TRUE)
                : Boolean.valueOf(String.valueOf(alumno.getValueAt(0, 6)));
        alumnoNegocio.modificarAlumno(id, nombres, apellidos, telefono, fecha_nacimiento, fecha_ingreso, estado);
        ClienteSMTP.sendMail(correoDest, "Modificar Alumno", "Modificacion realizada Correctamente");
    }*/
    
}