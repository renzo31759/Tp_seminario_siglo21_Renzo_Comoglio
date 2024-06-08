
package logica;


public class Sensor {
    
    private int id_sensor;
    private int id_nodo;
    private String nombre;

    public Sensor() {
    }

    public Sensor(int id_sensor, int id_nodo, String nombre) {
        this.id_sensor = id_sensor;
        this.id_nodo = id_nodo;
        this.nombre = nombre;
    }

    public int getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(int id_sensor) {
        this.id_sensor = id_sensor;
    }

    public int getId_nodo() {
        return id_nodo;
    }

    public void setId_nodo(int id_nodo) {
        this.id_nodo = id_nodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void obtenerDatos() {
       
    }

    public void enviarDatos() {
       
    }

    public void actualizarConfiguracion() {
       
    }

    public void asociarNodo(int nodoID) {
        this.id_nodo = nodoID;
        
    }
    
}
