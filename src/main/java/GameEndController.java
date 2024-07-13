import java.sql.SQLException;

public class GameEndController {

    public void onGameEnd(String username, int remainingHealth, int consumedCoins, int score) {
        try {
            // 更新数据库
            DatabaseManager.updatePlayerRecord(username, remainingHealth, consumedCoins, score);

            // 重新加载排行榜
            reloadLeaderboard();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void reloadLeaderboard() {
        LeaderboardController controller = new LeaderboardController();
        controller.reloadData();
    }
}
