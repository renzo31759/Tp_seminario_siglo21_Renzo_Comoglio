
package logica;

public class Nodo {
   
    private int id_nodo;
    private double geolocalizacion;
    private int id_gateway;
    private String estado;

    public Nodo() {
    }

    public Nodo(int id_nodo, double geolocalizacion, int id_gateway, String estado) {
        this.id_nodo = id_nodo;
        this.geolocalizacion = geolocalizacion;
        this.id_gateway = id_gateway;
        this.estado = estado;
    }

    public int getId_nodo() {
        return id_nodo;
    }

    public void setId_nodo(int id_nodo) {
        this.id_nodo = id_nodo;
    }

    public double getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(double geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }

    public int getId_gateway() {
        return id_gateway;
    }

    public void setId_gateway(int id_gateway) {
        this.id_gateway = id_gateway;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    public void cambiarGeolocalizacion (double nuevaGeolocalizacion) {
        
        this.geolocalizacion = nuevaGeolocalizacion;
        
    }
    
    
    public double obtenerGeolocalizacion () {
        return this.geolocalizacion;
        
    }
    
    
    public int obtenerId () {
        
        return this.id_nodo;
        
    }
    
  
    public void actualizarDatosNodo (int nuevoId, double nuevaGeolocalizacion) {
        
        this.id_nodo = nuevoId;
        this.geolocalizacion = nuevaGeolocalizacion;
        
    }
    
    
    public void asociarSensores () {
        
    }
    
    @Override
    public String toString() {
        return "Nodo ID: " + id_nodo + ", Geolocalización: " + geolocalizacion + ", Estado: " + estado;
    }
    
    
    
}
