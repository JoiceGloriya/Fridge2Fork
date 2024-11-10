import java.sql.*;

public class RecipeDatabase {
    public static void main(String[] args) {
        try {
           
            String url = "";
            String user = "your_username";
            String password = "your_password";

            
            Connection conn = DriverManager.getConnection(url, user, password);

         
            Statement stmt = conn.createStatement();

            
            String createTableQuery = "CREATE TABLE Recipes (" +
                    "recipe_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "title VARCHAR(255)," +
                    "instructions TEXT," +
                    "preparation_minutes INT," +
                    "cooking_minutes INT," +
                    "servings INT," +
                    "price_per_serving DECIMAL(10,2)," +
                    "ready_in_minutes INT," +
                    "spoonacular_score INT," +
                    "vegan BOOLEAN," +
                    "vegetarian BOOLEAN," +
                    "dairy_free BOOLEAN," +
                    "gluten_free BOOLEAN)";
            stmt.executeUpdate(createTableQuery);

           
            String insertQuery = "INSERT INTO Recipes (title, instructions, preparation_minutes, cooking_minutes, servings, price_per_serving, ready_in_minutes, spoonacular_score, vegan, vegetarian, dairy_free, gluten_free) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(insertQuery);
            preparedStmt.setString(1, "Vegan Chili");
            preparedStmt.setString(2, "Instructions for vegan chili");
           
            preparedStmt.executeUpdate();

            
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
