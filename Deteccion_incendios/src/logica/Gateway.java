
package logica;


public class Gateway {
    
    private int id_gateway;
    private String mac;
    private Double geolocalizacion;

    public Gateway() {
    }
    
    
    public Gateway(int id_gateway, String mac, Double geolocalizacion) {
        this.id_gateway = id_gateway;
        this.mac = mac;
        this.geolocalizacion = geolocalizacion;
    }

    public int getId_gateway() {
        return id_gateway;
    }

    public void setId_gateway(int id_gateway) {
        this.id_gateway = id_gateway;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Double getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(Double geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }
    
    
     
    public void enviarDatosMQTT() {
        
        System.out.println("Enviando datos mediante MQTT...");
    }

    
    public void recibirDatos() {
        
        System.out.println("Recibiendo datos...");
    }

  
    public void actualizarConfiguracion() {
        
        System.out.println("Actualizando configuración...");
    }
    
    
}
