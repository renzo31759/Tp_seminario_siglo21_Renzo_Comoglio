package logica;

import percistencia.DatabaseConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NodoServicios {
    
    public void agregarNodo(Nodo nodo) {
        String sql = "INSERT INTO Nodos (IDNodo, Geolocalización, ID_Gateway, Estado) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, nodo.getId_nodo());
            pstmt.setDouble(2, nodo.getGeolocalizacion());
            pstmt.setInt(3, nodo.getId_gateway());
            pstmt.setString(4, nodo.getEstado());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public List<Nodo> obtenerTodosLosNodos() {
        List<Nodo> nodos = new ArrayList<>();
        String sql = "SELECT * FROM Nodos";

        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id_nodo = rs.getInt("IDNodo");
                double geolocalizacion = rs.getDouble("Geolocalización");
                int id_gateway = rs.getInt("ID_Gateway");
                String estado = rs.getString("Estado");

                Nodo nodo = new Nodo(id_nodo, geolocalizacion, id_gateway, estado);
                nodos.add(nodo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nodos;
    }

    
    public Nodo obtenerNodoPorId(int idNodo) {
        String sql = "SELECT * FROM Nodos WHERE IDNodo = ?";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idNodo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int id_nodo = rs.getInt("IDNodo");
                    double geolocalizacion = rs.getDouble("Geolocalización");
                    int id_gateway = rs.getInt("ID_Gateway");
                    String estado = rs.getString("Estado");

                    return new Nodo(id_nodo, geolocalizacion, id_gateway, estado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    
    public void eliminarNodo(int idNodo) {
        String sql = "DELETE FROM Nodos WHERE IDNodo = ?";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idNodo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
    
    

