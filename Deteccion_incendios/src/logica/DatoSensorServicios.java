package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import persistencia.DatabaseConection; 
import java.sql.ResultSet;


public class DatoSensorServicios {
    private List<DatoSensor> datosSensor;

    public DatoSensorServicios() {
        this.datosSensor = new ArrayList<>();
    }

    public List<DatoSensor> obtenerTodosLosDatosSensor() {
        return datosSensor;
    }

    public void agregarDatoSensor(DatoSensor datoSensor) {
        datosSensor.add(datoSensor);

        String sql = "INSERT INTO DatoSensor (IDSensor, Fecha, Hora, Valor, Valor_normal) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, datoSensor.getId_sensor());
            pstmt.setDate(2, java.sql.Date.valueOf(datoSensor.obtenerFecha()));
            pstmt.setTime(3, new java.sql.Time(datoSensor.obtenerHora().getTime()));
            pstmt.setInt(4, datoSensor.obtenerValor());
            pstmt.setInt(5, datoSensor.getValor_normal());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarDatoSensor(int id_sensor, String fecha, Date hora) {
        datosSensor.removeIf(dato -> dato.getId_sensor() == id_sensor && dato.obtenerFecha().equals(fecha) && dato.obtenerHora().equals(hora));
    }

    public List<DatoSensor> obtenerDatosPorSensor(int id_sensor) {
    List<DatoSensor> datosPorSensor = new ArrayList<>();
    String sql = "SELECT * FROM DatoSensor WHERE IDSensor = ?";
    try (Connection conn = DatabaseConection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, id_sensor);
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int idSensor = rs.getInt("IDSensor");
                String fecha = rs.getDate("Fecha").toString();
                Date hora = rs.getTime("Hora");
                int valor = rs.getInt("Valor");
                int valorNormal = rs.getInt("Valor_normal");
                datosPorSensor.add(new DatoSensor(idSensor, fecha, hora, valor, valorNormal));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return datosPorSensor;
}

}




