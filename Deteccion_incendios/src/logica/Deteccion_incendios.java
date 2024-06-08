package logica;

import logica.*;

public class Deteccion_incendios {
    public static void main(String[] args) {
        NodoServicios nodoServicios = new NodoServicios();
        SensorServicios sensorServicios = new SensorServicios();
        GatewayServicios gatewayServicios = new GatewayServicios();
        DatoSensorServicios datoSensorServicios = new DatoSensorServicios(); // Agregar esta línea

        Menu menu = new Menu(nodoServicios, sensorServicios, gatewayServicios, datoSensorServicios); // Pasar datoSensorServicios al constructor
        menu.mostrarMenu();
    }
}


