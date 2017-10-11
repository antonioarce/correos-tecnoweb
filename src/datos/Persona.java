package datos;


public class Persona extends Plantilla{

    private int id;
    private String nombrecompleto;
    private String email;
    private String password;
    private String authkey;
    private String accesstoken;
    private String avatar;
    private int celular;
    private int tipo;
    private int genero;

    public Persona() {

    }

    public Persona(int id, String nombrecompleto, String email, String password, String authkey, String accesstoken, String avatar, int celular, int tipo, int genero) {
        this.id = id;
        this.nombrecompleto = nombrecompleto;
        this.email = email;
        this.password = password;
        this.authkey = authkey;
        this.accesstoken = accesstoken;
        this.avatar = avatar;
        this.celular = celular;
        this.tipo = tipo;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthkey() {
        return authkey;
    }

    public void setAuthkey(String authkey) {
        this.authkey = authkey;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    @Override
    public String insertar() {
        return "insert into persona(nombrecompleto,email,password,authkey,accesstoken,avatar,celular,tipo,genero) values('"+nombrecompleto+"','"
                +email+"','"+
                password+"','"
                +authkey+"','"
                +accesstoken+"','"
                +avatar+"',"
                +celular+","
                +tipo+","
                +genero
                +")";
    }

    @Override
    public String actualizar() {
        return "update persona set "
                +"nombrecompleto='"+nombrecompleto+"',"
                +"email='"+email+"',"
                +"password='"+password+"',"
                +"authkey='"+authkey+"',"
                +"accesstoken='"+accesstoken+"',"
                +"avatar='"+avatar+"',"
                +"celular="+celular+","
                +"tipo="+tipo+","
                +"genero="+genero+" "
                +" where id="+id;
    }

    @Override
    public String eliminar() {
        return "delete from persona where id="+id;
    }

    @Override
    public String listar() {
        return "select * from persona";
    }

    @Override
    public int cantidadAtributos() {
        return 10;
    }
    
    

}
