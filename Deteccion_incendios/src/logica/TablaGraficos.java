
package logica;


public class TablaGraficos {
    
    private int id_sensor;
    private String nombre_dato;
    private int dato;

    public TablaGraficos() {
    }

    public TablaGraficos(int id_sensor, String nombre_dato, int dato) {
        this.id_sensor = id_sensor;
        this.nombre_dato = nombre_dato;
        this.dato = dato;
    }

    public int getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(int id_sensor) {
        this.id_sensor = id_sensor;
    }

    public String getNombre_dato() {
        return nombre_dato;
    }

    public void setNombre_dato(String nombre_dato) {
        this.nombre_dato = nombre_dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
    
    public void mostrarGrafico() {
        
    }
    
}
