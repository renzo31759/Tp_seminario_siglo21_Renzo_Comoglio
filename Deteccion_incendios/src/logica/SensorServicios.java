package logica;

import persistencia.DatabaseConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SensorServicios {

    public List<Sensor> obtenerTodosLosSensores() {
        List<Sensor> sensores = new ArrayList<>();
        String sql = "SELECT * FROM Sensor";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Sensor sensor = new Sensor(
                    rs.getInt("IDSensor"),
                    rs.getInt("IDNodo"),
                    rs.getString("Nombre")
                );
                sensores.add(sensor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sensores;
    }

    public void agregarSensor(Sensor sensor) {
        String sql = "INSERT INTO Sensor (IDSensor, IDNodo, Nombre) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, sensor.getId_sensor());
            pstmt.setInt(2, sensor.getId_nodo());
            pstmt.setString(3, sensor.getNombre());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarSensor(int id_sensor) {
        String sql = "DELETE FROM Sensor WHERE IDSensor = ?";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_sensor);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Sensor> obtenerSensoresPorNodo(int id_nodo) {
        List<Sensor> sensoresPorNodo = new ArrayList<>();
        String sql = "SELECT * FROM Sensor WHERE IDNodo = ?";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_nodo);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Sensor sensor = new Sensor(
                        rs.getInt("IDSensor"),
                        rs.getInt("IDNodo"),
                        rs.getString("Nombre")
                    );
                    sensoresPorNodo.add(sensor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sensoresPorNodo;
    }
}




