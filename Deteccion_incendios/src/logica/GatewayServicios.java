package logica;

import persistencia.DatabaseConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GatewayServicios {
    
    public void agregarGateway(Gateway gateway) {
        String sql = "INSERT INTO Gateway (ID, Mac, Geolocalización) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gateway.getId_gateway());
            pstmt.setString(2, gateway.getMac());
            pstmt.setDouble(3, gateway.getGeolocalizacion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarGateway(int id) {
        String sql = "DELETE FROM Gateway WHERE ID = ?";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Gateway> obtenerTodosLosGateway() {
        List<Gateway> gateways = new ArrayList<>();
        String sql = "SELECT * FROM Gateway";
        try (Connection conn = DatabaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Gateway gateway = new Gateway(
                    rs.getInt("ID"),
                    rs.getString("Mac"),
                    rs.getDouble("Geolocalización")
                );
                gateways.add(gateway);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gateways;
    }
}



    
    
    
    

