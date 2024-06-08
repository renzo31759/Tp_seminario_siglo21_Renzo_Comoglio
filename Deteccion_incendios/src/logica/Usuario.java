
package logica;

import java.util.Date;


public class Usuario extends Persona {
    
    private int id_tipo;
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(int id_tipo, String usuario, String password, int id_persona, String dni, 
            String nombre, String apellido, Date fecha_nac, String direccion, String ciudad, 
            String nacionalidad, String telefono, String email) {
        super(id_persona, dni, nombre, apellido, fecha_nac, direccion, ciudad, nacionalidad, telefono, email);
        this.id_tipo = id_tipo;
        this.usuario = usuario;
        this.password = password;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
    
}
