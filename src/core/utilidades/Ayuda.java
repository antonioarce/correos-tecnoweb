/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.utilidades;

/**
 *
 * @author mauriballes
 */
public class Ayuda {

    public static final String HELP_GLOBAL = "Bienvenido!!!\n\n"
            + "A continuacion se listaran los comandos disponibles para interactuar con el sistema\n"
            + "Para acceder a la documentacion de cada uno, enviar el nombre del comando seguido de la palabra HELP\n\n"
            + "INSERTARCLIENTE\n"
            + "MODIFICARCLIENTE\n"
            + "ELIMINARCLIENTE\n"
            + "LISTARCLIENTE\n"
            
            + "INSERTARCOMENTARIO\n"
            + "MODIFICARCOMENTARIO\n"
            + "ELIMINARCOMENTARIO\n"
            + "LISTARCOMENTARIO\n"
            
            + "INSERTARCONTACTO\n"
            + "MODIFICARCONTACTO\n"
            + "ELIMINARCONTACTO\n"
            + "LISTARCONTACTO\n"
            
            + "INSERTARDATOSPRINCIPALES\n"
            + "MODIFICARDATOSPRINCIPALES\n"
            + "ELIMINARDATOSPRINCIPALES\n"
            + "LISTARDATOSPRINCIPALES\n"
            
            + "INSERTARMULTIMEDIA\n"
            + "MODIFICARMULTIMEDIA\n"
            + "ELIMINARMULTIMEDIA\n"
            + "LISTARMULTIMEDIA\n"
            
            + "INSERTARPERSONA\n"
            + "MODIFICARPERSONA\n"
            + "ELIMINARPERSONA\n"
            + "LISTARPERSONA\n"
            
            + "INSERTARSUGERENCIA\n"
            + "MODIFICARSUGERENCIA\n"
            + "ELIMINARSUGERENCIA\n"
            + "LISTARSUGERENCIA\n"
            
            + "INSERTARUSUARIO\n"
            + "MODIFICARUSUARIO\n"
            + "ELIMINARUSUARIO\n"
            + "LISTARUSUARIO\n";
    public static final String HELP_INSERTARCLIENTE = "Insertar Cliente!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es registrar a un cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- direccion (String con Comillas Dobles)\n"
            + "- web (String con Comillas Dobles)\n";
    public static final String HELP_MODIFICARCLIENTE = "Modificar Cliente!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar a un cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "- direccion (String con Comillas Dobles)\n"
            + "- web (String con Comillas Dobles)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "id, direccion, web";
    public static final String HELP_ELIMINARCLIENTE = "Eliminar Cliente!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un cliente registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARCLIENTE = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    
    
    public static final String HELP_INSERTARCOMENTARIO = "Insertar Comentario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un comentario en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- idMultimedia (Entero)\n"
            + "- idPersona (Entero)\n";
    public static final String HELP_MODIFICARCOMENTARIO = "Modificar Comentario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar un comentario en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- idMultimedia (Entero)\n"
            + "- idPersona (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "descripcion, idMultimedia, idPersona";
    public static final String HELP_ELIMINARCOMENTARIO = "Eliminar Comentario!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un cliente registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARCOMENTARIO = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    
    
    public static final String HELP_INSERTARCONTACTO = "Insertar Contacto!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un contacto en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- idcliente (Entero)\n"
            + "- idusuario (Entero)\n";
    public static final String HELP_ELIMINARCONTACTO = "Elimina Contacto!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un contacto registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARCONTACTO = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    
    
    public static final String HELP_INSERTARDATOSPRINCIPALES = "Insertar Datos Principales!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un dato principal del cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- idcliente (Entero)\n";
    public static final String HELP_MODIFICARDATOSPRINCIPALES = "Modificar Datos Principal!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar un dato principal del cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- descripcion (String con Comillas Dobles)\n"
            + "- idcliente (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "titulo, descripcion, idcliente";
    public static final String HELP_ELIMINARDATOSPRINCIPALES = "Eliminar Datos Principal!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un dato principal registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARDATOSPRINCIPALES = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    
    
    public static final String HELP_INSERTARMULTIMEDIA = "Insertar Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un archivo multimedia del cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- tipo (Entero 1 si es foto 2 si es video)\n"
            + "- idcliente (Entero)\n";
    public static final String HELP_MODIFICARMULTIMEDIA = "Modificar Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar un dato principal del cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- tipo (Entero 1 si es foto 2 si es video)\n"
            + "- idcliente (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "titulo, descripcion, idcliente";
    public static final String HELP_ELIMINARMULTIMEDIA = "Eliminar Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un multimedia registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARMULTIMEDIA = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";
    
    /*
    public static final String HELP_INSERTARMULTIMEDIA = "Insertar Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es insertar a un archivo multimedia del cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- tipo (Entero 1 si es foto 2 si es video)\n"
            + "- idcliente (Entero)\n";
    public static final String HELP_MODIFICARMULTIMEDIA = "Modificar Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es modificar un dato principal del cliente en el sistema.\n"
            + "\n"
            + "PARAMETROS:\n" 
            + "\n"
            + "- titulo (String con Comillas Dobles)\n"
            + "- tipo (Entero 1 si es foto 2 si es video)\n"
            + "- idcliente (Entero)\n"
            + "\n"
            + "OPCIONALES: (Usar guion bajo \"_\" para decir no cambiar)\n"
            + "\n"
            + "titulo, descripcion, idcliente";
    public static final String HELP_ELIMINARMULTIMEDIA = "Eliminar Multimedia!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es Eliminar a un multimedia registrados en el sistema,\n"
            + "\n"
            + "PARAMETROS:\n"
            + "\n"
            + "- id (Entero)\n"
            + "Mensaje:\n "
            + "\n"
            + "Eliminacion exitosa.";
    public static final String HELP_LISTARMULTIMEDIA = "Lista De Registros!!!\n"
            + "\n"
            + "Lo que hace el siguiente comando es listar los registros de la tabla en el sistema,\n"
            + "no es necesario enviar ningun parametros";*/
}
