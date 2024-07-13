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
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaderboardController {

    @FXML
    private TableView<PlayerRecord> leaderboardTable;

    @FXML
    private TableColumn<PlayerRecord, String> usernameColumn;

    @FXML
    private TableColumn<PlayerRecord, Integer> remaining_healthColumn;

    @FXML
    private TableColumn<PlayerRecord, Integer> consumed_coinsColumn;

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
        remaining_healthColumn.setCellValueFactory(new PropertyValueFactory<>("remaining_health"));
        consumed_coinsColumn.setCellValueFactory(new PropertyValueFactory<>("consumed_coins"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        ObservableList<PlayerRecord> data = FXCollections.observableArrayList();
        try {
            ResultSet rs = DatabaseManager.getPlayerRecords();
            while (rs.next()) {
                data.add(new PlayerRecord(rs.getString("username"), rs.getInt("remaining_health"), rs.getInt("consumed_coins"), rs.getInt("score")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        leaderboardTable.setItems(data);
    }

    public void reloadData() {
        ObservableList<PlayerRecord> data = FXCollections.observableArrayList();
        try {
            ResultSet rs = DatabaseManager.getPlayerRecords();
            while (rs.next()) {
                data.add(new PlayerRecord(rs.getString("username"), rs.getInt("remaining_health"), rs.getInt("consumed_coins"), rs.getInt("score")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        leaderboardTable.setItems(data);
    }

    public static class PlayerRecord {
        private final String username;
        private final Integer remaining_health ;
        private final Integer consumed_coins;
        private final Integer score;

        public PlayerRecord(String username, Integer remaining_health, Integer consumed_coins, Integer score) {
            this.username = username;
            this.remaining_health = remaining_health;
            this.consumed_coins = consumed_coins;
            this.score = score;
        }

        public String getUsername() {
            return username;
        }

        public Integer getRemaining_health() {
            return remaining_health;
        }

        public Integer getConsumed_coins() {
            return consumed_coins;
        }

        public Integer getScore() {
            return score;
        }
    }
}
