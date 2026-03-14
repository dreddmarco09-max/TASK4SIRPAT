import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Repository {
    private String url = "jdbc:sqlserver://LAPTOP-I6GCH1M5;databaseName=HardwareDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";

    
    public List<Hardware> getHardwareData() {
        List<Hardware> data = new ArrayList<>();
        
        String query = "SELECT id, brand, spec, type FROM HardwareInventory";
    
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                int spec = rs.getInt("spec");
                String type = rs.getString("type"); 

                
                if (type.equalsIgnoreCase("Laptop")) {
                    data.add(new Laptop(id, brand, spec));
                } else if (type.equalsIgnoreCase("Phone")) {
                    data.add(new Phone(id, brand, spec));
                }
            }
        } catch (SQLException e) {
            System.err.println("Database Retrieval Error: " + e.getMessage());
        }
        return data;
    }
    public void addHardware(String brand, int spec, String type) {
        String sql = "INSERT INTO HardwareInventory (brand, spec, type) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, brand);
            pstmt.setInt(2, spec);
            pstmt.setString(3, type);
            
            pstmt.executeUpdate();
            System.out.println(">>> Success: Record added to HardwareDB.");
            
        } catch (SQLException e) {
            System.err.println("Database Insert Error: " + e.getMessage());
        }
    }
}