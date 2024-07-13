import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager{
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void savePlayerRecord(String username, int remaining_health, int consumed_coins, int score) throws SQLException {
        String sql = "INSERT INTO game (username, remaining_health, consumed_coins, score) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setInt(2, remaining_health);
            stmt.setInt(3, consumed_coins);
            stmt.setInt(4, score);
            stmt.executeUpdate();
        }
    }

    public static ResultSet getPlayerRecords() throws SQLException {
        String sql = "SELECT username, remaining_health, consumed_coins, score FROM game";
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        return stmt.executeQuery();
    }

    public static void updatePlayerRecord(String username, int remainingHealth, int consumedCoins, int score) throws SQLException {
        // SQL 更新语句
        String sql = "UPDATE player_records SET remaining_health = ?, consumed_coins = ?, score = ? WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, remainingHealth);
            pstmt.setInt(2, consumedCoins);
            pstmt.setInt(3, score);
            pstmt.setString(4, username);
            pstmt.executeUpdate();
        }
    }
}
