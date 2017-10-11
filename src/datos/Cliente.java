package datos;
/**
 * @author Antonio Arce
 * @version 1.0
 * @created 07-oct.-2017 6:09:17
 */
public class Cliente extends Plantilla {

    private int id;
    private String direccion;
    private String web;
    private int vistos;
    private int publicaciones;

    public Cliente() {

    }

    public Cliente(int id, String direccion, String web, int vistos, int publicaciones) {
        this.id = id;
        this.direccion = direccion;
        this.web = web;
        this.vistos = vistos;
        this.publicaciones = publicaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getVistos() {
        return vistos;
    }

    public void setVistos(int vistos) {
        this.vistos = vistos;
    }

    public int getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(int publicaciones) {
        this.publicaciones = publicaciones;
    }

    @Override
    public String insertar() {
        return "insert into cliente(id,direccion,web,vistos,publicaciones) values("+id+",'"+direccion+"','"+web+"',"+vistos+","+publicaciones+")";
    }

    @Override
    public String actualizar() {
        return "update cliente set direccion='"+direccion+"',web='"+web+"',vistos="+vistos+",publicaciones="+publicaciones+"  where id="+id;
    }

    @Override
    public String eliminar() {
        return "delete from cliente where id="+id;
    }

    @Override
    public String listar() {
        return "select * from cliente";
    }

    @Override
    public int cantidadAtributos() {
        return 5;
    }
    
    

}
