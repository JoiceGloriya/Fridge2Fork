import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecipeDatabasePopulator {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/database-tables.sql";
        String user = "root";
        String password = "Joice@123456";

        try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
             Statement stmt = conn.createStatement()) {
          
            stmt.execute("CREATE TABLE IF NOT EXISTS recipes (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "CookingMinutes INT," +
                    "DairyFree BOOLEAN," +
                    "GlutenFree BOOLEAN," +
                    "Instructions TEXT," +
                    "PreparationMinutes INT," +
                    "PricePerServing DECIMAL(10,2)," +
                    "ReadyInMinutes INT," +
                    "Servings INT," +
                    "SpoonacularScore DECIMAL(5,2)," +
                    "Title VARCHAR(255)," +
                    "Vegan BOOLEAN," +
                    "Vegetarian BOOLEAN)");

            
            BufferedReader reader = new BufferedReader(new FileReader("recipe.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String insertQuery = "INSERT INTO recipes (CookingMinutes, DairyFree, GlutenFree, Instructions, PreparationMinutes, PricePerServing, ReadyInMinutes, Servings, SpoonacularScore, Title, Vegan, Vegetarian) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setInt(1, Integer.parseInt(data[0]));
                pstmt.setBoolean(2, Boolean.parseBoolean(data[1]));
                pstmt.executeUpdate();
            }
            reader.close();

            System.out.println("Data inserted successfully!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
