import java.sql.SQLException;

public class GameController {
    private String username;
    private int remaining_health;
    private int consumed_coins;
    private int score;

    // 假设这些值在游戏结束时被设置
    public void setGameResults(String username, int remaining_health, int consumed_coins, int score) {
        this.username = username;
        this.remaining_health = remaining_health;
        this.consumed_coins = consumed_coins;
        this.score = score;
    }

    public void saveResults() {
        try {
            DatabaseManager.savePlayerRecord(username, remaining_health, consumed_coins, score);
        } catch (SQLException e) {
            e.printStackTrace();
            // 可以在这里添加日志记录或显示错误信息给用户
        }
    }
}
