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
import datos.Comentario;
import datos.Datosprincipales;
import datos.Multimedia;
import datos.Persona;
import datos.Usuario;
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
            ClienteSMTP.sendMail(destinatario, "Error de Comando",
                    "El comando introducido es incorrecto, trate consultando las ayudas con el comando HELP"
            );
            //System.out.println(Ayuda.HELP_INSERTARMULTIMEDIA);
            return;
        }

        // Si todo va bien, procesar el Comando
        anacom.Init();
        Token token = anacom.Preanalisis();

        if (token.getNombre() == Token.HELP) {
            // Mostrar Ayudas
            ClienteSMTP.sendMail(destinatario, "Ayudas - Nueva Acropolis Mail", Ayuda.HELP_GLOBAL);
            //System.out.println(Ayuda.HELP_GLOBAL+" DD");
            return;
        }

        // Sino es HELP, es una funcionalidad
        switch (token.getAtributo()) {
            case Token.INSERTARCLIENTE:
                registrarCliente(anacom,destinatario);
                break;
            case Token.MODIFICARCLIENTE:
                modificarCliente(anacom,destinatario);
                break;
            case Token.ELIMINARCLIENTE:
                eliminarCliente(anacom,destinatario);
                break;
            case Token.LISTARCLIENTE:
                listarCliente(anacom,destinatario);
                break;
           
            case Token.INSERTARCOMENTARIO:
                registrarComentario(anacom,destinatario);
                break;
            case Token.MODIFICARCOMENTARIO:
                modificarComentario(anacom,destinatario);
                break;
            case Token.ELIMINARCOMENTARIO:
                eliminarComentario(anacom,destinatario);
                break;
            case Token.LISTARCOMENTARIO:
                listarComentario(anacom,destinatario);
                break;
            
            case Token.INSERTARCONTACTO:
                registrarContacto(anacom,destinatario);
                break;
            case Token.ELIMINARCONTACTO:
                eliminarContacto(anacom,destinatario);
                break;
            case Token.LISTARCONTACTO:
                listarContacto(anacom,destinatario);
                break;
                
            case Token.INSERTARDATOSPRINCIPALES:
                registrarDatosPrincipales(anacom,destinatario);
                break;
            case Token.MODIFICARDATOSPRINCIPALES:
                modificarDatosPrincipales(anacom,destinatario);
                break;
            case Token.ELIMINARDATOSPRINCIPALES:
                eliminarDatosPrincipales(anacom,destinatario);
                break;
            case Token.LISTARDATOSPRINCIPALES:
                listarDatosPrincipales(anacom,destinatario);
                break;
                
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
                
            case Token.INSERTARSUGERENCIA:
                registrarSugerencia(anacom,destinatario);
                break;
                
            case Token.INSERTARUSUARIO:
                registrarUsuario(anacom,destinatario);
                break;
            case Token.MODIFICARUSUARIO:
                modificarUsuario(anacom,destinatario);
                break;
            case Token.ELIMINARUSUARIO:
                eliminarUsuario(anacom,destinatario);
                break;
            case Token.LISTARUSUARIO:
                listarUsuario(anacom,destinatario);
                break;
        }

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

    private void registrarCliente(Anacom anacom, String correoDest) {
        // Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();
        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Publicidad Personal", Ayuda.HELP_INSERTARMULTIMEDIA);
            return;
        }
        // Sino, ejecutar el comando
        anacom.Avanzar();
        // Atributos
        String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String email = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String password = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        int celular = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        int tipo = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        int genero = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        String direccion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String web = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        ClienteNegocio clienteNegocio = new ClienteNegocio(nombre, email, password, celular, tipo, genero, direccion, web);
        clienteNegocio.insertar();
        //Cliente cliente=;
        ClienteSMTP.sendMail(correoDest, "Registrar Cliente", "Registro realizado Correctamente su codigo es "+clienteNegocio.getCliente().getId());
    }

    private void modificarCliente(Anacom anacom, String correoDest) {
         //Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Publicidad Personal", Ayuda.HELP_MODIFICARCLIENTE);
            return;
        }

        // Sino, ejecutar el comando
        ClienteNegocio clienteNegocio = new ClienteNegocio(correoDest, correoDest, correoDest, 0, 0, 0, correoDest, correoDest);
        int id = anacom.Preanalisis().getAtributo();
        
        if (!clienteNegocio.buscarPorCorreo()){
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", "Usted no se encuentra registrado para realizar modificaciones");
            return;
        }
        // Revisar los GuionBajo
        anacom.Avanzar();
        anacom.Avanzar();
        String nombres = (anacom.Preanalisis().getNombre() != Token.GB)
                ? Herramientas.quitarComillas(anacom.Preanalisis().getToStr())
                : clienteNegocio.getPersona().getNombrecompleto();
        anacom.Avanzar();
        anacom.Avanzar();
        String email = (anacom.Preanalisis().getNombre() != Token.GB)
                ? Herramientas.quitarComillas(anacom.Preanalisis().getToStr())
                : clienteNegocio.getPersona().getEmail();
        anacom.Avanzar();
        anacom.Avanzar();
        String passwords = (anacom.Preanalisis().getNombre() != Token.GB)
                ? Herramientas.quitarComillas(anacom.Preanalisis().getToStr())
                : clienteNegocio.getPersona().getPassword();
        anacom.Avanzar();
        anacom.Avanzar();
        int celular = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : clienteNegocio.getPersona().getCelular();
        anacom.Avanzar();
        anacom.Avanzar();
        int tipo = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : clienteNegocio.getPersona().getTipo();
        anacom.Avanzar();
        anacom.Avanzar();        
        int genero = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : clienteNegocio.getPersona().getGenero();
        anacom.Avanzar();
        anacom.Avanzar();
        String direccion = (anacom.Preanalisis().getNombre() != Token.GB)
                ? Herramientas.quitarComillas(anacom.Preanalisis().getToStr())
                : clienteNegocio.getCliente().getDireccion();
        anacom.Avanzar();
        anacom.Avanzar();
        String web = (anacom.Preanalisis().getNombre() != Token.GB)
                ? Herramientas.quitarComillas(anacom.Preanalisis().getToStr())
                : clienteNegocio.getCliente().getWeb();
        clienteNegocio=new ClienteNegocio(nombres, email, passwords, celular, tipo, genero, direccion, web);
        clienteNegocio.getPersona().setId(id);
        clienteNegocio.getCliente().setId(id);
        clienteNegocio.actualizar();
        ClienteSMTP.sendMail(correoDest, "Modificar Cliente", "Modificacion realizada Correctamente");
    }

    private void eliminarCliente(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarCliente(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void registrarComentario(Anacom anacom, String correoDest) {
        // Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();
        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Publicidad Personal", Ayuda.HELP_INSERTARCOMENTARIO);
            return;
        }
        // Sino, ejecutar el comando
        anacom.Avanzar();
        // Atributos
        String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        int idpersona = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        int idmultimedia = anacom.Preanalisis().getAtributo();
        ComentarioNegocio comentarioNegocio = new ComentarioNegocio(descripcion, idpersona, idmultimedia);
        comentarioNegocio.guardar();
        ClienteSMTP.sendMail(correoDest, "Registrar Comentario", "Registro realizado Correctamente el codigo de su comentario es "+comentarioNegocio.getComentario().getId());
    }

    private void modificarComentario(Anacom anacom, String correoDest) {
       //Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", Ayuda.HELP_MODIFICARCOMENTARIO);
            return;
        }

        // Sino, ejecutar el comando
        // Revisar los GuionBajo
        //anacom.Avanzar();
        //anacom.Avanzar();
        int id = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : -1;
        anacom.Avanzar();
        anacom.Avanzar(); 
        String descripcion = (anacom.Preanalisis().getNombre() != Token.GB)
                ? Herramientas.quitarComillas(anacom.Preanalisis().getToStr())
                : "";
        anacom.Avanzar();
        anacom.Avanzar();      
        int idpersona = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : -1;
        Comentario comentario=new Comentario();
        comentario.setId(id);
        if (!comentario.buscar() && comentario.getId()!=idpersona){
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", "Codigo de multimedia invalido consulte su lista de comentario para ver el codigo");
            return;
        }
        Comentario comentarioIn=new Comentario();
        comentarioIn.setId(comentario.getId());
        comentarioIn.setIdmultimedia(comentario.getIdmultimedia());
        comentarioIn.setIdpersona(idpersona);
        if (!descripcion.isEmpty()) {
            comentarioIn.setDescripcion(descripcion);
        }else{
            comentarioIn.setDescripcion(comentario.getDescripcion());
        }
        ComentarioNegocio comentarioNegocio=new ComentarioNegocio();
        comentarioNegocio.setComentario(comentarioIn);
        comentarioNegocio.modificar();
        ClienteSMTP.sendMail(correoDest, "Modificar Comentario", "Modificacion realizada Correctamente");
    }

    private void eliminarComentario(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarComentario(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void registrarContacto(Anacom anacom, String correoDest) {
        // Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();
        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Publicidad Personal", Ayuda.HELP_INSERTARCOMENTARIO);
            return;
        }
        // Sino, ejecutar el comando
        anacom.Avanzar();
        // Atributos
        int idcliente = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        int idusuario = anacom.Preanalisis().getAtributo();
        ContactoNegocio contactoNegocio = new ContactoNegocio(idcliente, idusuario);
        contactoNegocio.guardar();
        ClienteSMTP.sendMail(correoDest, "Registrar Contacto", "Registro realizado Correctamente");
    }
    
    private void eliminarContacto(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void listarContacto(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    
    private void registrarDatosPrincipales(Anacom anacom, String correoDest) {
        // Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();
        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Publicidad Personal", Ayuda.HELP_INSERTARCOMENTARIO);
            return;
        }
        // Sino, ejecutar el comando
        anacom.Avanzar();
        // Atributos
        String titulo = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        int idcliente = anacom.Preanalisis().getAtributo();
        DatosprincipalesNegocio datosprincipalesNegocio = new DatosprincipalesNegocio(titulo, descripcion, idcliente);
        datosprincipalesNegocio.guardar();
        ClienteSMTP.sendMail(correoDest, "Registrar Dato Principal", "Registro realizado Correctamente el codigo de su dato principal es "+datosprincipalesNegocio.getDatos().getId());
    }

    private void modificarDatosPrincipales(Anacom anacom, String correoDest) {
        //Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", Ayuda.HELP_MODIFICARDATOSPRINCIPALES);
            return;
        }

        // Sino, ejecutar el comando
        // Revisar los GuionBajo
        //anacom.Avanzar();
        //anacom.Avanzar();
        int id = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : -1;
        anacom.Avanzar();
        anacom.Avanzar();
        
        Datosprincipales datoprincipal=new Datosprincipales();
        datoprincipal.setId(id);
        if (!datoprincipal.buscar()){
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", "Codigo de Dato Principal invalido consulte su lista de Datos Principales para ver el codigo");
            return;
        }
        
        if(anacom.Preanalisis().getNombre() != Token.GB)
           datoprincipal.setTitulo(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
        anacom.Avanzar();
        anacom.Avanzar();      
        if(anacom.Preanalisis().getNombre() != Token.GB)
           datoprincipal.setDescripcion(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
        anacom.Avanzar();
        anacom.Avanzar();
        int idpersona = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : -1;
        if (datoprincipal.getIdcliente()!=idpersona) {
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", "Codigo de Dato Principal no le pertenece consulte su lista de Datos Principales para ver el codigo");
        }
        DatosprincipalesNegocio datoprincipalNegocio=new DatosprincipalesNegocio();
        datoprincipalNegocio.setDatos(datoprincipal);
        datoprincipalNegocio.modificar();
        ClienteSMTP.sendMail(correoDest, "Modificar Comentario", "Modificacion realizada Correctamente");
    }

    private void eliminarDatosPrincipales(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarDatosPrincipales(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ClienteSMTP.sendMail(correoDest, "Registrar Multimedia", "Registro realizado Correctamente el codigo de su multimedia es "+multimediaNegocio.getMultimedia().getId());
    }

    private void modificarMultimedia(Anacom anacom, String correoDest) {
        //Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", Ayuda.HELP_MODIFICARMULTIMEDIA);
            return;
        }

        // Sino, ejecutar el comando
        // Revisar los GuionBajo
        //anacom.Avanzar();
        //anacom.Avanzar();
        int id = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : -1;
        anacom.Avanzar();
        anacom.Avanzar();
        
        Multimedia multimedia=new Multimedia();
        multimedia.setId(id);
        if (!multimedia.buscar()){
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", "Codigo de Dato Principal invalido consulte su lista de Multimedia para ver el codigo");
            return;
        }
        
        if(anacom.Preanalisis().getNombre() != Token.GB)
           multimedia.setTitulo(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
        anacom.Avanzar();
        anacom.Avanzar();      
        if(anacom.Preanalisis().getNombre() != Token.GB)
           multimedia.setTipo(Integer.parseInt(Herramientas.quitarComillas(anacom.Preanalisis().getToStr())));
        anacom.Avanzar();
        anacom.Avanzar();
        int idpersona = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : -1;
        if (multimedia.getIdcliente()!=idpersona) {
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", "Codigo de Multimedia no le pertenece consulte su lista de Datos Principales para ver el codigo");
        }
        MultimediaNegocio multimediaNegocio=new MultimediaNegocio();
        multimediaNegocio.setMultimedia(multimedia);
        multimediaNegocio.modificar();
        ClienteSMTP.sendMail(correoDest, "Modificar Comentario", "Modificacion realizada Correctamente");
    }

    private void listarMultimedia(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarMultimedia(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void registrarSugerencia(Anacom anacom, String correoDest) {
        // Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();
        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Publicidad Personal", Ayuda.HELP_INSERTARMULTIMEDIA);
            return;
        }
        // Sino, ejecutar el comando
        anacom.Avanzar();
        // Atributos
        int idsugeridor = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        int receptor = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        String descripcion = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        int idmultimedia = anacom.Preanalisis().getAtributo();
        SugerenciaNegocio sugerenciaNegocio = new SugerenciaNegocio(idsugeridor, receptor, descripcion, idmultimedia);
        sugerenciaNegocio.guardar();
        ClienteSMTP.sendMail(correoDest, "Registrar Sugerencia", "Registro realizado Correctamente");
    }


    private void registrarUsuario(Anacom anacom, String correoDest) {
        // Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();
        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayudas - Publicidad Personal", Ayuda.HELP_INSERTARMULTIMEDIA);
            return;
        }
        // Sino, ejecutar el comando
        anacom.Avanzar();
        // Atributos
        String nombre = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String email = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        String password = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        anacom.Avanzar();
        anacom.Avanzar();
        int celular = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        int tipo = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        int genero = anacom.Preanalisis().getAtributo();
        anacom.Avanzar();
        anacom.Avanzar();
        String empresa = Herramientas.quitarComillas(anacom.Preanalisis().getToStr());
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio(nombre, email, password, celular, tipo, genero, empresa);
        usuarioNegocio.guardar();
        //Cliente cliente=;
        ClienteSMTP.sendMail(correoDest, "Registrar Usuario", "Registro realizado Correctamente su codigo es "+usuarioNegocio.getUsuario().getId());
    }
    
    private void modificarUsuario(Anacom anacom, String correoDest) {
        //Obtengo el Siguiente token
        anacom.Avanzar();
        Token token = anacom.Preanalisis();

        // Reviso si no es ayuda
        if (token.getNombre() == Token.HELP) {
            // Mostrar ayuda de esa funcionalidad
            // Enviar correo con la ayuda
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", Ayuda.HELP_MODIFICARUSUARIO);
            return;
        }

        // Sino, ejecutar el comando
        // Revisar los GuionBajo
        //anacom.Avanzar();
        //anacom.Avanzar();
        int id = (anacom.Preanalisis().getNombre() != Token.GB)
                ? anacom.Preanalisis().getAtributo()
                : -1;
        anacom.Avanzar();
        anacom.Avanzar();
        
        Usuario usuario=new Usuario();
        Persona persona= new Persona();
        UsuarioNegocio usuarioNegocio=new UsuarioNegocio(correoDest, correoDest, correoDest, id, id, id, correoDest);
        if (!usuarioNegocio.buscarPorCorreo()){
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", "Codigo de Usuario invalido");
            return;
        }
        usuario=usuarioNegocio.getUsuario();
        persona=usuarioNegocio.getPersona();
        //nombre
        if(anacom.Preanalisis().getNombre() != Token.GB)
           persona.setNombrecompleto(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
        anacom.Avanzar();
        anacom.Avanzar();      
        //password
        if(anacom.Preanalisis().getNombre() != Token.GB)
           persona.setPassword(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
        anacom.Avanzar();
        anacom.Avanzar();
        //celular
        if(anacom.Preanalisis().getNombre() != Token.GB)
                persona.setCelular(anacom.Preanalisis().getAtributo());
        anacom.Avanzar();
        anacom.Avanzar();
        //genero
        if(anacom.Preanalisis().getNombre() != Token.GB)
                persona.setGenero(anacom.Preanalisis().getAtributo());
        anacom.Avanzar();
        anacom.Avanzar();      
        //empresa
        if(anacom.Preanalisis().getNombre() != Token.GB)
           usuario.setEmpresa(Herramientas.quitarComillas(anacom.Preanalisis().getToStr()));
        if (persona.getId()!=id) {
            ClienteSMTP.sendMail(correoDest, "Ayuda - Publicidad Personal", "Codigo de Usuario no le pertenece");
        }
        usuarioNegocio=new UsuarioNegocio();
        usuarioNegocio.setPersona(persona);
        usuarioNegocio.setUsuario(usuario);
        usuarioNegocio.modificar();
        ClienteSMTP.sendMail(correoDest, "Modificar Usuario", "Modificacion realizada Correctamente");
    }

    private void eliminarUsuario(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void listarUsuario(Anacom anacom, String destinatario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}