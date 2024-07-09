import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StageSelectController {

    public GetAPIAnswer apiAnswer;

    @FXML
    private ImageView leaderBoardBtn;
    @FXML
    private ImageView stage1Btn;
    @FXML
    private ImageView stage2Btn;
    @FXML
    private ImageView stage3Btn;
    @FXML
    private ImageView modelBtn;

    @FXML
    private void jmpStage1() {
        jmpStage(1);
    }

    @FXML
    private void jmpStage2() {
        jmpStage(2);
    }

    @FXML
    private void jmpStage3() {
        jmpStage(3);
    }

    @FXML
    private void leaderBoard() {
        // 在这里添加显示排行榜的代码
        try {
            Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/leaderboard.fxml"))));
            Main.primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            // 可以在这里添加日志记录或显示错误信息给用户
        }
    }

    private void jmpStage(int stageId) {
        try {
            Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxml/stage" + stageId + ".fxml"))));
            Main.primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            // 可以在这里添加日志记录或显示错误信息给用户
        }
    }

    @FXML
    private void model() {
        try {
            GetAPIAnswer.start();
        } catch (Exception e) {
            e.printStackTrace();
            // 可以在这里添加日志记录或显示错误信息给用户
        }
    }
}
