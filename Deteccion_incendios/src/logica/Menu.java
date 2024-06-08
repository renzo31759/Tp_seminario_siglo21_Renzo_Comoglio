package logica;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private NodoServicios nodoServicios;
    private SensorServicios sensorServicios;
    private GatewayServicios gatewayServicios;
    private DatoSensorServicios datoSensorServicios; 
    private Scanner teclado;

    public Menu(NodoServicios nodoServicios, SensorServicios sensorServicios, 
            GatewayServicios gatewayServicios, DatoSensorServicios datoSensorServicios) { 
        this.nodoServicios = nodoServicios;
        this.sensorServicios = sensorServicios;
        this.gatewayServicios = gatewayServicios;
        this.datoSensorServicios = datoSensorServicios; 
        this.teclado = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Menú Principal:");
            System.out.println("1. Gestionar Nodos");
            System.out.println("2. Gestionar Sensores");
            System.out.println("3. Gestionar Gateway");
            System.out.println("4. Salir");
            System.out.println("---------------------");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> gestionarNodos();
                case 2 -> gestionarSensores();
                case 3 -> gestionarGateway();
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void gestionarNodos() {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("-------------------------");
            System.out.println("Gestionar Nodos:");
            System.out.println("1. Ver ubicación de nodos");
            System.out.println("2. Agregar nodo");
            System.out.println("3. Eliminar nodo");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> mostrarUbicacionNodos();
                case 2 -> agregarNodo();
                case 3 -> eliminarNodo();
                case 4 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void mostrarUbicacionNodos() {
        System.out.println("Ubicación de Nodos:");
        List<Nodo> nodos = nodoServicios.obtenerTodosLosNodos();
        if (nodos.isEmpty()) {
            System.out.println("No hay nodos cargados.");
        } else {
            for (Nodo nodo : nodos) {
                System.out.println(nodo);
            }
        }
    }

    private void agregarNodo() {
        System.out.println("--------------------");
        System.out.print("Ingrese ID del Nodo: ");
        int id = teclado.nextInt();
        System.out.print("Ingrese Geolocalización del Nodo: ");
        double geolocalizacion = teclado.nextDouble();
        System.out.print("Ingrese ID del Gateway: ");
        int idGateway = teclado.nextInt();
        teclado.nextLine(); // Consumir la nueva línea
        System.out.print("Ingrese el Estado del Nodo: ");
        String estado = teclado.nextLine();

        Nodo nodo = new Nodo(id, geolocalizacion, idGateway, estado);
        nodoServicios.agregarNodo(nodo);
        System.out.println("Nodo agregado exitosamente.");
    }

    private void eliminarNodo() {
        System.out.println("------------------");
        System.out.print("Ingrese ID del Nodo a eliminar: ");
        int id = teclado.nextInt();
        nodoServicios.eliminarNodo(id);
        System.out.println("Nodo eliminado exitosamente.");
    }

    private void gestionarSensores() {
    System.out.println("-------------------");
    System.out.println("Gestión de Sensores:");
    System.out.print("Ingrese ID del Nodo: ");
    int idNodo = teclado.nextInt();

    System.out.println("Datos de los Sensores del Nodo " + idNodo + ":");
    List<Sensor> sensores = sensorServicios.obtenerSensoresPorNodo(idNodo);

    for (Sensor sensor : sensores) {
        System.out.println("Datos del Sensor " + sensor.getNombre() + " (ID: " + sensor.getId_sensor() + "):");
        List<DatoSensor> datosSensor = datoSensorServicios.obtenerDatosPorSensor(sensor.getId_sensor());
        for (DatoSensor dato : datosSensor) {
            System.out.println("Fecha: " + dato.obtenerFecha() + ", Hora: " + dato.obtenerHora() + ","
                    + " Valor: " + dato.obtenerValor() + ", Valor Normal: " + dato.getValor_normal());
        }
    }
}


    private void gestionarGateway() {
        System.out.println("-------------------");
        System.out.println("Gestión de Gateway:");
        System.out.println("1. Ver ubicación de gateway");
        System.out.println("2. Agregar gateway");
        System.out.println("3. Eliminar gateway");
        System.out.print("Seleccione una opción: ");
        int opcion = teclado.nextInt();

        switch (opcion) {
            case 1 -> mostrarUbicacionGateway();
            case 2 -> agregarGateway();
            case 3 -> eliminarGateway();
            default -> System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    private void mostrarUbicacionGateway() {
        System.out.println("-------------------");
        System.out.println("Ubicación de Gateway:");
        List<Gateway> gateways = gatewayServicios.obtenerTodosLosGateway();
        if (gateways.isEmpty()) {
            System.out.println("No hay gateways cargados.");
        } else {
            for (Gateway gateway : gateways) {
                System.out.println(gateway);
            }
        }
    }

    private void agregarGateway() {
        System.out.println("--------------------");
        System.out.print("Ingrese ID del Gateway: ");
        int id = teclado.nextInt();
        teclado.nextLine(); 
        System.out.print("Ingrese Mac del Gateway: ");
        String mac = teclado.nextLine();
        System.out.print("Ingrese Geolocalización del Gateway: ");
        double geolocalizacion = teclado.nextDouble();

        Gateway gateway = new Gateway(id, mac, geolocalizacion);
        gatewayServicios.agregarGateway(gateway);
        System.out.println("Gateway agregado exitosamente.");
    }

    private void eliminarGateway() {
        System.out.print("Ingrese ID del Gateway a eliminar: ");
        int id = teclado.nextInt();
        gatewayServicios.eliminarGateway(id);
        System.out.println("Gateway eliminado exitosamente.");
    }
}
