import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static List<LeaderboardController.PlayerRecord> getLeaderboard() {
        List<LeaderboardController.PlayerRecord> records = new ArrayList<>();
        String query = "SELECT username, health, coins, score FROM leaderboard";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int health = resultSet.getInt("health");
                int coins = resultSet.getInt("coins");
                int score = resultSet.getInt("score");

                records.add(new LeaderboardController.PlayerRecord(username, health, coins, score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return records;
    }
}
