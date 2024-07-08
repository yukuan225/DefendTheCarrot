import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class LeaderboardController {

    @FXML
    private TableView<PlayerRecord> leaderboardTable;

    @FXML
    private TableColumn<PlayerRecord, String> usernameColumn;

    @FXML
    private TableColumn<PlayerRecord, Integer> healthColumn;

    @FXML
    private TableColumn<PlayerRecord, Integer> coinsColumn;

    @FXML
    private TableColumn<PlayerRecord, Integer> scoreColumn;

    @FXML
    private void handleBackButton() {
        Stage stage = (Stage) leaderboardTable.getScene().getWindow();
        try {
            Scene previousScene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/stageselect.fxml")));
            stage.setScene(previousScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        healthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        coinsColumn.setCellValueFactory(new PropertyValueFactory<>("coins"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        // 示例数据
        ObservableList<PlayerRecord> data = FXCollections.observableArrayList(
                new PlayerRecord("玩家1", 100, 50, 2000),
                new PlayerRecord("玩家2", 80, 60, 1800),
                new PlayerRecord("玩家3", 90, 40, 2200)
        );

        leaderboardTable.setItems(data);
    }

    public static class PlayerRecord {
        private final String username;
        private final Integer health;
        private final Integer coins;
        private final Integer score;

        public PlayerRecord(String username, Integer health, Integer coins, Integer score) {
            this.username = username;
            this.health = health;
            this.coins = coins;
            this.score = score;
        }

        public String getUsername() {
            return username;
        }

        public Integer getHealth() {
            return health;
        }

        public Integer getCoins() {
            return coins;
        }

        public Integer getScore() {
            return score;
        }
    }
}
