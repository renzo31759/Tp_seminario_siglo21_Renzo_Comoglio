package logica;

import java.util.Date;

public class DatoSensor {
    private int id_sensor;
    private String fecha;
    private Date hora;
    private int valor;
    private int valor_normal;

    public DatoSensor() {
    }

    public DatoSensor(int id_sensor, String fecha, Date hora, int valor, int valor_normal) {
        this.id_sensor = id_sensor;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
        this.valor_normal = valor_normal;
    }

    public int getId_sensor() {
        return id_sensor;
    }

    public String getFecha() {
        return fecha;
    }

    public Date getHora() {
        return hora;
    }

    public int getValor() {
        return valor;
    }

    public int getValor_normal() {
        return valor_normal;
    }

    // Métodos específicos
    public String obtenerFecha() {
        return fecha;
    }

    public Date obtenerHora() {
        return hora;
    }

    public int obtenerValor() {
        return valor;
    }

    public int obtenerValor_normal() {
        return valor_normal;
    }

    public void guardarDatos(int id_sensor, String fecha, Date hora, int valor, int valor_normal) {
        this.id_sensor = id_sensor;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
        this.valor_normal = valor_normal;
    }

    public DatoSensor consultarDatosPorFecha(String fecha) {
        if (this.fecha.equals(fecha)) {
            return new DatoSensor(this.id_sensor, this.fecha, this.hora, this.valor, this.valor_normal);
        }
        return null;
    }
}

